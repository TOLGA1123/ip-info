package com.app.ip_info.controller;

import com.app.ip_info.entity.IpAddress;
import com.app.ip_info.exception.IpAddressAlreadyExistsException;
import com.app.ip_info.exception.IpAddressNotFoundException;
import com.app.ip_info.model.IpRequest;
import com.app.ip_info.model.IpResponse;
import com.app.ip_info.service.IpService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.beans.BeanUtils.copyProperties;

@RestController
@RequestMapping("/info")
@Log4j2
public class IpAddressController {
    @Autowired
    private IpService ipService;

    @GetMapping("/ip")
    public List<IpAddress> getAllIpAddresses() {
        return ipService.getAllIpAddresses();
    }

    @GetMapping("/ip/{id}")
    public ResponseEntity<IpResponse> getIpAddressById(@PathVariable Long id) {
        IpResponse ipResponse = ipService.getIpAddressById(id);
        return new ResponseEntity<>(ipResponse, HttpStatus.OK);
    }

    @PostMapping("/ip")
    public ResponseEntity<IpAddress> addIpAddress(@RequestBody IpAddress ipAddress) {
        try {
            IpAddress savedIpAddress = ipService.saveIpAddress(ipAddress, false);
            return new ResponseEntity<>(savedIpAddress, HttpStatus.CREATED);
        } catch (IpAddressAlreadyExistsException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
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

    @PutMapping("/ip/{id}")
    public ResponseEntity<IpResponse> updateIpAddress(@PathVariable Long id, @RequestBody IpRequest ipRequest) {
        try {
            IpResponse existingIpResponse = ipService.getIpAddressById(id);

            existingIpResponse.setIp(ipRequest.getIp());
            existingIpResponse.setHostName(ipRequest.getHostName());
            existingIpResponse.setStatus(ipRequest.getStatus());
            existingIpResponse.setLocation(ipRequest.getLocation());
            existingIpResponse.setRelatedGroup(ipRequest.getRelatedGroup());
            existingIpResponse.setOperatingSystem(ipRequest.getOperatingSystem());

            IpAddress updatedIpAddress = new IpAddress();
            copyProperties(existingIpResponse, updatedIpAddress);

            IpAddress savedIpAddress = ipService.saveIpAddress(updatedIpAddress, true);
            
            IpResponse updatedIpResponse = new IpResponse();
            copyProperties(savedIpAddress, updatedIpResponse);

            return ResponseEntity.ok(updatedIpResponse);
        } catch (IpAddressNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        catch (IpAddressAlreadyExistsException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }
        catch (Exception e) {
            log.error("Error updating IP address", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}

