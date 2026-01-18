package com.blog.post_service.service;

import org.springframework.stereotype.Service;

import com.blog.post_service.dto.CreatePostRequest;
import com.blog.post_service.model.Post;
import com.blog.post_service.repository.PostRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostService {

	private final PostRepository postRepository;
	
	public Post createPost(CreatePostRequest request , Long authorId) {
		
		Post post = new Post();
		post.setTitle(request.getTitle());
		post.setContent(request.getTitle());
		post.setAuthorId(authorId);
		
		return postRepository.save(post);
	}
	
	
	public Post getPost(Long id) {
		Post post =  postRepository.findById(id)
				.orElseThrow(()-> new RuntimeException("Post not founfd"));
		post.setReadCount(post.getReadCount()+1);
		return postRepository.save(post);
	}
}
