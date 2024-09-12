package com.app.ip_info.service;

import com.app.ip_info.entity.RelatedGroup;
import com.app.ip_info.repository.RelatedGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RelatedGroupServiceImpl implements RelatedGroupService{
    @Autowired
    private RelatedGroupRepository relatedGroupRepository;

    public List<RelatedGroup> getAllRelatedGroups() {
        return relatedGroupRepository.findAll();
    }

    public RelatedGroup getRelatedGroupById(Long id) {
        return relatedGroupRepository.findById(id).orElse(null);
    }

    public RelatedGroup saveRelatedGroup(RelatedGroup relatedGroup) {
        return relatedGroupRepository.save(relatedGroup);
    }

    public void deleteRelatedGroup(Long id) {
        relatedGroupRepository.deleteById(id);
    }
}
