package test.project.diet.control.main;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

import project.diet.control.config.starter.Application;

import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.boot.test.context.SpringBootTest;

@ComponentScan(basePackages = {"project.diet.control.config", "project.diet.control.services"}, 
excludeFilters= {@Filter(type = FilterType.REGEX, pattern="project.diet.control.test.*"),
		@Filter(type = FilterType.REGEX, pattern="project.diet.control.repository.*"),
		@Filter(type = FilterType.REGEX, pattern="project.diet.control.business.*"),
		@Filter(type = FilterType.REGEX, pattern="project.diet.control.config.starter.*"),
		@Filter(type = FilterType.REGEX, pattern="project.diet.control.config.beans.DataBaseBeans")})
@SpringBootTest(classes = Application.class)
@SpringBootApplication(exclude = {
    DataSourceAutoConfiguration.class, 
    DataSourceTransactionManagerAutoConfiguration.class, 
    HibernateJpaAutoConfiguration.class
})
public class MainNotJpaTest {

}
