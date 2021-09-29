package br.edu.infnet.appmec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableFeignClients
@EntityScan(basePackages = {"br.edu.infnet.appmec.model.domain"})
@EnableJpaRepositories(basePackages = {"br.edu.infnet.appmec.model.repository"})
public class AppmecApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppmecApplication.class, args);
	}

}
