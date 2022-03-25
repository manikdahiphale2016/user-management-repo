package com.manik.user.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.manik.user.api.entities.User;
import com.manik.user.api.service.UserService;

@Controller
public class UserRestController {

	@Autowired
	private UserService userService;

	// http://localhost:8080/users/register
	@RequestMapping("/register")
	public String showRegistration() {

		return "registerUser";
	}
	
	@RequestMapping(value = "/registerUser",method = RequestMethod.POST)
	public String saveUser(@ModelAttribute("user") User user,ModelMap model) {
	
		userService.createUser(user);
		System.out.println(">>>>>> "+user);
		model.addAttribute("msg", "User Saved Successfully..!");
		
		return "login";
		
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam("email") String email, @RequestParam("phonenumber") String phoneNumber,
			ModelMap modelMap) {
		User user = userService.findByEmail(email);
		if (user.getPhoneNumber().equals(phoneNumber)) {
			modelMap.addAttribute("user", user.getFirstName());
			return "profile";
		} else {
			modelMap.addAttribute("msg", "Invalid User Name OR phone number.Please try again.");
		}

		return "login";
	}
	
	// Hit from Postman
	//URL: http://localhost:8080/users/update-user/1 (1--is id )
	@PutMapping(value = "/update-user/{id}",consumes ="application/json")
	public ResponseEntity<String> updateUser(@RequestBody User user,@PathVariable("id") Long id) {
		User updatedUser = userService.editUser(user,id);
		return new ResponseEntity<String>("User Updated Successfully..!", HttpStatus.OK);
	}

}
