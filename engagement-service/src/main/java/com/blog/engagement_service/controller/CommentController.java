package com.blog.engagement_service.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.engagement_service.model.Comment;
import com.blog.engagement_service.service.CommentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/comments")
@RequiredArgsConstructor
public class CommentController {

	private final CommentService commentService;
	
	 @PostMapping("/{postId}")
	    public Comment comment(
	        @PathVariable Long postId,
	        @RequestHeader("X-USER-ID") Long userId,
	        @RequestBody String content) {
		 
		 return commentService.addComment(postId, userId, content);
	 }
}
