package br.com.erudio.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.model.Person;
import br.com.erudio.services.PersonServices;

@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private PersonServices personService;
	
	@GetMapping
	public List<Person> findByAll() {
		
		return personService.findAll();
		
	}

	@GetMapping("/{id}")
	public Person findById(@PathVariable("id") Long id) {
		
		return personService.findById(id);
		
	}
	
	@PostMapping
	public Person create(@RequestBody Person person) {
		
		return personService.create(person);
		
	}
	
	
	@PutMapping
	public Person update(@RequestBody Person person) {
		
		return personService.update(person);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		
		personService.delete(id);
		return ResponseEntity.ok().build();
		
	}
}
