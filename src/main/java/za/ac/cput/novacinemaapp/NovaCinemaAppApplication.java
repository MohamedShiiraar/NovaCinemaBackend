package za.ac.cput.novacinemaapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "za.ac.cput.novacinemaapp.repository")
public class NovaCinemaAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(NovaCinemaAppApplication.class, args);
    }

}
