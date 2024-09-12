package com.app.ip_info.service;

import com.app.ip_info.entity.HostName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface HostNameService {

    public List<HostName> getAllHostNames();

    public Optional<HostName> getHostNameById(Long id);

    public HostName addHostName(HostName hostName);

    public void deleteHostName(Long id);
}

