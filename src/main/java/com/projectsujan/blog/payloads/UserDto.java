package com.projectsujan.blog.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
public class UserDto {
	private Integer id;
	@NotEmpty
	@Size(min=4, message = "username must be minimum of 4 character !!")
	private  String name;
	@Email(message = "Email adress is not Valid !!")
	@NotEmpty
	private String email;
	@NotEmpty
	@Size(min=6, max=15, message = "password must be minimum 4 chars and and max of 9 char ")
	private String password;
	@NotEmpty
	@Size(min=20 ,max = 100)
	private String about;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	
	
}
