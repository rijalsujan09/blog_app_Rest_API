package com.projectsujan.blog.controllers;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.projectsujan.blog.payloads.PostDto;
import com.projectsujan.blog.services.FileService;
import com.projectsujan.blog.services.PostService;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api")
public class FileController {
	@Autowired
	private FileService fileService;

	@Autowired
	private PostService postService;

	@Value("${project.image}")
	private String path;

	@PostMapping("/post/image/upload/{postId}")
	public ResponseEntity<PostDto> fileUpload(@RequestParam("image") MultipartFile image, @PathVariable Integer postId)
			throws IOException {

		PostDto postDto = this.postService.getPostById(postId);

		String fileName = this.fileService.uploadImage(path, image);

		postDto.setImageName(fileName);

		PostDto updatedpost = this.postService.updatePost(postDto, postId);

		return new ResponseEntity<PostDto>(updatedpost, HttpStatus.OK);
	}

	@GetMapping(value = "/post/images/{imageName}", produces = MediaType.IMAGE_JPEG_VALUE)
	public void downloadImage(@PathVariable("imageName") String imageName, HttpServletResponse response)
			throws IOException {

		InputStream resource = this.fileService.getResource(path, imageName);
		response.setContentType(MediaType.IMAGE_JPEG_VALUE);
		StreamUtils.copy(resource, response.getOutputStream());

	}

}
