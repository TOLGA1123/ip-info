package com.app.ip_info.controller;

import com.app.ip_info.entity.OperatingSystem;
import com.app.ip_info.service.OperatingSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/operating-systems")
public class OperatingSystemController {
    @Autowired
    private OperatingSystemService operatingSystemService;

    @GetMapping
    public List<OperatingSystem> getAllOperatingSystems() {
        return operatingSystemService.getAllOperatingSystems();
    }

    @PostMapping
    public OperatingSystem createOperatingSystem(@RequestBody OperatingSystem operatingSystem) {
        return operatingSystemService.saveOperatingSystem(operatingSystem);
    }

    @PutMapping("/{id}")
    public OperatingSystem updateOperatingSystem(@PathVariable Long id, @RequestBody OperatingSystem operatingSystem) {
        operatingSystem.setId(id);
        return operatingSystemService.saveOperatingSystem(operatingSystem);
    }

    @DeleteMapping("/{id}")
    public void deleteOperatingSystem(@PathVariable Long id) {
        operatingSystemService.deleteOperatingSystem(id);
    }
}
