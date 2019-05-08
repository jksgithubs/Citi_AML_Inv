package org.citi.utils;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.paulhammant.ngwebdriver.ByAngular;
import com.paulhammant.ngwebdriver.NgWebDriver;
import org.citi.utils.*;

@SuppressWarnings("unused")
public class GetElement {
	public static WebElement Get(String locValue) throws Throwable{		
		try {
			switch(DataFromDB.LocatorName(locValue).toLowerCase()){
			case "id":
				return FluentWaits.getElement(By.id(DataFromDB.Locator(locValue)));
			case "name":
				return FluentWaits.getElement(By.name(DataFromDB.Locator(locValue)));
			case "classname":
				return FluentWaits.getElement(By.className(DataFromDB.Locator(locValue)));
			case "linktext":
				return FluentWaits.getElement(By.linkText(DataFromDB.Locator(locValue)));
			case "partiallinktext":
				return FluentWaits.getElement(By.partialLinkText(DataFromDB.Locator(locValue)));
			case "xpath":
				return FluentWaits.getElement(By.xpath(DataFromDB.Locator(locValue)));
			case "tagname":
				return FluentWaits.getElement(By.tagName(DataFromDB.Locator(locValue)));
			case "cssselector":
				return FluentWaits.getElement(By.cssSelector(DataFromDB.Locator(locValue)));
			case "ng-model": 
				NgWebDriver ngModel = new NgWebDriver((JavascriptExecutor) PubVariables.bDriver).withRootSelector(PubVariables.rootSelector);
				ByAngular.Factory NgByModel = ngModel.makeByAngularFactory();
				return PubVariables.bDriver.findElement(NgByModel.model(DataFromDB.Locator(locValue)));
			case "ng-bind":
				NgWebDriver ngBind = new NgWebDriver((JavascriptExecutor) PubVariables.bDriver).withRootSelector(PubVariables.rootSelector);
				ByAngular.Factory NgByBind = ngBind.makeByAngularFactory();
				return PubVariables.bDriver.findElement(NgByBind.binding(DataFromDB.Locator(locValue)));
			case "buttontext":
				NgWebDriver btnText = new NgWebDriver((JavascriptExecutor) PubVariables.bDriver).withRootSelector(PubVariables.rootSelector);
				ByAngular.Factory NgBybtnText = btnText.makeByAngularFactory();
				return PubVariables.bDriver.findElement(NgBybtnText.binding(DataFromDB.Locator(locValue)));
			case "partialbuttontext":
				NgWebDriver parBtnText = new NgWebDriver((JavascriptExecutor) PubVariables.bDriver).withRootSelector(PubVariables.rootSelector);
				ByAngular.Factory NgByparBtnTxt = parBtnText.makeByAngularFactory();
				return PubVariables.bDriver.findElement(NgByparBtnTxt.binding(DataFromDB.Locator(locValue)));
		}
		}catch(Throwable ex) {
			ExpHandler.Handle(ex, PubVariables.bDriver);
			ex.printStackTrace();
		}
		return null;
	}
	
	public static List<WebElement> Gets(String locValue) throws Throwable{
		try {
			switch(DataFromDB.LocatorName(locValue).toLowerCase()){
			case "id" 					: return PubVariables.bDriver.findElements(By.id(DataFromDB.Locator(locValue)));
			case "name" 				: return PubVariables.bDriver.findElements(By.name(DataFromDB.Locator(locValue)));
			case "classname" 			: return PubVariables.bDriver.findElements(By.className(DataFromDB.Locator(locValue)));
			case "linktext" 			: return PubVariables.bDriver.findElements(By.linkText(DataFromDB.Locator(locValue)));
			case "partiallinktext"  	: return PubVariables.bDriver.findElements(By.partialLinkText(DataFromDB.Locator(locValue)));
			case "xpath" 				: return PubVariables.bDriver.findElements(By.xpath(DataFromDB.Locator(locValue)));
			case "tagname" 				: return PubVariables.bDriver.findElements(By.tagName(DataFromDB.Locator(locValue)));
			case "cssselector"  		: return PubVariables.bDriver.findElements(By.cssSelector(DataFromDB.Locator(locValue)));
			case "ng-model"				: return PubVariables.bDriver.findElements(ByAngular.model(DataFromDB.Locator(locValue)));
			case "ng-bind"				: return PubVariables.bDriver.findElements(ByAngular.binding(DataFromDB.Locator(locValue)));
			case "buttontext"			: return PubVariables.bDriver.findElements(ByAngular.buttonText(DataFromDB.Locator(locValue)));
			case "partialbuttontext"	: return PubVariables.bDriver.findElements(ByAngular.partialButtonText(DataFromDB.Locator(locValue)));
		}
		}catch(Throwable ex) {
			ExpHandler.Handle(ex, PubVariables.bDriver);
			ex.printStackTrace();
		}
		return null;
	}
	
	public static WebElement GetRow(String locValue, int rowIndex) throws Throwable{		
		try {
			switch(DataFromDB.LocatorName(locValue).toLowerCase()){
			case "id":
				return FluentWaits.getElement(By.id(DataFromDB.Locator(locValue)+rowIndex));
			case "name":
				return FluentWaits.getElement(By.name(DataFromDB.Locator(locValue)+rowIndex));
			case "classname":
				return FluentWaits.getElement(By.className(DataFromDB.Locator(locValue)+rowIndex));
			case "linktext":
				return FluentWaits.getElement(By.linkText(DataFromDB.Locator(locValue)+rowIndex));
			case "partiallinktext":
				return FluentWaits.getElement(By.partialLinkText(DataFromDB.Locator(locValue)+rowIndex));
			case "xpath":
				return FluentWaits.getElement(By.xpath(DataFromDB.Locator(locValue)+rowIndex));
			case "tagname":
				return FluentWaits.getElement(By.tagName(DataFromDB.Locator(locValue)+rowIndex));
			case "cssselector":
				return FluentWaits.getElement(By.cssSelector(DataFromDB.Locator(locValue)+rowIndex));
			case "ng-model": 
				NgWebDriver ngModel = new NgWebDriver((JavascriptExecutor) PubVariables.bDriver).withRootSelector(PubVariables.rootSelector);
				ByAngular.Factory NgByModel = ngModel.makeByAngularFactory();
				return PubVariables.bDriver.findElement(NgByModel.model(DataFromDB.Locator(locValue)+rowIndex));
			case "ng-bind":
				NgWebDriver ngBind = new NgWebDriver((JavascriptExecutor) PubVariables.bDriver).withRootSelector(PubVariables.rootSelector);
				ByAngular.Factory NgByBind = ngBind.makeByAngularFactory();
				return PubVariables.bDriver.findElement(NgByBind.binding(DataFromDB.Locator(locValue)+rowIndex));
			case "buttontext":
				NgWebDriver btnText = new NgWebDriver((JavascriptExecutor) PubVariables.bDriver).withRootSelector(PubVariables.rootSelector);
				ByAngular.Factory NgBybtnText = btnText.makeByAngularFactory();
				return PubVariables.bDriver.findElement(NgBybtnText.buttonText(DataFromDB.Locator(locValue)+rowIndex));
			case "partialbuttontext":
				NgWebDriver parBtnText = new NgWebDriver((JavascriptExecutor) PubVariables.bDriver).withRootSelector(PubVariables.rootSelector);
				ByAngular.Factory NgByparBtnTxt = parBtnText.makeByAngularFactory();
				return PubVariables.bDriver.findElement(NgByparBtnTxt.partialButtonText(DataFromDB.Locator(locValue)+rowIndex));
		}
		}catch(Throwable ex) {
			ExpHandler.Handle(ex, PubVariables.bDriver);
			ex.printStackTrace();
		}
		return null;
	}
}