package com.zolusca.Entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum RoleEnum {
    @JsonProperty("ADMIN")
    ADMIN("ADMIN"),
    @JsonProperty("CUSTOMER")
    CUSTOMER("CUSTOMER");
    private String role;

    RoleEnum(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
