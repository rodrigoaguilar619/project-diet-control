package project.diet.control.config.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import project.diet.control.app.util.BuildEntityToPojoUtil;
import project.diet.control.app.util.BuildPojoToEntityUtil;
import project.diet.control.app.util.DietUtil;

@Configuration
public class AppUtilBeans {
	
	@Bean
	public BuildEntityToPojoUtil buildEntityToPojoUtil() {
		return new BuildEntityToPojoUtil();
	}
	
	@Bean
	public BuildPojoToEntityUtil buildPojoToEntityUtil() {
		return new BuildPojoToEntityUtil();
	}
	
	@Bean
	public DietUtil buildDietUtil() {
		return new DietUtil();
	}
}
