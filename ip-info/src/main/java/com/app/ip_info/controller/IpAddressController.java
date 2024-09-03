package com.app.ip_info.controller;

import com.app.ip_info.entity.IpAddress;
import com.app.ip_info.service.IpService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/info")
@CrossOrigin(origins = "http://localhost:3000")
@Log4j2
public class IpAddressController {
    @Autowired
    private IpService ipService;

    @GetMapping("/ip")
    public List<IpAddress> getAllIpAddresses(){
        return ipService.getAllIpAddresses();
    }
    @GetMapping("/ip/{id}")
    public ResponseEntity<IpAddress> getIpAddressById(@PathVariable Long id) {
        try {
            IpAddress ipAddress = ipService.getIpAddressById(id);
            return ResponseEntity.ok(ipAddress);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("/ip")
    public ResponseEntity<IpAddress> addIpAddress(@RequestBody IpAddress ipAddress) {
        try {
            IpAddress savedIpAddress = ipService.saveIpAddress(ipAddress);
            return ResponseEntity.ok(savedIpAddress);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }
    @DeleteMapping("/ip/{id}")
    public ResponseEntity<Void> deleteIpAddress(@PathVariable Long id) {
        try {
            ipService.deleteIpAddressById(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
