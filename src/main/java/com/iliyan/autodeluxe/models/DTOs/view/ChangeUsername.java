package com.iliyan.autodeluxe.models.DTOs.view;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class ChangeUsername {
	@NotBlank
	@NotNull
	private String username;
}
