package com.projectsujan.blog.exceptions;

public class UserFoundException  extends RuntimeException{

		private static final long serialVersionUID = 4729495337586536247L;
		String resourceName;
		String fieldName;
		String fielValue;
		
		public UserFoundException(String resourceName, String fieldName, String fielValue) {
			super(String.format("%s not found with %s : %s", resourceName,fieldName,fielValue));
			this.resourceName = resourceName;
			this.fieldName = fieldName;
			this.fielValue = fielValue;
		}

}
