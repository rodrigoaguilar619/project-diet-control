package project.diet.control.controller.diet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lib.base.backend.utils.RestUtil;
import project.diet.control.business.diet.CrudDietBusiness;
import project.diet.control.pojos.request.diet.RegisterDietBaseRequestPojo;
import project.diet.control.pojos.response.diet.AddEditDietRespPojo;

@RestController
public class CrudDietController {

	@Autowired
	CrudDietBusiness crudDietBusiness;
}
