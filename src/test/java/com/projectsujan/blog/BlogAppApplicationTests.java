package com.projectsujan.blog;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.projectsujan.blog.repositories.UserRepository;

@SpringBootTest
class BlogAppApplicationTests {
	
	@Autowired
	private UserRepository userRepository;

	@Test
	void contextLoads() {
	}
	
	@Test
	public void repoTest() {
		String clasName = this.userRepository.getClass().getName();
		String packNameString = this.userRepository.getClass().getPackageName();
		
		System.out.println(clasName);
		System.out.println(packNameString);
		
	}

}
