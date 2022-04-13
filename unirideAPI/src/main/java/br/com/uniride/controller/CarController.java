package br.com.uniride.controller;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.uniride.model.Car;

@RestController
@CrossOrigin
@RequestMapping("/cars")
public class CarController {

	private String response = "success";

	@PostMapping
	public @ResponseBody String create(@RequestParam JSONObject data) {

		Car car = new Car();

		car.setBench(data.get("bench").toString());
		car.setPlate(data.get("plate").toString());
		car.setColor(data.get("color").toString());
		car.setYear(data.get("year").toString());

		return response;
	}

}
