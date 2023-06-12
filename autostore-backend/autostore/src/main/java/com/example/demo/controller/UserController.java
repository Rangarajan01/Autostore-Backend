package com.example.demo.controller;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@RestController
@CrossOrigin("*")
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/user")
	User newUser(@RequestBody User newUser) {
		return userRepository.save(newUser);
	}
	
	@GetMapping("/users")
	List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	@GetMapping("/user/{engineno}")
	User getUserById(@PathVariable Integer engineno) {
		return userRepository.findById(engineno)
				.orElseThrow(()->new UserNotFoundException(engineno));
	}
	
	@PutMapping("/user/{engineno}")
	User updateUser(@RequestBody User newUser,@PathVariable Integer engineno) {
		return userRepository.findById(engineno)
				.map(user -> {
					user.setEngineno(newUser.getEngineno());
					user.setHorsepower(newUser.getHorsepower());
					user.setCarmodel(newUser.getCarmodel());
					user.setSeaters(newUser.getSeaters());
					user.setSpecifications(newUser.getSpecifications());
					return userRepository.save(user);
				})
				.orElseThrow(()->new UserNotFoundException(engineno));
	}	
	
	@DeleteMapping("/user/{engineno}")
	String deleteUser(@PathVariable Integer engineno) {
		if(!userRepository.existsById(engineno)) {
			throw new UserNotFoundException(engineno);
		}
		userRepository.deleteById(engineno);
		return "Car with engineno "+engineno+" has been deleted successfully.";
	}
	
	
}
