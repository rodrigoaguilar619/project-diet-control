package project.diet.control.modules.business;

import org.springframework.beans.factory.annotation.Autowired;

import lib.base.backend.persistance.GenericPersistence;
import project.diet.control.app.util.BuildEntityToPojoUtil;
import project.diet.control.app.util.BuildPojoToEntityUtil;

public class MainBusiness {

	@SuppressWarnings("rawtypes")
	@Autowired
	protected GenericPersistence genericCustomPersistance;
	
	@Autowired
	protected BuildPojoToEntityUtil buildPojoToEntityUtil;
	
	@Autowired
	protected BuildEntityToPojoUtil buildEntityToPojoUtil;
}
