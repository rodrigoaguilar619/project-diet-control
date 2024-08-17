package project.diet.control.app.vo.catalogs;

public class CatalogsErrorMessage {

	private CatalogsErrorMessage(){}
	
	private static final String ERROR_MSG_DIET_NOT_FOUND_REQUEST = "Diet data not found on request";
	private static final String ERROR_MSG_DIET_BASE_EXIST = "Diet base already exist id: %s title: %s";
	private static final String ERROR_MSG_DIET_CUSTOM_EXIST = "Diet custom already exist id: %s title: %s";
	private static final String ERROR_MSG_DIET_ID_IS_NULL = "Diet id is null";
	private static final String ERROR_MSG_DIET_ID_NOT_FOUND = "Diet id: %s not found";
	private static final String ERROR_MSG_DIET_CUSTOM_DATA_NOT_FOUND_REQUEST = "Diet custom data not found on request";
	private static final String ERROR_MSG_DIET_IS_DATE_BASE = "Diet id: %s is a base diet, can be edited as custom";
	private static final String ERROR_MSG_FOOD_NOT_FOUND_REQUEST = "Food data not found on request";
	private static final String ERROR_MSG_FOOD_ID_IS_NULL = "Food id is null";
	private static final String ERROR_MSG_FOOD_ID_NOT_FOUND = "Food id: %s not found";
	private static final String ERROR_MSG_FOOD_ID_USED_ON_DIET_CUSTOM = "Id food is used on a diet custom";
	private static final String ERROR_MSG_RECIPE_NOT_FOUND_REQUEST = "Recipe data not found on request";
	private static final String ERROR_MSG_RECIPE_ID_IS_NULL = "Recipe id is null";
	private static final String ERROR_MSG_RECIPE_ID_NOT_FOUND = "Recipe id: %s not found";
	private static final String ERROR_MSG_RECIPE_ID_USED_ON_DIET_CUSTOM = "Recipe is use on a diet";
	
	public static String getErrorMsgDietNotFoundRequest() {
		return ERROR_MSG_DIET_NOT_FOUND_REQUEST;
	}

	public static String getErrorMsgDietCustomExist(Integer id, String title) {
		return String.format(ERROR_MSG_DIET_CUSTOM_EXIST, id, title);
	}
	
	public static String getErrorMsgDietIdIsNull() {
		return ERROR_MSG_DIET_ID_IS_NULL;
	}

	public static String getErrorMsgDietIdNotFound(Integer id) {
		return String.format(ERROR_MSG_DIET_ID_NOT_FOUND, id);
	}
	
	public static String getErrorMsgDietCustomDataNotFoundRequest() {
		return ERROR_MSG_DIET_CUSTOM_DATA_NOT_FOUND_REQUEST;
	}

	public static String getErrorMsgDietBaseExist(Integer id, String title) {
		return String.format(ERROR_MSG_DIET_BASE_EXIST, id, title);
	}

	public static String getErrorMsgDietIsDateBase(Integer id) {
		return String.format(ERROR_MSG_DIET_IS_DATE_BASE, id);
	}

	public static String getErrorMsgFoodNotFoundRequest() {
		return ERROR_MSG_FOOD_NOT_FOUND_REQUEST;
	}
	
	public static String getErrorMsgFoodIdIsNull() {
		return ERROR_MSG_FOOD_ID_IS_NULL;
	}

	public static String getErrorMsgFoodIdNotFound(Integer id) {
		return String.format(ERROR_MSG_FOOD_ID_NOT_FOUND, id);
	}

	public static String getErrorMsgFoodIdUsedOnDietCustom() {
		return ERROR_MSG_FOOD_ID_USED_ON_DIET_CUSTOM;
	}

	public static String getErrorMsgRecipeNotFoundRequest() {
		return ERROR_MSG_RECIPE_NOT_FOUND_REQUEST;
	}
	
	public static String getErrorMsgRecipeIdIsNull() {
		return ERROR_MSG_RECIPE_ID_IS_NULL;
	}

	public static String getErrorMsgRecipeIdNotFound(Integer id) {
		return String.format(ERROR_MSG_RECIPE_ID_NOT_FOUND, id);
	}

	public static String getErrorMsgRecipeIdUsedOnDietCustom() {
		return ERROR_MSG_RECIPE_ID_USED_ON_DIET_CUSTOM;
	}
}
