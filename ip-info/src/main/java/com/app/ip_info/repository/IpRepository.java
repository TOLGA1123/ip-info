package com.app.ip_info.repository;

import com.app.ip_info.entity.IpAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IpRepository extends JpaRepository<IpAddress, Long> {
    boolean existsByIp(String ip);

    IpAddress findByIp(String ip);
}
