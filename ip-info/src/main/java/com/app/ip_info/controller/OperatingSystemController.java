package com.app.ip_info.controller;

import com.app.ip_info.entity.OperatingSystem;
import com.app.ip_info.model.OperatingSystemDTO;
import com.app.ip_info.service.OperatingSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/operating-systems")
public class OperatingSystemController {

    @Autowired
    private OperatingSystemService operatingSystemService;

    // Convert Entity to DTO
    private OperatingSystemDTO convertToDTO(OperatingSystem operatingSystem) {
        return OperatingSystemDTO.builder()
                .id(operatingSystem.getId())
                .name(operatingSystem.getName())
                .build();
    }

    // Convert DTO to Entity
    private OperatingSystem convertToEntity(OperatingSystemDTO operatingSystemDTO) {
        return OperatingSystem.builder()
                .id(operatingSystemDTO.getId())
                .name(operatingSystemDTO.getName())
                .build();
    }

    @GetMapping
    public ResponseEntity<List<OperatingSystemDTO>> getAllOperatingSystems() {
        List<OperatingSystem> operatingSystems = operatingSystemService.getAllOperatingSystems();
        List<OperatingSystemDTO> operatingSystemDTOs = operatingSystems.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(operatingSystemDTOs, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<OperatingSystemDTO> createOperatingSystem(@RequestBody OperatingSystemDTO operatingSystemDTO) {
        OperatingSystem operatingSystem = convertToEntity(operatingSystemDTO);
        OperatingSystem createdOperatingSystem = operatingSystemService.saveOperatingSystem(operatingSystem);
        return new ResponseEntity<>(convertToDTO(createdOperatingSystem), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OperatingSystemDTO> updateOperatingSystem(@PathVariable Long id, @RequestBody OperatingSystemDTO operatingSystemDTO) {
        OperatingSystem operatingSystem = convertToEntity(operatingSystemDTO);
        operatingSystem.setId(id);
        OperatingSystem updatedOperatingSystem = operatingSystemService.saveOperatingSystem(operatingSystem);
        return new ResponseEntity<>(convertToDTO(updatedOperatingSystem), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOperatingSystem(@PathVariable Long id) {
        operatingSystemService.deleteOperatingSystem(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
