package com.blog.engagement_service.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.engagement_service.service.LikeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/likes")
@RequiredArgsConstructor

public class LikeController {
	
		private final LikeService likeService;
		
		@PostMapping("/{postId}")
		public void like(
				@PathVariable Long postId,
				@RequestHeader("X-USER-ID") Long userId
				) {
			
			likeService.likePost(postId, userId);
		
		}
}
