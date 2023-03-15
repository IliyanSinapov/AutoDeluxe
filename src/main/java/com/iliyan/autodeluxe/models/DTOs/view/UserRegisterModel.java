package com.iliyan.autodeluxe.models.DTOs.view;

import com.iliyan.autodeluxe.velidations.passwordMatcher.PasswordMatch;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@PasswordMatch
public class UserRegisterModel {

    @NotNull
    @NotBlank
    @Size(min = 2, max = 20)
    private String username;
    @NotNull
    @NotBlank
    @Email
    private String email;
    @NotNull
    @NotBlank
    @Size(min = 2)
    private String password;
    @NotNull
    @NotBlank
    @Size(min = 2)
    private String confirmPassword;
}
