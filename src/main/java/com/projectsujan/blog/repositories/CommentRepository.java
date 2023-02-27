package com.projectsujan.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectsujan.blog.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

}
