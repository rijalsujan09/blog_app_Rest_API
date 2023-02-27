package com.projectsujan.blog.payloads;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {
	private Integer categoryId;
	
	@NotBlank
	@Size(min = 5 , message = "Title must be min 5 character")
	private String categoryTitle;
	@NotBlank
	@Size(min = 15  , message = "Title must be min 15 character")
	private String categoryDescription;
	
	
	public CategoryDto() {
		
	}
	
	public CategoryDto(String categoryTitle, String categoryDescription) {
		super();
		this.categoryTitle = categoryTitle;
		this.categoryDescription = categoryDescription;
	}
	
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryTitle() {
		return categoryTitle;
	}
	public void setCategoryTitle(String categoryTitle) {
		this.categoryTitle = categoryTitle;
	}
	public String getCategoryDescription() {
		return categoryDescription;
	}
	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}
	
	
	

}
