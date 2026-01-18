package com.blog.engagement_service.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter

public class Comment {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Long postId;
	private Long userId;
	
	@Column(columnDefinition = "TEXT")
	private String content;
	
	private LocalDateTime createdAt = LocalDateTime.now();
	
}
