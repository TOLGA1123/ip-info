package com.app.ip_info.service;

import com.app.ip_info.entity.IpAddress;
import com.app.ip_info.exception.FieldEmptyException;
import com.app.ip_info.exception.IpAddressAlreadyExistsException;
import com.app.ip_info.exception.IpAddressNotFoundException;
import com.app.ip_info.model.IpResponse;
import com.app.ip_info.repository.IpRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.springframework.beans.BeanUtils.copyProperties;

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
    public IpAddress saveIpAddress(IpAddress ipAddress, boolean isUpdate) {
        if (!isUpdate) {
            // Check if the IP address already exists (for add operation)
            if (ipRepository.existsByIp(ipAddress.getIp())) {
                throw new IpAddressAlreadyExistsException("IP Address already exists", "IP_ALREADY_EXISTS");
            }
        } else {
            // Check if the IP address already exists (for update operation)
            IpAddress existingIpAddress = ipRepository.findByIp(ipAddress.getIp());
            if (existingIpAddress != null && !existingIpAddress.getId().equals(ipAddress.getId())) {
                throw new IpAddressAlreadyExistsException("IP Address already exists", "IP_ALREADY_EXISTS");
            }
        }
        try {
            if (ipAddress.getIp() == null || ipAddress.getIp().isEmpty()) {
                throw new FieldEmptyException("IP address field cannot be empty", "IP_FIELD_EMPTY");
            }
            return ipRepository.save(ipAddress);
        } catch (Exception e) {
            log.error("Error saving IP address", e);
            throw e;
        }
    }



    @Override
    public IpResponse getIpAddressById(Long id) {
        IpAddress ipAddress = ipRepository.findById(id)
                .orElseThrow(
                        () -> new IpAddressNotFoundException("Ip address with given id is not found", "IP_NOT_FOUND"));
        IpResponse ipResponse = new IpResponse();
        copyProperties(ipAddress, ipResponse);
        return ipResponse;
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
