package br.com.uniride.controller;

import java.util.Optional;

import org.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.uniride.dao.UserRepository;
import br.com.uniride.model.User;

@RestController
@CrossOrigin
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	private String response = "success";

	/**
	 * Criação de um usuário.
	 * 
	 * @param data
	 * @return String
	 */

	@PostMapping
	public @ResponseBody String create(@RequestParam JSONObject data) {

		User user = new User();
		user.setFullname(data.get("fullname").toString());
		user.setMail(data.get("mail").toString());
		user.setCpf(data.get("cpf").toString());
		user.setPassword(data.get("password").toString());
		user.setGender(data.get("gender").toString());
		user.setAge(data.get("age").toString());

		try {
			userRepository.save(user);
		} catch (Exception e) {

			return e.toString();

		}

		return response;

	}

	/**
	 * Busca por um usuário.
	 * 
	 * @param id
	 * @return User
	 */

	@GetMapping
	public @ResponseBody Optional<User> get(@RequestParam("id") int id) {

		return userRepository.findById(id);

	}

	/**
	 * Delete um usuário.
	 * 
	 * @param id
	 * @return String
	 */
	@DeleteMapping
	public @ResponseBody String delete(@RequestParam("id") int id) {

		userRepository.deleteById(id);
		return response;

	}

	/**
	 * Retorna lista de usuários.
	 * 
	 * @return List users
	 */
	@GetMapping(path = "/all")
	public @ResponseBody Iterable<User> getAll() {

		return userRepository.findAll();

	}

	@PostMapping(path = "/login")
	public @ResponseBody String login(@RequestParam JSONObject data) {

		String cpf_mail = data.get("cpf_mail").toString();
		String password = data.get("password").toString();
		
		System.out.println(cpf_mail);
		System.out.println(password);
		User teste = userRepository.authenticate(cpf_mail, password);

		System.out.println(teste);

		return response;

	}
}
