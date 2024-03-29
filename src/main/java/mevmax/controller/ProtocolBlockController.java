package mevmax.controller;

import jakarta.annotation.Resource;
import mevmax.entity.BlockChain;
import mevmax.entity.Protocol;
import mevmax.mapper.ProtoBlockMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("")
public class ProtocolBlockController {

    @Resource
    ProtoBlockMapper pbMapper;

    @GetMapping("/protocols")
    public ResponseEntity<Map<String, Object>> getAllProtocols() {
        List<Protocol> protocols = pbMapper.findAllProtocols();
        Map<String, Object> response = new HashMap<>();
        response.put("status", HttpStatus.OK.value());
        response.put("message", "Success");
        response.put("protocols", protocols);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/blockchains")
    public ResponseEntity<Map<String, Object>> getAllBlockChains() {
        List<BlockChain> blockchains = pbMapper.findAllBlockChains();
        Map<String, Object> response = new HashMap<>();
        response.put("status", HttpStatus.OK.value());
        response.put("message", "Success");
        response.put("protocols", blockchains);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/blockchains/tvl")
    public ResponseEntity<Map<String, Object>> getTotalTvl() {
        double totalTvl = pbMapper.findTotalTvl();
        Map<String, Object> response = new HashMap<>();
        response.put("status", HttpStatus.OK.value());
        response.put("message", "Success");
        response.put("total TVL", totalTvl);
        return ResponseEntity.ok(response);
    }
    @GetMapping("/protocols/factory/{factoryAddress}")
    public ResponseEntity<Map<String, Object>> getProtocolByAddress(@PathVariable String factoryAddress){
        List<Protocol> protocols = pbMapper.findProtocolByAddress(factoryAddress);
        Map<String, Object> response = new HashMap<>();
        response.put("status", HttpStatus.OK.value());
        response.put("message", "Success");
        response.put("protocols", protocols);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/protocols/name/{protocolName}")
    public ResponseEntity<Map<String, Object>> getProtocolByName(@PathVariable String protocolName){
        List<Protocol> protocols = pbMapper.findProtocolByName(protocolName);
        Map<String, Object> response = new HashMap<>();
        response.put("status", HttpStatus.OK.value());
        response.put("message", "Success");
        response.put("protocols", protocols);
        return ResponseEntity.ok(response);
    }
}
