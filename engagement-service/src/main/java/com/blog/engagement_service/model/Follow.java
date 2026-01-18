package com.blog.engagement_service.model;

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
		 uniqueConstraints = @UniqueConstraint(columnNames = {"followerId", "followingId"})
		)
@Getter
@Setter

public class Follow {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Long followerId;
	private Long followingId;
	
}
