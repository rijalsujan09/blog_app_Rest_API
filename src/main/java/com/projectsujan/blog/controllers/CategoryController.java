package com.projectsujan.blog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projectsujan.blog.payloads.ApiResponse;
import com.projectsujan.blog.payloads.CategoryDto;
import com.projectsujan.blog.services.CategoryService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	// CREATE
	@PostMapping("/")
	public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto) {

		CategoryDto createdCategory = this.categoryService.createCategory(categoryDto);

		return new ResponseEntity<CategoryDto>(createdCategory, HttpStatus.CREATED);
	}

	// UPDATE
	@PutMapping("/{id}")
	public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto categoryDto, @PathVariable Integer id) {

		CategoryDto updatedCategory = this.categoryService.updateCategory(categoryDto, id);

		return new ResponseEntity<CategoryDto>(updatedCategory, HttpStatus.OK);
	}

	// DELETE
	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Integer id) {

		this.categoryService.deleteCategory(id);

		return new ResponseEntity<ApiResponse>(new ApiResponse("Categeory  is sucsessfully  Deleted !!", true),
				HttpStatus.OK);
	}

	// GET
	@GetMapping("/{id}")
	public ResponseEntity<CategoryDto> getCategory(@PathVariable Integer id) {

		CategoryDto categoryDto = this.categoryService.getCategory(id);

		return new ResponseEntity<CategoryDto>(categoryDto, HttpStatus.OK);
	}

	// GET ALL
	@GetMapping("/all")
	public ResponseEntity<List<CategoryDto>> getAllCategory() {

		List<CategoryDto> categoryDtos = this.categoryService.getAllCategory();

		return ResponseEntity.ok(categoryDtos);
	}

}
