package com.olegshishkin.ocdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RequestMapping("/ocdemo")
@RestController
@SpringBootApplication
public class OcDemoApplication {

	private final PersonService service;

	@Autowired
	public OcDemoApplication(PersonService service) {
		this.service = service;
	}

	@GetMapping("/")
	public List<Person> findAll() {
		return service.findAll();
	}

	@GetMapping("/person")
	public Person addPerson(@RequestParam String name) {
		Person p = Person.builder()
				.name(name)
				.build();
		return service.save(p);
	}

	public static void main(String[] args) {
		SpringApplication.run(OcDemoApplication.class, args);
	}
}
