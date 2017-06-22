package io.github.richardmars.spring.hibernate.dao;

import java.util.List;

import io.github.richardmars.spring.hibernate.model.Person;

public interface PersonDAO {
	public void save(Person p);

	public List<Person> list();
}
