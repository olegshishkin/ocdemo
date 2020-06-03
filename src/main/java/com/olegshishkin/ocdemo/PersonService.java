package com.olegshishkin.ocdemo;

import java.util.List;
import java.util.Optional;

public interface PersonService {

    Optional<Person> findByName(String name);

    List<Person> findAll();

    Person save(Person person);
}
