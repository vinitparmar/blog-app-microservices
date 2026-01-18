package com.blog.engagement_service.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.engagement_service.service.FollowService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/follow")
@RequiredArgsConstructor
public class FollowController {
	
	 private final FollowService followService;
	 
	 @PostMapping("/{userId}")
	 public void follow(
			 @PathVariable Long userId,
		     @RequestHeader("X-USER-ID") Long followerId
			 ) {
		 followService.follow(followerId, followerId);
	 }
	
}
