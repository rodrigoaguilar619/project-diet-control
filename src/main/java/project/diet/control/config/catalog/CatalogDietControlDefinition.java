package project.diet.control.config.catalog;

import java.util.LinkedHashMap;
import java.util.Map;

import lib.base.backend.modules.catalog.interaface.CatalogDefinition;
import project.diet.control.app.beans.entity.FoodEntity;

public class CatalogDietControlDefinition implements CatalogDefinition {

	@SuppressWarnings("rawtypes")
	Map<String, Class> catalogs = new LinkedHashMap<>();
	
	public CatalogDietControlDefinition() {
		
		catalogs.put("food", FoodEntity.class);
		
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Map<String, Class> getCatalogsDefinition() {
		return catalogs;
	}

}
