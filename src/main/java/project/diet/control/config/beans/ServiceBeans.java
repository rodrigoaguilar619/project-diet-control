package project.diet.control.config.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lib.base.backend.modules.catalog.interaface.CatalogDefinition;
import project.diet.control.config.catalog.CatalogDietControlDefinition;

@Configuration
public class ServiceBeans {

	@Bean
	public CatalogDefinition buildCatalogDefinition() {
		return new CatalogDietControlDefinition();
	}
}
