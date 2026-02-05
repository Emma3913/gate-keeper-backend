package com.gatekeeper.permission.domain.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Permission {
    private Long id;
    private String name;
}
