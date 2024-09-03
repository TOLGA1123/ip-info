package com.app.ip_info.service;

import com.app.ip_info.entity.IpAddress;

import java.util.List;

public interface IpService {
    List<IpAddress> getAllIpAddresses();

    IpAddress saveIpAddress(IpAddress ipAddress);

    IpAddress getIpAddressById(Long id);

    void deleteIpAddressById(Long id);
}
