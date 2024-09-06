package com.app.ip_info.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class IpRequest {
    private String ip;
    private String hostName;
    private String status;
    private String location;
    private String relatedGroup;
    private String operatingSystem;
}

