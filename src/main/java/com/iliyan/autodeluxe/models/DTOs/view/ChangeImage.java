package com.iliyan.autodeluxe.models.DTOs.view;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChangeImage {
	@NotNull
	private byte[] image;
}
