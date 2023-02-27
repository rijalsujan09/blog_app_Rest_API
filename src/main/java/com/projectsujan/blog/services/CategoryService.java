package com.projectsujan.blog.services;

import java.util.List;

import com.projectsujan.blog.payloads.CategoryDto;

public interface CategoryService {
	//create
	CategoryDto createCategory(CategoryDto categoryDto) ;
	//update
	CategoryDto updateCategory(CategoryDto categoryDto,Integer CategoryId);
	//delete
	void deleteCategory(Integer CategoryId);
	//get  
	CategoryDto getCategory(Integer CategoryId);
	//get all
	List<CategoryDto> getAllCategory();
	

}
