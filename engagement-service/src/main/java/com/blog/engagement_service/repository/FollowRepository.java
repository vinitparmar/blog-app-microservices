package com.blog.engagement_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.engagement_service.model.Follow;

public interface FollowRepository extends JpaRepository<Follow, Long>{

	boolean existsByFollowerIdAndFollowingId(Long followerId , Long followingId);
}
