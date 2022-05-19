package br.com.uniride.controller;

import java.nio.charset.StandardCharsets;
import java.util.Calendar;
import java.util.Map;
import java.util.Optional;

import org.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.uniride.dao.UserRepository;
import br.com.uniride.dao.SessionRepository;
import br.com.uniride.model.Session;
import br.com.uniride.model.User;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private SessionRepository sessionRepository;

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

			return e.getMessage();

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
	public @ResponseBody Optional<User> get(@RequestParam("id") Long id) {

		return userRepository.findById(id);

	}

	/**
	 * Delete um usuário.
	 * 
	 * @param id
	 * @return String
	 */
	@DeleteMapping
	public @ResponseBody String delete(@RequestParam("id") Long id) {

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

	/**
	 * Autentica um usuário do sistema.
	 * 
	 * @param data
	 * @return User object
	 */

	@PostMapping(path = "/login")
	public @ResponseBody String login(@RequestBody Map<String, Object> data) {
		
		String cpf_mail = data.get("cpf_mail").toString();
		String password = data.get("password").toString();
		Session session = new Session();

		User user = userRepository.authenticate(cpf_mail, password);

		if (user != null) {

			session.setUser(user);
			session.setLogged_at(Calendar.getInstance().getTime());
			session.setLast_action_at(Calendar.getInstance().getTime());
			session.setOs("MacOSX");
			session.setAuth_key((password + cpf_mail).getBytes(StandardCharsets.UTF_8).toString());
			sessionRepository.save(session);
		}

		return session.getAuth_key();

	}
}
