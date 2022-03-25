package com.manik.user.api.service;

import com.manik.user.api.entities.User;

public interface UserService {

	User createUser(User user);

	User findByEmail(String email);

	User editUser(User user,Long id);
}
