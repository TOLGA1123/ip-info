package com.app.ip_info.controller;

import com.app.ip_info.entity.Location;
import com.app.ip_info.model.LocationDTO;
import com.app.ip_info.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/locations")
public class LocationController {

    @Autowired
    private LocationService locationService;

    // Convert Entity to DTO
    private LocationDTO convertToDTO(Location location) {
        return LocationDTO.builder()
                .id(location.getId())
                .name(location.getName())
                .build();
    }

    // Convert DTO to Entity
    private Location convertToEntity(LocationDTO locationDTO) {
        return Location.builder()
                .id(locationDTO.getId())
                .name(locationDTO.getName())
                .build();
    }

    @GetMapping
    public ResponseEntity<List<LocationDTO>> getAllLocations() {
        List<Location> locations = locationService.getAllLocations();
        List<LocationDTO> locationDTOs = locations.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(locationDTOs, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<LocationDTO> createLocation(@RequestBody LocationDTO locationDTO) {
        Location location = convertToEntity(locationDTO);
        Location createdLocation = locationService.saveLocation(location);
        return new ResponseEntity<>(convertToDTO(createdLocation), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LocationDTO> updateLocation(@PathVariable Long id, @RequestBody LocationDTO locationDTO) {
        Location location = convertToEntity(locationDTO);
        location.setId(id);
        Location updatedLocation = locationService.saveLocation(location);
        return new ResponseEntity<>(convertToDTO(updatedLocation), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLocation(@PathVariable Long id) {
        locationService.deleteLocation(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
