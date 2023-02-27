package com.projectsujan.blog.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectsujan.blog.entity.Category;
import com.projectsujan.blog.entity.Post;
import com.projectsujan.blog.entity.User;

public interface PostRepository extends JpaRepository<Post, Integer> {

	List<Post> findByUser(User user);

	List<Post> findByCategory(Category category);

	List<Post> findByTitleContaining(String title);

}
