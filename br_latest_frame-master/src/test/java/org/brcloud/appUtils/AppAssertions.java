package org.brcloud.appUtils;

import static org.testng.Assert.assertEquals;
import org.brcloud.utils.Constants;
import org.brcloud.utils.ExpHandler;
import org.brcloud.utils.GetElement;
import org.brcloud.utils.Keywords;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class AppAssertions {
	public static void Equals(String locValue, String value) throws Throwable { 
		WebElement getEle = null; 
		try {
			getEle = GetElement.Get(locValue);
			assertEquals(getEle.getAttribute("value"), value); 
		} catch (Throwable ex) {
			ExpHandler.Handle(ex, Constants.bDriver);
			ex.printStackTrace(); 
		} 
	}
	
	public static boolean TextAvailable(String getText) throws Throwable {
		boolean ind = false;
		try {
			ind = Constants.bDriver.getPageSource().contains(getText);
		}catch(Throwable ex) {
			ExpHandler.Handle(ex, Constants.bDriver);
			ex.printStackTrace();
		}
		return ind;
	}
	
	public static void VerifyBWG() throws Throwable {
		for (String workGroupName:BusinessLayer.searchBWGroup) {
			//Navigate to Security --> Groups
			Constants.bDriver.switchTo().parentFrame();
			MenuNavigation.MenuSubMenu("lblSecurity", "mnuBusinessWorkGroup");
			
			Constants.bDriver.switchTo().frame("MainFrame");
			Keywords.SendKeys("txtQuickSearch", workGroupName);
			Keywords.Click("btnQuickSearch");
			
			//Validate created group link is displaying in the table
			assertEquals(Constants.bDriver.findElement(By.linkText(workGroupName)).getText(), workGroupName);
		}
	}
	
	public static void VerifyEntGroup() throws Throwable {
		for (String groupName:BusinessLayer.searchEntGroup) {
			//Navigate to Security --> Groups
			Constants.bDriver.switchTo().parentFrame();
			MenuNavigation.MenuSubMenu("lblSecurity", "lblGroups");
			
			Constants.bDriver.switchTo().frame("MainFrame");
			Keywords.SendKeys("txtQuickSearch", groupName);
			Keywords.Click("btnQuickSearch");
			
			//Validate created group link is displaying in the table
			assertEquals(Constants.bDriver.findElement(By.linkText(groupName)).getText(), groupName);
		}
	}
	
	public static void VerifyStaticList() throws Throwable {
		//Navigate to Security --> Groups
		Constants.bDriver.switchTo().parentFrame();
		MenuNavigation.MenuSubSubMenu("lblSystem", "lblStaticData", "lblStaticList");
		Constants.bDriver.switchTo().frame("MainFrame");
		
		for (String staticList:BusinessLayer.searchStaticList) {
			//Split text in searchStaticList
			String [] arrOfStr = staticList.split(":"); 
			
			Keywords.SelectFromList("lstSelectGroupType", arrOfStr[0]);		
			boolean ind = Constants.bDriver.getPageSource().contains(arrOfStr[1]);
			Assert.assertTrue(ind);
		}
	}
	
	public static void VerifyPageTitle(WebDriver driver, String expTitle) throws Throwable {
		try {
			Constants.actTitle = driver.getTitle();
			assertEquals(Constants.actTitle, expTitle);
		}catch (Throwable ex) {
			ExpHandler.Handle(ex, driver);
			ex.printStackTrace();
		}
	}
	
	public static void VerifyCalendar() throws Throwable {
		for (String calendar:BusinessLayer.searchCalendar) {
			Keywords.SendKeys("txtQuickSearch", calendar);
			Keywords.Click("btnQuickSearch");
			
			//Validate created group link is displaying in the table
			assertEquals(Constants.bDriver.findElement(By.linkText(calendar)).getText(), calendar);
		}
	}
	
	public static void VerifyUser() throws Throwable{
		for (String user:BusinessLayer.searchUser) {
			//Split text in searchStaticList
			String [] arrOfStr = user.split(":"); 
			
			Keywords.SendKeys("txtQuickSearch", arrOfStr[0]);
			Keywords.Click("btnQuickSearch");
		
			assertEquals(Constants.bDriver.findElement(By.linkText(arrOfStr[1])).getText(), arrOfStr[1]);
		}
	}
	
	public static void VerifyWorkflowGroup() throws Throwable {
		for (String workFlowGroup:BusinessLayer.searchWorkflowGroup) {
			
			Keywords.SendKeys("txtQuickSearch", workFlowGroup);
			Keywords.Click("btnSearchWorkFlowGroup");
		
			assertEquals(Constants.bDriver.findElement(By.linkText(workFlowGroup)).getText(), workFlowGroup);
		}
	}
	
	public static void VerifySetupWorkflow() throws Throwable {
		for (String setupWorkFlow:BusinessLayer.searchSetupWorkflow) {		
			boolean ind = Constants.bDriver.getPageSource().contains(setupWorkFlow);
			Assert.assertTrue(ind);
		}
	}
	
	public static void VerifyWorkflowNarrative() throws Throwable {
		for (String nameNarrative:BusinessLayer.searchWorkflowNarrativeName) {
			
			Keywords.SendKeys("txtQuickSearch", nameNarrative);
			Keywords.Click("btnQuikSearch");
		
			assertEquals(Constants.bDriver.findElement(By.linkText(nameNarrative)).getText(), nameNarrative);
		}
	}
	
	public static void VerifyGeneralLedgerType() throws Throwable {
		for (String generaLedger:BusinessLayer.searchGeneralLedgerType) {
			
			Keywords.SendKeys("txtQuickSearch", generaLedger);
			Keywords.Click("btnQuikSearch");
		
			assertEquals(Constants.bDriver.findElement(By.linkText(generaLedger)).getText(), generaLedger);
		}
	}
	
	public static void VerifyFeeType() throws Throwable {
		for (String feeType:BusinessLayer.searchFeeType) {
			
			Keywords.SendKeys("txtQuickSearch", feeType);
			Keywords.Click("btnSearch");
		
			assertEquals(Constants.bDriver.findElement(By.linkText(feeType)).getText(), feeType);
		}
	}
	
	public static void VerifyHolidayCalendar() throws Throwable {
		for (String holCalendar:BusinessLayer.searchHolidayCalendar) {
			
			Keywords.SendKeys("txtQuickSearch", holCalendar);
			Keywords.Click("btnSearch");
		
			assertEquals(Constants.bDriver.findElement(By.linkText(holCalendar)).getText(), holCalendar);
		}
	}
	
	public static void VerifyHierarchyContact() throws Throwable {
		for (String contact:BusinessLayer.searchHierarchyContact) {
			
			Keywords.SendKeys("txtQuickSearch", contact);
			Keywords.Click("btnQuickSearch");
		
			assertEquals(Constants.bDriver.findElement(By.linkText(contact)).getText(), contact);
		}
	}
	
	public static void VerifyHierarchyClient() throws Throwable {
		for (String client:BusinessLayer.searchHierarchyClient) {
			
			Keywords.SendKeys("txtQuickSearch", client);
			Keywords.Click("btnQuickSearch");
		
			assertEquals(Constants.bDriver.findElement(By.linkText(client)).getText(), client);
		}
	}
	
	public static void VerifyHierarchyRemitClient() throws Throwable {
		for (String remitClient:BusinessLayer.searchHierarchyRemitClient) {
			
			Keywords.SendKeys("txtQuickSearch", remitClient);
			Keywords.Click("btnQuickSearch");
		
			assertEquals(Constants.bDriver.findElement(By.linkText(remitClient)).getText(), remitClient);
		}
	}
	
	public static void VerifyPortfolio() throws Throwable {
		for (String portfolio:BusinessLayer.searchPortfolioID) {
			
			Keywords.SendKeys("txtQuickSearch", portfolio);
			Keywords.Click("btnQuickSearch");
		
			assertEquals(Constants.bDriver.findElement(By.linkText(portfolio)).getText(), portfolio);
		}
	}
	
	public static void VerifyMarketValue() throws Throwable {
		for (String account:BusinessLayer.searchAccountID) {
			Keywords.SendKeys("txtQuickSearch2", account);
			Keywords.Click("btnQuickSearch");
			for (String localamt:BusinessLayer.searchLocalAmount) {
				//assertEquals(Constants.bDriver.findElement(By.linkText(localamt)).getText(), localamt);
				assertEquals(TextAvailable(localamt),localamt);
			}
		}
	}
	
	public static void VerifyFeeSchedule() throws Throwable {
		for (String feeSchedule:BusinessLayer.searchFeeSchedule) {
			
			Keywords.SendKeys("txtQuickSearch", feeSchedule);
			Keywords.Click("btnQuickSearch");
		
			assertEquals(Constants.bDriver.findElement(By.linkText(feeSchedule)).getText(), feeSchedule);
		}
	}
	
	public static void VerifyCalcRules() throws Throwable {
		for (String ruleName:BusinessLayer.searchCalcRules) {
			
			Keywords.SendKeys("txtQuickSearch", ruleName);
			Keywords.Click("btnQuickSearch");
		
			assertEquals(Constants.bDriver.findElement(By.linkText(ruleName)).getText(), ruleName);
		}
	}
	
	public static void VerifyCalculationGroup() throws Throwable {
		for (String groupName:BusinessLayer.searchCalculationGroup) {
			
			Keywords.SendKeys("txtQuickSearch", groupName);
			Keywords.Click("btnQuickSearch");
		
			assertEquals(Constants.bDriver.findElement(By.linkText(groupName)).getText(), groupName);
		}
	}
	
	public static void VerifyCalculationRecord() throws Throwable {
		for (String calcRecord:BusinessLayer.searchCalculationRecord) {
			Constants.bDriver.switchTo().frame("Mainframe");
			Keywords.SendKeys("txtQuickSearch", "ST Calculation Record 231011");
			Keywords.Click("btnQuickSearch");
			
			if(Constants.bDriver.findElements(By.linkText(calcRecord)).size()!=0){	    	  
				System.out.println("Calculation record present");
			} else {
				System.out.println("Calculation record not available");
			}
			
			WebElement webLink = Constants.bDriver.findElement(By.linkText(calcRecord));
			JavascriptExecutor jsExecute = (JavascriptExecutor)Constants.bDriver;
			jsExecute.executeScript("arguments[0].click();", webLink);
		}
	}
}