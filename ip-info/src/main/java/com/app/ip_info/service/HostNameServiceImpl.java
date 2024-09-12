package com.app.ip_info.service;

import com.app.ip_info.entity.HostName;
import com.app.ip_info.repository.HostNameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HostNameServiceImpl implements HostNameService{

    @Autowired
    private HostNameRepository hostNameRepository;

    public List<HostName> getAllHostNames() {
        return hostNameRepository.findAll();
    }

    public Optional<HostName> getHostNameById(Long id) {
        return hostNameRepository.findById(id);
    }

    public HostName addHostName(HostName hostName) {
        return hostNameRepository.save(hostName);
    }

    public void deleteHostName(Long id) {
        hostNameRepository.deleteById(id);
    }
}

