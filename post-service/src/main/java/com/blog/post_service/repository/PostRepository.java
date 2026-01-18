package com.blog.post_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.post_service.model.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

}
