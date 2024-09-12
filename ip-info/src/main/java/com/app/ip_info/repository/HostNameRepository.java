package com.app.ip_info.repository;

import com.app.ip_info.entity.HostName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HostNameRepository extends JpaRepository<HostName, Long> {
}
