package com.blog.engagement_service.service;

import org.springframework.stereotype.Service;

import com.blog.engagement_service.model.Follow;
import com.blog.engagement_service.repository.FollowRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FollowService {

	final FollowRepository followRepository;
	
	public void follow(Long followerId , Long followingId) {
		if(!followRepository.existsByFollowerIdAndFollowingId(followerId, followingId)) {
			Follow follow = new Follow();
			follow.setFollowerId(followerId);
			follow.setFollowingId(followingId);
			followRepository.save(follow);
		}
	}
	
}
