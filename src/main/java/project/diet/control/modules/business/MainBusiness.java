package project.diet.control.modules.business;

import lib.base.backend.utils.CatalogUtil;
import project.diet.control.app.util.BuildEntityToPojoUtil;
import project.diet.control.app.util.BuildPojoToEntityUtil;
import project.diet.control.app.util.DietUtil;

public class MainBusiness {
	
	protected BuildPojoToEntityUtil buildPojoToEntityUtil = new BuildPojoToEntityUtil();
	protected BuildEntityToPojoUtil buildEntityToPojoUtil = new BuildEntityToPojoUtil();
	protected CatalogUtil catalogUtil = new CatalogUtil();
	protected DietUtil dietUtil = new DietUtil();
}
