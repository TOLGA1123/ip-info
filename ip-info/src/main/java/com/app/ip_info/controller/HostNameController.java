package com.app.ip_info.controller;

import com.app.ip_info.entity.HostName;
import com.app.ip_info.model.HostNameDTO;
import com.app.ip_info.service.HostNameService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
@Slf4j
@RestController
@RequestMapping("/hostnames")
public class HostNameController {

    @Autowired
    private HostNameService hostNameService;

    // Convert Entity to DTO
    private HostNameDTO convertToDTO(HostName hostName) {
        return HostNameDTO.builder()
                .id(hostName.getId()) // Include ID
                .name(hostName.getName())
                .build();
    }

    // Convert DTO to Entity
    private HostName convertToEntity(HostNameDTO hostNameDTO) {
        return HostName.builder()
                .id(hostNameDTO.getId()) // Include ID
                .name(hostNameDTO.getName())
                .build();
    }

    @GetMapping
    public ResponseEntity<List<HostNameDTO>> getAllHostNames() {
        List<HostName> hostNames = hostNameService.getAllHostNames();
        List<HostNameDTO> hostNameDTOs = hostNames.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(hostNameDTOs, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<HostNameDTO> addHostName(@RequestBody HostNameDTO hostNameDTO) {
        HostName hostName = convertToEntity(hostNameDTO);

        HostName createdHostName = hostNameService.addHostName(hostName);
        return new ResponseEntity<>(convertToDTO(createdHostName), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHostName(@PathVariable Long id) {
        hostNameService.deleteHostName(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
