package project.diet.control.modules.business;

import org.springframework.beans.factory.annotation.Autowired;

import lib.base.backend.persistance.GenericPersistence;
import lib.base.backend.utils.CatalogUtil;
import project.diet.control.app.util.BuildEntityToPojoUtil;
import project.diet.control.app.util.BuildPojoToEntityUtil;
import project.diet.control.app.util.DietUtil;

public class MainBusiness {

	@SuppressWarnings("rawtypes")
	@Autowired
	protected GenericPersistence genericCustomPersistance;
	
	protected BuildPojoToEntityUtil buildPojoToEntityUtil = new BuildPojoToEntityUtil();
	protected BuildEntityToPojoUtil buildEntityToPojoUtil = new BuildEntityToPojoUtil();
	protected CatalogUtil catalogUtil = new CatalogUtil();
	protected DietUtil dietUtil = new DietUtil();
}
