package com.app.ip_info.service;

import com.app.ip_info.entity.OperatingSystem;
import com.app.ip_info.repository.OperatingSystemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperatingSystemServiceImpl implements OperatingSystemService {
    @Autowired
    private OperatingSystemRepository operatingSystemRepository;

    public List<OperatingSystem> getAllOperatingSystems() {
        return operatingSystemRepository.findAll();
    }

    public OperatingSystem getOperatingSystemById(Long id) {
        return operatingSystemRepository.findById(id).orElse(null);
    }

    public OperatingSystem saveOperatingSystem(OperatingSystem operatingSystem) {
        return operatingSystemRepository.save(operatingSystem);
    }

    public void deleteOperatingSystem(Long id) {
        operatingSystemRepository.deleteById(id);
    }
}