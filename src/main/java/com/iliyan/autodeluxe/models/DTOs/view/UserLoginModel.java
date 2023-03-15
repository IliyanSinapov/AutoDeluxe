package com.iliyan.autodeluxe.models.DTOs.view;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginModel {

    @NotNull
    @NotBlank
    private String username;
    @NotNull
    @NotBlank
    private String password;
}
