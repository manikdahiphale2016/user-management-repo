package com.manik.user.api.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manik.user.api.entities.User;
import com.manik.user.api.repository.UserRepository;
import com.manik.user.api.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User createUser(User user) {

		return userRepository.save(user);
	}

	@Override
	public User findByEmail(String email) {

		return userRepository.findByEmail(email);
	}

	@Override
	public User editUser(User user,Long id) {
		// retrieve user or throw Exception
		User existingUser = userRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("user not found..!"));

		existingUser.setFirstName(user.getFirstName());
		existingUser.setLastName(user.getLastName());
		existingUser.setEmail(user.getEmail());
		existingUser.setPhoneNumber(user.getPhoneNumber());
		
		//Save into DB
		userRepository.save(existingUser);

		return existingUser;
	}

}
