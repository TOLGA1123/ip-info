package com.app.ip_info.controller;


import com.app.ip_info.entity.Status;
import com.app.ip_info.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/statuses")
public class StatusController {

    @Autowired
    private StatusService statusService;

    @GetMapping
    public ResponseEntity<List<Status>> getAllStatuses() {
        List<Status> statuses = statusService.getAllStatuses();
        return new ResponseEntity<>(statuses, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Status> addStatus(@RequestBody Status status) {   //use model DTO later
        Status createdStatus = statusService.addStatus(status);
        return new ResponseEntity<>(createdStatus, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStatus(@PathVariable Long id) {
        statusService.deleteStatus(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
