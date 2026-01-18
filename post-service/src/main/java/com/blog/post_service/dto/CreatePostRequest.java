package com.blog.post_service.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class CreatePostRequest {
	
	@NotBlank
	private String title;
	
	@NotBlank
	private String content;
}
