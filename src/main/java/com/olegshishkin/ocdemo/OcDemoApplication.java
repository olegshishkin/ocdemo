package com.olegshishkin.ocdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@SpringBootApplication
public class OcDemoApplication {

	private final PersonService service;

	@Autowired
	public OcDemoApplication(PersonService service) {
		this.service = service;
	}

	@GetMapping("/all")
	public List<Person> findAll() {
		return service.findAll();
	}

	@GetMapping("/person")
	public Person addPerson(@RequestParam String name) {
        Person p = new Person();
        p.setName(name);
		return service.save(p);
	}

	public static void main(String[] args) {
		SpringApplication.run(OcDemoApplication.class, args);
	}
}
