package br.com.lead.springdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@Controller
public class SpringdemoApplication {
	
	@RequestMapping("/")
	@ResponseBody
	public String bemVindoAoSpring( ) {
		return "Bem-vindo ao Spring Boot.";
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringdemoApplication.class, args);
	}

}
