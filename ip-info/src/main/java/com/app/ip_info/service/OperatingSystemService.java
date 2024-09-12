package com.app.ip_info.service;

import com.app.ip_info.entity.OperatingSystem;

import java.util.List;

public interface OperatingSystemService {

    public List<OperatingSystem> getAllOperatingSystems();

    public OperatingSystem getOperatingSystemById(Long id);

    public OperatingSystem saveOperatingSystem(OperatingSystem operatingSystem);

    public void deleteOperatingSystem(Long id);
}
