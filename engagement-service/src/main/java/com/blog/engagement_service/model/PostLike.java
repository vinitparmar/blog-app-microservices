package com.blog.engagement_service.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(
		uniqueConstraints = @UniqueConstraint(columnNames = {"postId" , "userId"})
		)

@Getter
@Setter
public class PostLike {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long id;
	
	private Long postId;
	private Long userId;
	private LocalDateTime createdDate = LocalDateTime.now();

}
