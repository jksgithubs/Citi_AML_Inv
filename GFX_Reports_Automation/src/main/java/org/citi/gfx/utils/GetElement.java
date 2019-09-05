package org.citi.gfx.utils;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import com.paulhammant.ngwebdriver.ByAngular;
import com.paulhammant.ngwebdriver.NgWebDriver;
import static org.citi.gfx.utils.GlobalVariables.*;

public class GetElement {
	public static WebElement Get(String locValue) throws Throwable{		
		try {
			switch(DataFromDB.GetLocatorName(locValue).toLowerCase()){
			case "id":
				return FluentWaits.getElement(By.id(DataFromDB.GetLocatorValue(locValue)));
			case "name":
				return FluentWaits.getElement(By.name(DataFromDB.GetLocatorValue(locValue)));
			case "classname":
				return FluentWaits.getElement(By.className(DataFromDB.GetLocatorValue(locValue)));
			case "linktext":
				return FluentWaits.getElement(By.linkText(DataFromDB.GetLocatorValue(locValue)));
			case "partiallinktext":
				return FluentWaits.getElement(By.partialLinkText(DataFromDB.GetLocatorValue(locValue)));
			case "xpath":
				return FluentWaits.getElement(By.xpath(DataFromDB.GetLocatorValue(locValue)));
			case "tagname":
				return FluentWaits.getElement(By.tagName(DataFromDB.GetLocatorValue(locValue)));
			case "cssselector":
				return FluentWaits.getElement(By.cssSelector(DataFromDB.GetLocatorValue(locValue)));
			case "ng-model": 
				NgWebDriver ngModel = new NgWebDriver((JavascriptExecutor) cDriver).withRootSelector(rootSelector);
				ByAngular.Factory NgByModel = ngModel.makeByAngularFactory();
				return cDriver.findElement(NgByModel.model(DataFromDB.GetLocatorValue(locValue)));
			case "ng-bind":
				NgWebDriver ngBind = new NgWebDriver((JavascriptExecutor) cDriver).withRootSelector(rootSelector);
				ByAngular.Factory NgByBind = ngBind.makeByAngularFactory();
				return cDriver.findElement(NgByBind.binding(DataFromDB.GetLocatorValue(locValue)));
			case "buttontext":
				NgWebDriver btnText = new NgWebDriver((JavascriptExecutor) cDriver).withRootSelector(rootSelector);
				ByAngular.Factory NgBybtnText = btnText.makeByAngularFactory();
				return cDriver.findElement(NgBybtnText.binding(DataFromDB.GetLocatorValue(locValue)));
			case "partialbuttontext":
				NgWebDriver parBtnText = new NgWebDriver((JavascriptExecutor) cDriver).withRootSelector(rootSelector);
				ByAngular.Factory NgByparBtnTxt = parBtnText.makeByAngularFactory();
				return cDriver.findElement(NgByparBtnTxt.binding(DataFromDB.GetLocatorValue(locValue)));
		}
		}catch(Throwable ex) {
			ExpHandler.Handle(ex, cDriver);
			ex.printStackTrace();
		}
		return null;
	}
	
	public static List<WebElement> Gets(String locValue) throws Throwable{
		try {
			switch(DataFromDB.GetLocatorName(locValue).toLowerCase()){
			case "id" 					: return cDriver.findElements(By.id(DataFromDB.GetLocatorValue(locValue)));
			case "name" 				: return cDriver.findElements(By.name(DataFromDB.GetLocatorValue(locValue)));
			case "classname" 			: return cDriver.findElements(By.className(DataFromDB.GetLocatorValue(locValue)));
			case "linktext" 			: return cDriver.findElements(By.linkText(DataFromDB.GetLocatorValue(locValue)));
			case "partiallinktext"  	: return cDriver.findElements(By.partialLinkText(DataFromDB.GetLocatorValue(locValue)));
			case "xpath" 				: return cDriver.findElements(By.xpath(DataFromDB.GetLocatorValue(locValue)));
			case "tagname" 				: return cDriver.findElements(By.tagName(DataFromDB.GetLocatorValue(locValue)));
			case "cssselector"  		: return cDriver.findElements(By.cssSelector(DataFromDB.GetLocatorValue(locValue)));
			case "ng-model"				: return cDriver.findElements(ByAngular.model(DataFromDB.GetLocatorValue(locValue)));
			case "ng-bind"				: return cDriver.findElements(ByAngular.binding(DataFromDB.GetLocatorValue(locValue)));
			case "buttontext"			: return cDriver.findElements(ByAngular.buttonText(DataFromDB.GetLocatorValue(locValue)));
			case "partialbuttontext"	: return cDriver.findElements(ByAngular.partialButtonText(DataFromDB.GetLocatorValue(locValue)));
		}
		}catch(Throwable ex) {
			ExpHandler.Handle(ex, cDriver);
			ex.printStackTrace();
		}
		return null;
	}
	
	public static WebElement GetRow(String locValue, int rowIndex) throws Throwable{		
		try {
			switch(DataFromDB.GetLocatorName(locValue).toLowerCase()){
			case "id":
				return FluentWaits.getElement(By.id(DataFromDB.GetLocatorValue(locValue)+rowIndex));
			case "name":
				return FluentWaits.getElement(By.name(DataFromDB.GetLocatorValue(locValue)+rowIndex));
			case "classname":
				return FluentWaits.getElement(By.className(DataFromDB.GetLocatorValue(locValue)+rowIndex));
			case "linktext":
				return FluentWaits.getElement(By.linkText(DataFromDB.GetLocatorValue(locValue)+rowIndex));
			case "partiallinktext":
				return FluentWaits.getElement(By.partialLinkText(DataFromDB.GetLocatorValue(locValue)+rowIndex));
			case "xpath":
				return FluentWaits.getElement(By.xpath(DataFromDB.GetLocatorValue(locValue)+rowIndex));
			case "tagname":
				return FluentWaits.getElement(By.tagName(DataFromDB.GetLocatorValue(locValue)+rowIndex));
			case "cssselector":
				return FluentWaits.getElement(By.cssSelector(DataFromDB.GetLocatorValue(locValue)+rowIndex));
			case "ng-model": 
				NgWebDriver ngModel = new NgWebDriver((JavascriptExecutor) cDriver).withRootSelector(rootSelector);
				ByAngular.Factory NgByModel = ngModel.makeByAngularFactory();
				return cDriver.findElement(NgByModel.model(DataFromDB.GetLocatorValue(locValue)+rowIndex));
			case "ng-bind":
				NgWebDriver ngBind = new NgWebDriver((JavascriptExecutor) cDriver).withRootSelector(rootSelector);
				ByAngular.Factory NgByBind = ngBind.makeByAngularFactory();
				return cDriver.findElement(NgByBind.binding(DataFromDB.GetLocatorValue(locValue)+rowIndex));
			case "buttontext":
				NgWebDriver btnText = new NgWebDriver((JavascriptExecutor) cDriver).withRootSelector(rootSelector);
				ByAngular.Factory NgBybtnText = btnText.makeByAngularFactory();
				return cDriver.findElement(NgBybtnText.buttonText(DataFromDB.GetLocatorValue(locValue)+rowIndex));
			case "partialbuttontext":
				NgWebDriver parBtnText = new NgWebDriver((JavascriptExecutor) cDriver).withRootSelector(rootSelector);
				ByAngular.Factory NgByparBtnTxt = parBtnText.makeByAngularFactory();
				return cDriver.findElement(NgByparBtnTxt.partialButtonText(DataFromDB.GetLocatorValue(locValue)+rowIndex));
		}
		}catch(Throwable ex) {
			ExpHandler.Handle(ex, cDriver);
			ex.printStackTrace();
		}
		return null;
	}
}