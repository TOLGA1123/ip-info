package com.app.ip_info.controller;

import com.app.ip_info.entity.RelatedGroup;
import com.app.ip_info.model.RelatedGroupDTO;
import com.app.ip_info.service.RelatedGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/related-groups")
public class RelatedGroupController {

    @Autowired
    private RelatedGroupService relatedGroupService;

    // Convert Entity to DTO
    private RelatedGroupDTO convertToDTO(RelatedGroup relatedGroup) {
        return RelatedGroupDTO.builder()
                .id(relatedGroup.getId())
                .name(relatedGroup.getName())
                .build();
    }

    // Convert DTO to Entity
    private RelatedGroup convertToEntity(RelatedGroupDTO relatedGroupDTO) {
        return RelatedGroup.builder()
                .id(relatedGroupDTO.getId())
                .name(relatedGroupDTO.getName())
                .build();
    }


    @GetMapping
    public ResponseEntity<List<RelatedGroupDTO>> getAllRelatedGroups() {
        List<RelatedGroup> relatedGroups = relatedGroupService.getAllRelatedGroups();
        List<RelatedGroupDTO> relatedGroupDTOs = relatedGroups.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(relatedGroupDTOs, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<RelatedGroupDTO> createRelatedGroup(@RequestBody RelatedGroupDTO relatedGroupDTO) {
        RelatedGroup relatedGroup = convertToEntity(relatedGroupDTO);
        RelatedGroup createdRelatedGroup = relatedGroupService.saveRelatedGroup(relatedGroup);
        return new ResponseEntity<>(convertToDTO(createdRelatedGroup), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RelatedGroupDTO> updateRelatedGroup(@PathVariable Long id, @RequestBody RelatedGroupDTO relatedGroupDTO) {
        RelatedGroup relatedGroup = convertToEntity(relatedGroupDTO);
        relatedGroup.setId(id);
        RelatedGroup updatedRelatedGroup = relatedGroupService.saveRelatedGroup(relatedGroup);
        return new ResponseEntity<>(convertToDTO(updatedRelatedGroup), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRelatedGroup(@PathVariable Long id) {
        relatedGroupService.deleteRelatedGroup(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
