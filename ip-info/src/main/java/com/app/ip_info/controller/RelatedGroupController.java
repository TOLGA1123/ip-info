package com.app.ip_info.controller;

import com.app.ip_info.entity.RelatedGroup;
import com.app.ip_info.service.RelatedGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/related-groups")
public class RelatedGroupController {
    @Autowired
    private RelatedGroupService relatedGroupService;

    @GetMapping
    public List<RelatedGroup> getAllRelatedGroups() {
        return relatedGroupService.getAllRelatedGroups();
    }

    @PostMapping
    public RelatedGroup createRelatedGroup(@RequestBody RelatedGroup relatedGroup) {
        return relatedGroupService.saveRelatedGroup(relatedGroup);
    }

    @PutMapping("/{id}")
    public RelatedGroup updateRelatedGroup(@PathVariable Long id, @RequestBody RelatedGroup relatedGroup) {
        relatedGroup.setId(id);
        return relatedGroupService.saveRelatedGroup(relatedGroup);
    }
    @DeleteMapping("/{id}")
    public void deleteRelatedGroup(@PathVariable Long id) {
        relatedGroupService.deleteRelatedGroup(id);
    }
}
