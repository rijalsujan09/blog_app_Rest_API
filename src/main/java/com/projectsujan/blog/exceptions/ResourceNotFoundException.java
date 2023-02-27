package com.projectsujan.blog.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ResourceNotFoundException  extends RuntimeException{
	
	private static final long serialVersionUID = 7664660228024130901L;
	String resourceName;
	String fieldName;
	long fielValue;
	
	public ResourceNotFoundException(String resourceName, String fieldName, long fielValue) {
		super(String.format("%s not found with %s : %s", resourceName,fieldName,fielValue));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fielValue = fielValue;
	}

	

}
