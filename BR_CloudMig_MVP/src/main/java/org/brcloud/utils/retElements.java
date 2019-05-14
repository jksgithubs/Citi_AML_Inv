package org.brcloud.utils;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.paulhammant.ngwebdriver.ByAngular;
import com.paulhammant.ngwebdriver.NgWebDriver;
import org.brcloud.utils.*;

@SuppressWarnings("unused")
public class retElements {
	public static WebElement getElement(String locator, String locValue, WebDriver driver) throws Throwable{		
		switch(locator.toLowerCase()){
			case "id":
				return fluWaits.getClickableElement(By.id(getLocators.retLocatorValue(locValue)), driver);
			case "name":
				return fluWaits.getClickableElement(By.name(getLocators.retLocatorValue(locValue)), driver);
			case "classname":
				return fluWaits.getClickableElement(By.className(getLocators.retLocatorValue(locValue)), driver);
			case "linktext":
				return fluWaits.getClickableElement(By.linkText(getLocators.retLocatorValue(locValue)), driver);
			case "partiallinktext":
				return fluWaits.getClickableElement(By.partialLinkText(getLocators.retLocatorValue(locValue)), driver);
			case "xpath":
				return fluWaits.getClickableElement(By.xpath(getLocators.retLocatorValue(locValue)), driver);
			case "tagname":
				return fluWaits.getClickableElement(By.tagName(getLocators.retLocatorValue(locValue)), driver);
			case "cssselector":
				return fluWaits.getClickableElement(By.cssSelector(getLocators.retLocatorValue(locValue)), driver);
			case "ng-model": 
				NgWebDriver ngModel = new NgWebDriver((JavascriptExecutor) pubConstants.bDriver).withRootSelector(pubConstants.rootSelector);
				ByAngular.Factory NgByModel = ngModel.makeByAngularFactory();
				return pubConstants.bDriver.findElement(NgByModel.model(getLocators.retLocatorValue(locValue)));
			case "ng-bind":
				NgWebDriver ngBind = new NgWebDriver((JavascriptExecutor) pubConstants.bDriver).withRootSelector(pubConstants.rootSelector);
				ByAngular.Factory NgByBind = ngBind.makeByAngularFactory();
				return pubConstants.bDriver.findElement(NgByBind.binding(locValue));
			case "buttontext":
				NgWebDriver btnText = new NgWebDriver((JavascriptExecutor) pubConstants.bDriver).withRootSelector(pubConstants.rootSelector);
				ByAngular.Factory NgBybtnText = btnText.makeByAngularFactory();
				return pubConstants.bDriver.findElement(NgBybtnText.binding(locValue));
			case "partialbuttontext":
				NgWebDriver parBtnText = new NgWebDriver((JavascriptExecutor) pubConstants.bDriver).withRootSelector(pubConstants.rootSelector);
				ByAngular.Factory NgByparBtnTxt = parBtnText.makeByAngularFactory();
				return pubConstants.bDriver.findElement(NgByparBtnTxt.binding(locValue));
		}
		return null;
	}
	
	public static List<WebElement> getElements(String by, String path, WebDriver driver){
		switch(by.toLowerCase()){
			case "id" 					: return driver.findElements(By.id(path));
			case "name" 				: return driver.findElements(By.name(path));
			case "classname" 			: return driver.findElements(By.className(path));
			case "linktext" 			: return driver.findElements(By.linkText(path));
			case "partiallinktext"  	: return driver.findElements(By.partialLinkText(path));
			case "xpath" 				: return driver.findElements(By.xpath(path));
			case "tagname" 				: return driver.findElements(By.tagName(path));
			case "cssselector"  		: return driver.findElements(By.cssSelector(path));
			case "ng-model"				: return driver.findElements(ByAngular.model(path));
			case "ng-bind"				: return driver.findElements(ByAngular.binding(path));
			case "buttontext"			: return driver.findElements(ByAngular.buttonText(path));
			case "partialbuttontext"	: return driver.findElements(ByAngular.partialButtonText(path));
		}
		return null;
	}
}