package com.app.ip_info.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Operating_System")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OperatingSystem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "OPERATING_SYSTEM", nullable = false)
    private String name;
}