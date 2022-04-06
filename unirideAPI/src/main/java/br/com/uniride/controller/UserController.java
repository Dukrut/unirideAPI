package br.com.uniride.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.uniride.dao.UserRepository;
import br.com.uniride.model.User;

@Controller
@CrossOrigin
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@PostMapping
	public @ResponseBody String addNewUser(@RequestParam String name, @RequestParam String email) {

		User n = new User();
		n.setFullname(name);
		n.setMail(email);
		userRepository.save(n);
		return "Saved";
	}
	
	@GetMapping
	public @ResponseBody Optional<User> getUser(@RequestParam("id") int id) {
		
		return userRepository.findById(id);
		
	}
	
	@DeleteMapping
	public @ResponseBody String deleteUser(@RequestParam("id") int id) {
		
		userRepository.deleteById(id);
		return "Deleted";
		
	}
	
	@GetMapping(path = "/all")
	public @ResponseBody Iterable<User> getAllUsers() {
		// This returns a JSON or XML with the users
		return userRepository.findAll();
	}
}
