package project.diet.control.controller.diet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import project.diet.control.business.diet.CrudDietBusiness;

@RestController
public class CrudDietController {

	@Autowired
	CrudDietBusiness crudDietBusiness;
}
