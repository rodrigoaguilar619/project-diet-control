package test.diet.control.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.ComponentScan.Filter;

import lib.base.backend.modules.web.config.beans.DataBaseBeans;

@SpringBootApplication(exclude = {
	    DataSourceAutoConfiguration.class, 
	    DataSourceTransactionManagerAutoConfiguration.class, 
	    HibernateJpaAutoConfiguration.class
	})
@ComponentScan(basePackages = "${app.config.component.scan}",
	excludeFilters = {
			@ComponentScan.Filter(type = FilterType.REGEX, pattern = "lib.base.backend.web.repository.*"),
			@ComponentScan.Filter(type = FilterType.REGEX, pattern = "project.diet.control.config.*"),
			@ComponentScan.Filter(type = FilterType.REGEX, pattern = "project.diet.control.app.*"),
			@ComponentScan.Filter(type = FilterType.REGEX, pattern = "project.diet.control.modules.*"),
			@Filter(type = FilterType.ASSIGNABLE_TYPE, value = DataBaseBeans.class),			
	})
public class AppDietControlIndividualTest {

	public static void main(String[] args) {
		SpringApplication.run(AppDietControlIndividualTest.class, args);
	}
}
