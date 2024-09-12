package com.app.ip_info.service;

import com.app.ip_info.entity.RelatedGroup;

import java.util.List;

public interface RelatedGroupService {

    public List<RelatedGroup> getAllRelatedGroups();

    public RelatedGroup getRelatedGroupById(Long id);

    public RelatedGroup saveRelatedGroup(RelatedGroup relatedGroup);

    public void deleteRelatedGroup(Long id);
}
