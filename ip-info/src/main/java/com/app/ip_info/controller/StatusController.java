package com.app.ip_info.controller;

import com.app.ip_info.entity.Status;
import com.app.ip_info.model.StatusDTO;
import com.app.ip_info.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/statuses")
public class StatusController {

    @Autowired
    private StatusService statusService;

    // Convert Entity to DTO
    private StatusDTO convertToDTO(Status status) {
        return StatusDTO.builder()
                .id(status.getId())
                .name(status.getName())
                .build();
    }

    // Convert DTO to Entity
    private Status convertToEntity(StatusDTO statusDTO) {
        return Status.builder()
                .id(statusDTO.getId())
                .name(statusDTO.getName())
                .build();
    }

    @GetMapping
    public ResponseEntity<List<StatusDTO>> getAllStatuses() {
        List<Status> statuses = statusService.getAllStatuses();
        List<StatusDTO> statusDTOs = statuses.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(statusDTOs, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<StatusDTO> addStatus(@RequestBody StatusDTO statusDTO) {
        Status status = convertToEntity(statusDTO);
        Status createdStatus = statusService.addStatus(status);
        return new ResponseEntity<>(convertToDTO(createdStatus), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStatus(@PathVariable Long id) {
        statusService.deleteStatus(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
