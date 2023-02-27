package com.projectsujan.blog.services.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectsujan.blog.entity.Category;
import com.projectsujan.blog.exceptions.ResourceNotFoundException;
import com.projectsujan.blog.payloads.CategoryDto;
import com.projectsujan.blog.repositories.CategoryRepository;
import com.projectsujan.blog.services.CategoryService;
@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {

		Category category = this.modelMapper.map(categoryDto, Category.class);
		Category addedCategory = this.categoryRepository.save(category);
		return this.modelMapper.map(addedCategory, CategoryDto.class);
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer CategoryId) {

		Category category = this.categoryRepository.findById(CategoryId)
				.orElseThrow(() -> new ResourceNotFoundException("category", "Category Id", CategoryId));

		category.setCategoryTitle(categoryDto.getCategoryTitle());
		category.setCategoryDescription(categoryDto.getCategoryDescription());

		Category updatedCategory = this.categoryRepository.save(category);
		return this.modelMapper.map(updatedCategory, CategoryDto.class);
	}

	@Override
	public void deleteCategory(Integer CategoryId) {

		Category category = this.categoryRepository.findById(CategoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "Category ", CategoryId));

		this.categoryRepository.delete(category);

	}

	@Override
	public CategoryDto getCategory(Integer CategoryId) {
		Category category = this.categoryRepository.findById(CategoryId)

				.orElseThrow(() -> new ResourceNotFoundException("Category", "Category Id", CategoryId));

		return this.modelMapper.map(category, CategoryDto.class);

	}

	@Override
	public List<CategoryDto> getAllCategory() {

		List<Category> categories = this.categoryRepository.findAll();
		List<CategoryDto> categoryDtos = categories.stream().map((cat) -> this.modelMapper.map(cat, CategoryDto.class))
				.collect(Collectors.toList());

		return categoryDtos;
	}

}
