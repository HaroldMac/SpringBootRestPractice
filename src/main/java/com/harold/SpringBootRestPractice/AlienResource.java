package com.harold.SpringBootRestPractice;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlienResource {
	
	@Autowired
	AlienRepository repo;
	
	@GetMapping("aliens")
	public List<Alien> getAliens(){
		
		List<Alien> aliens = (List<Alien>)repo.findAll();
		
		
		return aliens;
	}
	
	@GetMapping("alien/{id}")
	public Alien getAlien(@PathVariable("id") int id){
		//int id = 101;
		Alien alien = (Alien)repo.findOne(id);
		
		
		return alien;
	}
	
	@PostMapping("/alien/")
	public void createAlien(@RequestBody Alien a){
		//Alien a = new Alien();
		repo.save(a);
		
	}
}
