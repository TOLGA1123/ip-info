package com.app.ip_info.repository;

import com.app.ip_info.entity.IpAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IpRepository extends JpaRepository<IpAddress, Long> {
    boolean existsByIp(String ip);

    IpAddress findByIp(String ip);
}
