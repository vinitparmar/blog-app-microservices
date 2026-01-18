package com.blog.engagement_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.engagement_service.model.PostLike;

public interface LikeRepository extends JpaRepository<PostLike, Long> {

	boolean existsByPostIdAndUserId(Long postId, Long userId);
	long countByPostId(Long postId);
	
}
