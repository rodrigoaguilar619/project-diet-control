package project.diet.control.business;

import org.springframework.beans.factory.annotation.Autowired;

import lib.base.backend.persistance.GenericPersistence;
import project.diet.control.util.BuildEntityToPojoUtil;
import project.diet.control.util.BuildPojoToEntityUtil;

public class MainBusiness {

	@SuppressWarnings("rawtypes")
	@Autowired
	protected GenericPersistence genericCustomPersistance;
	
	@Autowired
	protected BuildPojoToEntityUtil buildPojoToEntityUtil;
	
	@Autowired
	protected BuildEntityToPojoUtil buildEntityToPojoUtil;
}
