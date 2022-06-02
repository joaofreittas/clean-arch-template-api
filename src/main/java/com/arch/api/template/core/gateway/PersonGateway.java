package com.arch.api.template.core.gateway;

import com.arch.api.template.core.domain.Person;

import java.util.List;

public interface PersonGateway {

    List<Person> findAll();
    Person save(Person person);
    Person changeName(String id, String newName);

}
