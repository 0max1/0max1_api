package mevmax.controller;

import jakarta.annotation.Resource;
import mevmax.mapper.PairMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/pairs-count")
public class PairCountController {
    @Resource
    PairMapper pairMapper;

    @GetMapping
    public ResponseEntity<Map<String, Object>> getTotalPairCount() {
        long totalTokens = pairMapper.countTotalPairs();
        Map<String, Object> response = new HashMap<>();
        response.put("status", HttpStatus.OK.value());
        response.put("message", "Success");
        response.put("total_pairs", totalTokens);
        return ResponseEntity.ok(response);
    }
}
