package telran.person.service;

import java.time.LocalDate;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import telran.person.dao.PersonRepository;
import telran.person.domain.Address;
import telran.person.domain.Child;
import telran.person.domain.Employee;
import telran.person.domain.Person;
import telran.person.dto.AddressDto;
import telran.person.dto.RandomData;

@Service
public class PersonSevice implements IPerson {
	@Autowired
	PersonRepository personRepository;

	public static final Random rnd = new Random();

    @Override
	public boolean addPerson(Person person) {
		Person personAdded = personRepository.save(person);
		if(personAdded == null) {
			return false;
		}

		return true;
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

	@Override
	public boolean createRandomPersons(RandomData randomData) {


		int min_id = randomData.getMin_id();
		int countOfEmployes = (int)randomData.getN_persons()*randomData.getPercent_empl()/100;
		int count = 1;

        int MIN_EMPL_YEAR = 1951;
        int MAX_EMPL_YEAR = 2000;
        int MIN_CHILD_YEAR = 2013;
        int MAX_CHILD_YEAR = 2018;

		Person person = null;

		for (int i = 1; i < randomData.getN_persons(); i++) {

			int currentId = min_id++;
			String name = "name"+randomInTheRange(1, randomData.getN_names());

            int yearEmploye = randomInTheRange(MIN_EMPL_YEAR, MAX_EMPL_YEAR);
            int yearChild = randomInTheRange(MIN_CHILD_YEAR, MAX_CHILD_YEAR);
            int month = randomInTheRange(1, 12);
            int day = randomInTheRange(1, 28);

			String city = "city"+randomInTheRange(1, randomData.getN_cities());
			String street = "street"+randomInTheRange(1, randomData.getN_streets());
			int building = randomInTheRange(1, randomData.getN_buildings());

			int salary = randomInTheRange(randomData.getMin_salary(), randomData.getMax_salary());
			String company = "company"+ randomInTheRange(1, randomData.getN_companies());

			String garten = "garten"+ randomInTheRange(1, randomData.getN_gartens());

			if(count++ < countOfEmployes) {
				person = new Employee(currentId,
						name,
						LocalDate.of(yearEmploye, month, day),
						new Address(city, street, building),
						company,
						salary);

			} else {
				person = new Child(currentId,
						name,
						LocalDate.of(yearChild, month, day),
						new Address(city, street, building),
						garten);
			}

			addPerson(person);
		}
		return true;
	}

	private int randomInTheRange(int min, int max) {
		return rnd.nextInt((max - min) + 1) + min;
	}

}
