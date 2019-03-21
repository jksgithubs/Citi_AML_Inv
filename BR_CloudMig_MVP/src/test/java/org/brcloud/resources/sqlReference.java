package org.brcloud.resources;

import org.brcloud.utils.*;

public class sqlReference {
	//SQL to get Locators
	public static String sql_locators = "SELECT LOCATOR_VAL FROM SCFF_LOCATOR_REFERENCE "
			+ "WHERE LOCATOR_REF = '" + pubConstants.getLocatorRef +"'";
	
	//SQL to get common properties
	public static String sql_properties = "SELECT LOCATOR_VAL FROM SCFF_LOCATOR_REFERENCE "
			+ "WHERE LOCATOR_REF = '" + pubConstants.getLocatorRef +"'";
	
	//Test Data SQL reference for feature pocFeature.feature
	public static String interact_with_ng_model = "SELECT * FROM ANGULAR_NAME";
	public static String interact_with_non_angular_locator = "SELECT * FROM GOOGLE_SEARCH";
}
