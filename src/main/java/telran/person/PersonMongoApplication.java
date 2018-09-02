package telran.person;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("telran.person")
public class PersonMongoApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(PersonMongoApplication.class, args);
	}
}
