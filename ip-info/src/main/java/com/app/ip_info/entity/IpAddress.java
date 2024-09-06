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
    @Column(name = "IP_ADDRESS")
    private String ip;
    @Column(name = "HOST_NAME")
    private String hostName;
    @Column(name = "STATUS")
    private String status;
    @Column(name = "LOCATION")
    private String location;
    @Column(name = "RELATED_GROUP")
    private String relatedGroup;
    @Column(name = "OPERATING_SYSTEM")
    private String operatingSystem;
}
