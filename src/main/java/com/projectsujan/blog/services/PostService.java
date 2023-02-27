package com.projectsujan.blog.services;

import java.util.List;

import com.projectsujan.blog.entity.Post;
import com.projectsujan.blog.payloads.PostDto;
import com.projectsujan.blog.payloads.PostResponse;

public interface PostService {
	// create
	PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);

	// update
	PostDto updatePost(PostDto postDto, Integer postId);

	// delete
	void deletePost(Integer postId);

	// get by Id
	PostDto getPostById(Integer postId);

	// get all post
//	List<PostDto> getAllPost(Integer pageNumber, Integer pageSize);
	PostResponse getAllPost (Integer pageNumber, Integer pageSize, String sortBy, String sortDir);

	// get all post by category
	List<PostDto> getPostsByCategory(Integer categoryId);

	// get all post by User
	List<PostDto> getPostsByUserId(Integer userId);

	
	// search by keyword
	List<PostDto> searchPosts(String keyword);

}
