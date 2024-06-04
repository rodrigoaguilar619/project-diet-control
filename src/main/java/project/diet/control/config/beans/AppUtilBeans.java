package project.diet.control.config.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lib.base.backend.modules.catalog.interaface.CatalogDefinition;
import project.diet.control.app.util.BuildEntityToPojoUtil;
import project.diet.control.app.util.BuildPojoToEntityUtil;
import project.diet.control.app.util.DietUtil;
import project.diet.control.config.catalog.CatalogDietControlDefinition;

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
	
	@Bean
	public CatalogDefinition buildCatalogDefinition() {
		return new CatalogDietControlDefinition();
	}
}
