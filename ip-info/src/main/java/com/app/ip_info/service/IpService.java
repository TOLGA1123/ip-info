package com.app.ip_info.service;

import com.app.ip_info.entity.IpAddress;
import com.app.ip_info.model.IpResponse;

import java.util.List;

public interface IpService {
    List<IpAddress> getAllIpAddresses();

    IpAddress saveIpAddress(IpAddress ipAddress, boolean b);

    IpResponse getIpAddressById(Long id);

    void deleteIpAddressById(Long id);
}
