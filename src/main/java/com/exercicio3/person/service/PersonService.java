package com.exercicio3.person.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.exercicio3.person.model.Person;

@Service
public class PersonService {
	
	private final AtomicLong counter = new AtomicLong();
	private static Person personMock = new Person();
	
	public Person findById(String id) {
		Person person = mockPerson(counter.incrementAndGet());
		return person; 
	}
	
	public List<Person> findAll() {
		List<Person> list = new ArrayList<>();
		list = mockList(8);
		return list;
	}

	private List<Person> mockList(int sizeList) {
		List<Person> list = new ArrayList<>();
		for(int i = 0; i < sizeList; i++) {
			list.add(mockPerson(counter.incrementAndGet()));
		}
		return list;
	}
	
	private Person mockPerson(long index) {
		return new Person(index, "Name - "+ index, "Last Name - "+ index, "Address - "+ index, "Gender - "+ index);
	}

	public Person createOrUpdateMock(Person person) {
		personMock.setFirstName(person.getFirstName());
		personMock.setLastName(person.getLastName());
		personMock.setAddress(person.getAddress());
		personMock.setGender(person.getGender());
		personMock.setId(counter.incrementAndGet());
		return personMock;
	}

	public void delete(String id) {
	}
	

}
