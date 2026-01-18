package com.blog.engagement_service.service;

import org.springframework.stereotype.Service;

import com.blog.engagement_service.model.Comment;
import com.blog.engagement_service.repository.CommentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentService {

	private final CommentRepository commentRepository;
	
	public Comment addComment(Long postId , Long userId, String Content) {
		
		Comment comment =  new Comment();
		comment.setPostId(postId);
		comment.setUserId(userId);
		comment.setContent(Content);
		return commentRepository.save(comment);
		
	}
	
}
