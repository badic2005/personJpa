package telran.person.dao;

import java.time.LocalDate;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.repository.CrudRepository;
import telran.person.domain.Person;

public interface PersonRepository extends CrudRepository<Person, Integer> {
	Iterable<Person> findByBirthdateBetween(LocalDate fromDate, LocalDate toDate);

	Stream<Person> findAllBy();
	
	Iterable<Person> findByAddressCity(String city);
}
