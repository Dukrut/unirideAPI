package br.com.uniride.controller;

import java.util.Optional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.uniride.dao.BrandRepository;
import br.com.uniride.model.Brand;
import br.com.uniride.model.Car;

@RestController
@CrossOrigin
@RequestMapping("/brand")
public class BrandController {

	@Autowired
	private BrandRepository brandRepository;
	
	private String response = "success";
	
	@PostMapping
	public @ResponseBody String create(@RequestParam JSONObject data) {

		Brand brand = new Brand();
		brand.setFullname(data.get("fullname").toString());

		try {
			brandRepository.save(brand);
		} catch (Exception e) {

			return e.getMessage();

		}

		return response;
	}
	
	@GetMapping(path = "/all")
	public @ResponseBody Iterable<Brand> getAll() {
		
		return brandRepository.findAll();
	}
	
	@GetMapping
	public @ResponseBody Optional<Brand> get(@RequestParam("id") Long id) {

		return brandRepository.findById(id);

	}
}
