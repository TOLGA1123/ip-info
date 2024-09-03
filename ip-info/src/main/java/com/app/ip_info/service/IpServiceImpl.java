package com.app.ip_info.service;

import com.app.ip_info.entity.IpAddress;
import com.app.ip_info.repository.IpRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class IpServiceImpl implements IpService{

    @Autowired
    private IpRepository ipRepository;

    @Override
    public List<IpAddress> getAllIpAddresses() {
        try {
            return ipRepository.findAll();
        } catch (Exception e) {
            log.error("Error fetching IP addresses", e);
            throw e;
        }
    }

    @Override
    public IpAddress saveIpAddress(IpAddress ipAddress) {
        try {
            return ipRepository.save(ipAddress);
        } catch (Exception e) {
            log.error("Error saving IP address", e);
            throw e;
        }
    }

    @Override
    public IpAddress getIpAddressById(Long id) {
        Optional<IpAddress> ipAddress = ipRepository.findById(id);
        if (ipAddress.isPresent()) {
            return ipAddress.get();
        } else {
            throw new RuntimeException("IP Address not found for id : " + id);
        }
    }

    @Override
    public void deleteIpAddressById(Long id) {
        try{
            ipRepository.deleteById(id);
        } catch (Exception e) {
            log.error("Error deleting IP address", e);
            throw e;
        }
    }
}
