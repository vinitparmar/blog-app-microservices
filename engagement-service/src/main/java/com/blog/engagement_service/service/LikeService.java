package com.blog.engagement_service.service;

import org.springframework.stereotype.Service;

import com.blog.engagement_service.model.PostLike;
import com.blog.engagement_service.repository.LikeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LikeService {

	private final LikeRepository likeRepository;
	
	public void likePost(Long postId , Long userId) {
		if(!likeRepository.existsByPostIdAndUserId(postId, userId)) {
			PostLike like =  new PostLike();
			like.setPostId(postId);
			like.setUserId(userId);
			likeRepository.save(like);
		}
	}

	public long getLikes(Long postId) {
		return likeRepository.countByPostId(postId);
	}
}
