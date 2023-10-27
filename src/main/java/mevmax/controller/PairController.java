package mevmax.controller;

import jakarta.annotation.Resource;
import mevmax.entity.Pair;
import mevmax.entity.Pool;
import mevmax.mapper.PairMapper;
import mevmax.mapper.PoolMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/pairs")
public class PairController {
    @Resource
    PairMapper pairMapper;
    @GetMapping("/{token1_address}/{token2_address}")
    public ResponseEntity<Map<String, Object>> getPairByAddress(@PathVariable("token1_address") String token1_address,
                                                                @PathVariable("token2_address") String token2_address) {
        List<Pair> pairs;
        if (token1_address.compareTo(token2_address) < 0){
            pairs = pairMapper.findByTokenAddresses(token1_address, token2_address);
        }else{
            pairs = pairMapper.findByTokenAddresses(token2_address, token1_address);
        }
        if (pairs.isEmpty()) {
            Map<String, Object> response = new HashMap<>();
            response.put("status", HttpStatus.NOT_FOUND.value());
            response.put("message", "Pair not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }

        Map<String, Object> response = new HashMap<>();
        response.put("status", HttpStatus.OK.value());
        response.put("message", "Success");
        response.put("pair", pairs);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{token_address}")
    public ResponseEntity<Map<String, Object>> getPairByOneAddress(@PathVariable("token_address") String token_address){
        List<Pair> pairs = pairMapper.findByATokenAddress(token_address);
        if (pairs.isEmpty()) {
            Map<String, Object> response = new HashMap<>();
            response.put("status", HttpStatus.NOT_FOUND.value());
            response.put("message", "Pairs not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }

        Map<String, Object> response = new HashMap<>();
        response.put("status", HttpStatus.OK.value());
        response.put("message", "Success");
        response.put("pairs", pairs);
        return ResponseEntity.ok(response);
    }

}
