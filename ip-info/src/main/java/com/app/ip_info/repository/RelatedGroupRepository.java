package com.app.ip_info.repository;


import com.app.ip_info.entity.RelatedGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RelatedGroupRepository extends JpaRepository<RelatedGroup, Long> {
}