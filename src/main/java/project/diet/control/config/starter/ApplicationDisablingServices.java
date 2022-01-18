package project.diet.control.config.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.context.annotation.ComponentScan.Filter;

@EnableJpaRepositories("project.diet.control")
@EntityScan("project.diet.control.beans.entity")
@ComponentScan(basePackages = {"lib.base.backend.web.config", "project.diet.control"}, excludeFilters= @Filter(type = FilterType.REGEX, pattern="project.diet.control.schedules.*"))
//@EnableScheduling
@SpringBootApplication
public class ApplicationDisablingServices {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationDisablingServices.class, args);
	}

}
