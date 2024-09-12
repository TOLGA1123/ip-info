package com.app.ip_info.controller;

import com.app.ip_info.entity.HostName;
import com.app.ip_info.service.HostNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/hostnames")
public class HostNameController {

    @Autowired
    private HostNameService hostNameService;

    @GetMapping
    public ResponseEntity<List<HostName>> getAllHostNames() {
        List<HostName> hostNames = hostNameService.getAllHostNames();
        return new ResponseEntity<>(hostNames, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<HostName> addHostName(@RequestBody HostName hostName) {   //use model DTO
        HostName createdHostName = hostNameService.addHostName(hostName);
        return new ResponseEntity<>(createdHostName, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHostName(@PathVariable Long id) {
        hostNameService.deleteHostName(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
