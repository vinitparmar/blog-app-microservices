package com.blog.post_service.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class PostResponse {
	
	private Long id;
	private String title;
	private String content;
	private Long authorId;
	private Long readCount;
	
}
