package com.projectsujan.blog.services;

import com.projectsujan.blog.payloads.CommentDto;

public interface CommentService {

	CommentDto createComment(CommentDto commentDto, Integer postId, Integer userId);
	void deleteComment(Integer commentId);
	

}
