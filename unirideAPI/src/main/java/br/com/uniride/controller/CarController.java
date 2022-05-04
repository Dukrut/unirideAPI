package br.com.uniride.controller;

import java.util.Optional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.uniride.dao.BrandRepository;
import br.com.uniride.dao.CarRepository;
import br.com.uniride.dao.UserRepository;
import br.com.uniride.model.Brand;
import br.com.uniride.model.Car;
import br.com.uniride.model.User;

@RestController
@CrossOrigin
@RequestMapping("/car")
public class CarController {

	@Autowired
	private CarRepository carRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired 
	private BrandRepository brandRepository;

	private String response = "success";
	
	@PostMapping
	public @ResponseBody String create(@RequestParam JSONObject data) {
		
		String user_id = data.getString("user_id");
		Optional<User> user = userRepository.findById(Long.parseLong(user_id));
		System.out.println(user.isPresent());

		String brand_id = data.getString("brand_id");
		Optional<Brand> brand = brandRepository.findById(Long.parseLong(brand_id));
		System.out.println(brand.isPresent());
		
		if(!user.isPresent() || !brand.isPresent()) {
			return "Erro";
		}
		
		Car car = new Car();
		car.setBench(Integer.parseInt(data.getString("bench")));
		car.setColor(data.getString("color"));
		car.setPlate(data.getString("plate"));
		car.setYear(data.getString("year"));
		car.setUser(user.get());
		car.setBrand(brand.get());
		
		try {
			carRepository.save(car);
		} catch (Exception e) {

			return e.getMessage();

		}

		return response;
	}
	
	
	@GetMapping(path = "/all")
	public @ResponseBody Iterable<Car> getAll() {
		
		return carRepository.findAll();
	}
	
	@GetMapping
	public @ResponseBody Optional<Car> get(@RequestParam("id") Long id) {

		return carRepository.findById(id);

	}
}
