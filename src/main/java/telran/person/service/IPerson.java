package telran.person.service;

import telran.person.domain.Person;
import telran.person.dto.AddressDto;
import telran.person.dto.RandomData;

public interface IPerson {
	
	boolean addPerson(Person person);
	
	void addPersons(Iterable<Person> persons);
	
	Person getPerson(int id);
	
	boolean updateAddress(int id, AddressDto address);
	
	boolean removePerson(int id);
	
	Iterable<Person> getAllPersons();
	
	Iterable<Person> getPersonByAge(int fromAge, int toAge);
	
	Iterable<Person> getPersonByCity(String city);
	
	Iterable<Person> getEmployeeBySalary(int fromSalary, int toSalary);

	boolean createRandomPersons(RandomData randomData);
}
