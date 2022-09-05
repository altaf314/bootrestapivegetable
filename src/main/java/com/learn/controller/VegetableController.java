package com.learn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.learn.model.Vegetable;
import com.learn.service.VegetableService;

@RestController
@RequestMapping("/vegetable")
@CrossOrigin
public class VegetableController {

	@Autowired
	private VegetableService vegetableService;

	@PostMapping
	public Vegetable saveVegetable(@RequestBody Vegetable vegetable) {
		return this.vegetableService.saveVegetable(vegetable);
	}

	@GetMapping("/hello")
	public String wish() {
		return "Hello Altaf Welcome to SpringBoot,Heroku Deployed";
	}

	@GetMapping
	public List<Vegetable> getAllVegetables() {
		return this.vegetableService.getAllVegetables();
	}

	@GetMapping("/{id}")
	public Vegetable getVegetableById(@PathVariable("id") int id) {
		return this.vegetableService.getVegetableById(id);
	}

	@PutMapping("/{id}")
	public Vegetable updateVegetable(@RequestBody Vegetable vegetable, @PathVariable("id") int id) {
		return this.vegetableService.updateVegetable(vegetable, id);

	}

	@DeleteMapping("/{vid}")
	public void deleteVegetable(@PathVariable("vid") int id) {
		this.vegetableService.deleteVegetable(id);
	}

	// localhost:8092/vegetable/name?name=Brinjal
	// @GetMapping("/name")
	// @ResponseBody
	// public Vegetable findByName(@RequestParam String name)
	// {
	// return vegetableService.findByName(name);
	// }

	@GetMapping("/name/{name}")
	public Vegetable findByName(@PathVariable("name") String name) {
		return vegetableService.findByName(name);
	}
}
