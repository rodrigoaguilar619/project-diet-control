package project.diet.control.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import lib.base.backend.web.config.beans.DataBaseBeans;
import org.springframework.context.annotation.ComponentScan.Filter;

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
public abstract class AppDietControlIindividualTest {

	public static void main(String[] args) {
		SpringApplication.run(AppDietControlIindividualTest.class, args);
	}
}
