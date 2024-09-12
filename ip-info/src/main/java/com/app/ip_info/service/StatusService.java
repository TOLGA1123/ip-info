package com.app.ip_info.service;

import com.app.ip_info.entity.Status;

import java.util.List;

public interface StatusService {

    public List<Status> getAllStatuses();

    public Status addStatus(Status status);

    public void deleteStatus(Long id);
}
