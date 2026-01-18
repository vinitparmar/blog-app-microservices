package com.blog.post_service.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.post_service.dto.CreatePostRequest;
import com.blog.post_service.dto.PostResponse;
import com.blog.post_service.model.Post;
import com.blog.post_service.service.PostService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor

public class PostController {

	final PostService postService;
	
	@PostMapping
	public ResponseEntity<PostResponse> createPost(
			@RequestBody @Valid CreatePostRequest request,
			@RequestHeader("X-USER-ID") Long userId
			){
		
		Post post = postService.createPost(request, userId);
		
		PostResponse response =  new PostResponse(
				post.getId(), 
				post.getTitle(), 
				post.getContent(), 
				post.getAuthorId(), 
				post.getReadCount()
				);
		
		return ResponseEntity.ok(response);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<PostResponse> getPost(@PathVariable Long id) {
		
		Post post = postService.getPost(id);
		
		PostResponse response =  new PostResponse(
				post.getId(), 
				post.getTitle(), 
				post.getContent(), 
				post.getAuthorId(), 
				post.getReadCount()
				);
		
		return ResponseEntity.ok(response);
	}
	
	 
	
	
}
