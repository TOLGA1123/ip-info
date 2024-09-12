package com.app.ip_info.repository;


import com.app.ip_info.entity.OperatingSystem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperatingSystemRepository extends JpaRepository<OperatingSystem, Long> {
}