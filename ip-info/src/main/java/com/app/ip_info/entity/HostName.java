package com.app.ip_info.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Host_Name")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HostName {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "HOST_NAME", nullable = false)
    private String name;
}