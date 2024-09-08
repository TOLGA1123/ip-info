package com.app.ip_info.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Ip_Addresses")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class IpAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "IP_ADDRESS", nullable = false)
    private String ip;
    @Column(name = "HOST_NAME", nullable = true)
    private String hostName;
    @Column(name = "STATUS", nullable = true)
    private String status;
    @Column(name = "LOCATION", nullable = true)
    private String location;
    @Column(name = "RELATED_GROUP", nullable = true)
    private String relatedGroup;
    @Column(name = "OPERATING_SYSTEM", nullable = true)
    private String operatingSystem;
}
