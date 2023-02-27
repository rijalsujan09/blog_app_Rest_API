package com.projectsujan.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectsujan.blog.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
