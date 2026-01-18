package com.blog.engagement_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.engagement_service.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long>{

	List<Comment> findByPostId(Long postId);
	
}
