package com.tcl.assignemnt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
/*****
 * This assignment is created for the testing purpose only 
 * @author Sagar
 *
 */

@EnableJpaAuditing
@SpringBootApplication
public class AssignemntApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssignemntApplication.class, args);
	}

}
