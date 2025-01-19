package com.example.profileservice2.DTO.Request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
//@AllArgsConstructor
//@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserIdentityCreationRequest {
    String email;
    String password;
    String idUserProfile;

    public UserIdentityCreationRequest() {
    }

    public UserIdentityCreationRequest(String email, String password, String idUserProfile) {
        this.email = email;
        this.password = password;
        this.idUserProfile = idUserProfile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIdUserProfile() {
        return idUserProfile;
    }

    public void setIdUserProfile(String idUserProfile) {
        this.idUserProfile = idUserProfile;
    }
}
