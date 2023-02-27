package com.projectsujan.blog.services.Impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectsujan.blog.entity.Comment;
import com.projectsujan.blog.entity.Post;
import com.projectsujan.blog.exceptions.ResourceNotFoundException;
import com.projectsujan.blog.payloads.CommentDto;
import com.projectsujan.blog.repositories.CommentRepository;
import com.projectsujan.blog.repositories.PostRepository;
import com.projectsujan.blog.repositories.UserRepository;
import com.projectsujan.blog.services.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private PostRepository postRepository;
	@Autowired
	private CommentRepository commentRepository;
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CommentDto createComment(CommentDto commentDto, Integer postId, Integer userId) {
		Post post = this.postRepository.findById(postId)
				.orElseThrow(() -> new ResourceNotFoundException("Post", "post_Id", postId));
		
		
		Comment comment = this.modelMapper.map(commentDto, Comment.class);
		

		comment.setPost(post);
		Comment savedComment = this.commentRepository.save(comment);

		return this.modelMapper.map(savedComment, CommentDto.class);
	}

	@Override
	public void deleteComment(Integer commentId) {

		Comment comment = this.commentRepository.findById(commentId)
				.orElseThrow(() -> new ResourceNotFoundException("Comment", "Comment_Id", commentId));

		this.commentRepository.delete(comment);

	}

}
