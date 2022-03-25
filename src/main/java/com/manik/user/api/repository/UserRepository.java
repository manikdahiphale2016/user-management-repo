package com.manik.user.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manik.user.api.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);

}
