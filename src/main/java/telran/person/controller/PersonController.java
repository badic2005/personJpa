package telran.person.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import telran.person.domain.Person;
import telran.person.dto.AddressDto;
import telran.person.service.IPerson;

@RestController
public class PersonController {
	@Autowired
	IPerson personService;
	
	@PostMapping("/person")
	public void addPerson(@RequestBody Person person) {
		personService.addPerson(person);
	}
	
	@GetMapping("/person/{id}")
	public Person getPerson(@PathVariable int id) {
		return personService.getPerson(id);
	}
	
	@DeleteMapping("/person/{id}")
	public boolean deletePerson(@PathVariable int id) {
		return personService.removePerson(id);
	}
	
	@PutMapping("/person/{id}")
	public boolean updateAddress(@PathVariable int id, @RequestBody AddressDto address) {
		return personService.updateAddress(id, address);
	}
	
	@GetMapping("/persons/{minAge}/{maxAge}")
	public Iterable<Person> getPersonsByAge(@PathVariable int minAge, @PathVariable  int maxAge){
		return personService.getPersonByAge(minAge, maxAge);
	}
	
	@GetMapping("/persons/salary/{minSalary}/{maxSalary}")
	public Iterable<Person> getEmployeeBySalary(@PathVariable int minSalary, @PathVariable int maxSalary){
		return personService.getEmployeeBySalary(minSalary, maxSalary);
	}
	
	@GetMapping("/persons/{city}")
	public Iterable<Person> getPersonsByCity(@PathVariable String city){
		return personService.getPersonByCity(city);
	}
	

}
