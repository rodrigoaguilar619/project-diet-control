package project.diet.control.config.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lib.base.backend.utils.CatalogUtil;
import lib.base.backend.utils.JpaUtil;
import lib.utils.backend.format.DateFormatUtil;
import lib.utils.backend.format.DateUtil;
import project.diet.control.util.BuildEntityToPojoUtil;
import project.diet.control.util.BuildPojoToEntityUtil;
import project.diet.control.util.DietUtil;

@Configuration
public class UtilBeans {
	
	@Bean
	public DateFormatUtil generateDateFormatUtil() {
		return new DateFormatUtil();
	}
	
	@Bean
	public DateUtil generateDateUtil() {
		return new DateUtil();
	}
	
	@Bean
	public BuildEntityToPojoUtil buildEntityToPojoUtil() {
		return new BuildEntityToPojoUtil();
	}
	
	@Bean
	public BuildPojoToEntityUtil buildPojoToEntityUtil() {
		return new BuildPojoToEntityUtil();
	}
	
	@Bean
	public JpaUtil buildJpaUtil() {
		return new JpaUtil();
	}
	
	@Bean
	public CatalogUtil buildCatalogUtil() {
		return new CatalogUtil();
	}
	
	@Bean
	public DietUtil buildDietUtil() {
		return new DietUtil();
	}
}
