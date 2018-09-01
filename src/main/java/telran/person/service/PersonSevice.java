package telran.person.service;

import java.time.LocalDate;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import telran.person.dao.PersonRepository;
import telran.person.domain.Address;
import telran.person.domain.Person;
import telran.person.dto.AddressDto;

@Service
public class PersonSevice implements IPerson {
	@Autowired
	PersonRepository personRepository;

	@Override
	public void addPerson(Person person) {
		personRepository.save(person);
	}

	@Override
	public Person getPerson(int id) {
		return personRepository.findById(id).orElse(null);
	}

	@Override
	public void addPersons(Iterable<Person> persons) {
		personRepository.saveAll(persons);
		
	}

	@Override
	public boolean updateAddress(int id, AddressDto address) {
		
		return true;
	}

	@Override
	public boolean removePerson(int id) {
		if(!personRepository.existsById(id)) {
			return false;
		}
		personRepository.deleteById(id);
		return true;
	}

	@Override
	public Iterable<Person> getAllPersons() {
		return personRepository.findAll();
	}

	@Override
	public Iterable<Person> getPersonByAge(int fromAge, int toAge) {
		LocalDate fromDate = getDateFromAge(toAge);
		LocalDate toDate = getDateFromAge(fromAge);
		return personRepository.findByBirthdateBetween(fromDate, toDate);
	}

	private LocalDate getDateFromAge(int fromAge) {
		return LocalDate.now().minusYears(fromAge);
	}

	@Override
	public Iterable<Person> getPersonByCity(String city) {
		return personRepository.findByAddressCity(city);
	}

	@Override
	public Iterable<Person> getEmployeeBySalary(int fromSalary, int toSalary) {
		return null;
	}

}
