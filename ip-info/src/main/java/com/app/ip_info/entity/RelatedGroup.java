package com.app.ip_info.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Related_Group")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RelatedGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "RELATED_GROUP", nullable = false)
    private String name;
}