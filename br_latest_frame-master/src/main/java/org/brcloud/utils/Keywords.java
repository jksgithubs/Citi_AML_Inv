package org.brcloud.utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import org.openqa.selenium.Keys;

public class Keywords {
	public static void SendKeys(String locValue, String value) throws Throwable {
		WebElement webEle = null;
		try {
			webEle = GetElement.Get(locValue);
			webEle.clear();
			webEle.sendKeys(value);
		} catch (Throwable ex) {
			ExpHandler.Handle(ex, Constants.bDriver);
			ex.printStackTrace();
		}
	}
	
	public static void KeyPress(String locValue, Keys keys) throws Throwable {
		WebElement webEle = null;
		try {
			webEle = GetElement.Get(locValue);
			webEle.sendKeys(keys);
		} catch (Throwable ex) {
			ExpHandler.Handle(ex, Constants.bDriver);
			ex.printStackTrace();
		}
	}
	
	public static void Click(String locValue) throws Throwable {
		WebElement webEle = null;
		try {
			webEle = GetElement.Get(locValue);
			webEle.click();
		} catch (Throwable ex) {
			ExpHandler.Handle(ex, Constants.bDriver);
			ex.printStackTrace();
		}
	}
	
	public static void Clicks(String locValue, int index) throws Throwable {
		List <WebElement>  webEle = null;
		try {
			webEle = GetElement.Gets(locValue);
			webEle.get(index).click();
		} catch (Throwable ex) {
			ExpHandler.Handle(ex, Constants.bDriver);
			ex.printStackTrace();
		}
	}
	
	public static void Check(String locValue) throws Throwable {
		Thread.sleep(Long.parseLong(DataFromDB.Properties("hardWait")));
		WebElement webEle = null;
		try {
			webEle = GetElement.Get(locValue);
			if(!webEle.isSelected()) {
				webEle.click();
			}
		} catch (Throwable ex) {
			ExpHandler.Handle(ex, Constants.bDriver);
			ex.printStackTrace();
		}
	}
	
	public static void MoveToElement(String locValue) throws Throwable {
		WebElement webEle = null;
		Actions act = new Actions(Constants.bDriver);
		try {
			webEle = GetElement.Get(locValue);
			act.moveToElement(webEle).build().perform();
		} catch (Throwable ex) {
			ExpHandler.Handle(ex, Constants.bDriver);
			ex.printStackTrace();
		}
	}
	
	public static void SelectFromList(String locValue, String value) throws Throwable {
		WebElement webEle = null;
		try {
			webEle = GetElement.Get(locValue);
			Select lstSelect = new Select(webEle);
			lstSelect.selectByVisibleText(value);
			
		} catch (Throwable ex) {
			ExpHandler.Handle(ex, Constants.bDriver);
			ex.printStackTrace();
		}
	}
	
	public static void SelectRadioButton(String locValue, int index) throws Throwable {
		try {
			List<WebElement> rdoButton = GetElement.Gets(locValue);	
			if(!rdoButton.get(index).isSelected()) {
				rdoButton.get(index).click();
			}
		} catch (Throwable ex) {
			ExpHandler.Handle(ex, Constants.bDriver);
			ex.printStackTrace();
		}
	}
}