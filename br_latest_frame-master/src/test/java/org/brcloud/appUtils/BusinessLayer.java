package org.brcloud.appUtils;

import java.sql.ResultSet;
import java.util.*;
import org.brcloud.utils.Constants;
import org.brcloud.utils.CurrDateTime;
import org.brcloud.utils.DataFromDB;
import org.brcloud.utils.GetElement;
import org.brcloud.utils.Keywords;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BusinessLayer {
	public static ArrayList<String> searchEntGroup = new ArrayList<String>();
	public static ArrayList<String> searchBWGroup = new ArrayList<String>();
	public static ArrayList<String> searchStaticList = new ArrayList<String>();
	public static ArrayList<String> searchCalendar = new ArrayList<String>();
	public static ArrayList<String> searchUser = new ArrayList<String>();
	public static ArrayList<String> searchWorkflowGroup = new ArrayList<String>();
	public static ArrayList<String> searchSetupWorkflow = new ArrayList<String>();
	public static ArrayList<String> searchWorkflowNarrativeName = new ArrayList<String>();
	public static ArrayList<String> searchGeneralLedgerType = new ArrayList<String>();
	public static ArrayList<String> searchFeeType = new ArrayList<String>();
	public static ArrayList<String> searchHolidayCalendar = new ArrayList<String>();
	public static ArrayList<String> searchHierarchyContact = new ArrayList<String>();
	public static ArrayList<String> searchHierarchyClient = new ArrayList<String>();
	public static ArrayList<String> searchHierarchyRemitClient = new ArrayList<String>();
	public static ArrayList<String> searchPortfolioID = new ArrayList<String>();
	public static ArrayList<String> searchAccountID = new ArrayList<String>();
	public static ArrayList<String> searchLocalAmount = new ArrayList<String>();
	public static ArrayList<String> searchFeeSchedule = new ArrayList<String>();
	public static ArrayList<String> searchCalcRules = new ArrayList<String>();
	public static ArrayList<String> searchCalculationGroup = new ArrayList<String>();
	public static ArrayList<String> searchCalculationRecord = new ArrayList<String>();
	
	public static int chkInd = 0;
	public static int rndm;
	
	public static void CopyEntGroup() throws Throwable {		
		//get TestData to copy entitlement group
		ResultSet getData = DataFromDB.TestData(DataFromDB.SQL("copyEntGroup"));
		
		//copy and create entitlement group
		while (getData.next()) {
			//Navigate to Security --> Groups
			MenuNavigation.MenuSubMenu("lblSecurity", "lblGroups");
			
			//Switch to Mainframe iFrame
			Constants.bDriver.switchTo().frame("MainFrame");
		
			//Search for a existing Group		
			Keywords.SendKeys("txtQuickSearch", getData.getString(1));
			Keywords.Click("btnQuickSearch");
			
			//Check if Group name is available post search, if not available, fail the scenario
			ErrorHandler.DataExisting(getData.getString(1), "No matching values were found.");
			
			//Click on Admin_Global displaying in the table and copy
			Constants.bDriver.findElement(By.linkText(getData.getString(1))).click();
			Keywords.Click("btnCopyCreate");
			
			//Enter Group Name and Description
			String appndStr = CurrDateTime.GetDateTime();
			Keywords.SendKeys("txtGroupName", getData.getString(2)+" "+appndStr);
			Keywords.SendKeys("txtGroupNameDescription", getData.getString(3));
			searchEntGroup.add(getData.getString(2)+" "+appndStr); //pass to array in order to search later	
			
			//Save the created group
			Keywords.Click("btnSave");
			
			//Check if Group name already exist, if yes, fail the scenario
			ErrorHandler.DataExisting(getData.getString(2), "An Entitlement Group already exists with this name!");
			
			//Switch back to parent frame
			Constants.bDriver.switchTo().parentFrame();
		}
		getData.close();
	}
	
	public static void CreateBWG() throws Throwable {
		//get TestData to copy entitlement group
		ResultSet getData = DataFromDB.TestData(DataFromDB.SQL("newBWG"));
		
		//copy and create entitlement group
		while (getData.next()) {
			//Navigate to Security --> Business Work Groups
			MenuNavigation.MenuSubMenu("lblSecurity", "mnuBusinessWorkGroup");
			
			//Switch to Mainframe iFrame
			Constants.bDriver.switchTo().frame("MainFrame");
			
			//Click Create New Business Work Group button
			Keywords.Click("btnAddNew");
			
			//Fill Header section
			String appndStr = CurrDateTime.GetDateTime();
			Keywords.SendKeys("txtName", getData.getString(1)+" "+appndStr);
			Keywords.SendKeys("txtStartDate", getData.getString(2));
			Keywords.SendKeys("txtDescription", getData.getString(3));
			Keywords.Click("hdrHeader");
			searchBWGroup.add(getData.getString(1)+" "+appndStr); //pass to array in order to search later
					
			//Fill Calculation options section
			Keywords.Click("hdrCalculationOptions");
			Keywords.SelectFromList("lstExRateSource", getData.getString(4));
			Keywords.SelectFromList("lstAccuralSource", getData.getString(5));
			Keywords.SelectFromList("lstBaseCurrency", getData.getString(6));
			Keywords.SelectFromList("lstAccuralExRateSource", getData.getString(7));
			Keywords.SelectFromList("lstAfbFunction", getData.getString(8));
			Keywords.Click("hdrCalculationOptions");
			
			//Fill Workflow section
			Keywords.Click("hdrWorkflow");
			if (getData.getString(9).contentEquals("Check")) {
				Keywords.Check("chkDisableChangeStatusCheck");
			}
			Keywords.Click("hdrWorkflow");
			
			//Fill File Locations section
			Keywords.Click("hdrFileLocations");
			Keywords.SendKeys("txtInvoicePath", getData.getString(10));
			Keywords.SendKeys("txtReportPath", getData.getString(11));
			Keywords.SendKeys("txtFileLoadPath", getData.getString(12));
			Keywords.SendKeys("txtResourcePath", getData.getString(13));
			
			//Click on save to create new Business work group
			Keywords.Click("btnSave");
			
			//Check if Business Work Group already exist, if yes, fail the scenario
			ErrorHandler.DataExisting(getData.getString(1), "A Business Work Group already exists with this name!");

			//Switch back to parent frame
			Constants.bDriver.switchTo().parentFrame();
		}
		getData.close();
	}
	
	public static void CreateStaticList() throws Throwable {
		ResultSet getTestData = DataFromDB.TestData(DataFromDB.SQL("newStaticList"));
		Constants.bDriver.switchTo().frame("Mainframe");
		
		while (getTestData.next()) {
			Keywords.SelectFromList("lstSelectGroupType", getTestData.getString(1));
			
			Keywords.Click("btnEditStaticList");
			Keywords.Click("btnAddRow");
			
	        int rowSize = GetTableRowCount("tblPickList");
	        rowSize = rowSize-5;
	        
	        String apndStr = CurrDateTime.GetDateTime();
	        Constants.bDriver.findElement(By.name(DataFromDB.Locator("txtStaticListValue")+rowSize)).sendKeys(getTestData.getString(2)+" "+apndStr);
	        Constants.bDriver.findElement(By.name(DataFromDB.Locator("txtStaticListDesc")+rowSize)).sendKeys(getTestData.getString(3));
	        Constants.bDriver.findElement(By.name(DataFromDB.Locator("txtStaticListType")+rowSize)).sendKeys(getTestData.getString(4));
	        searchStaticList.add(getTestData.getString(1)+":"+getTestData.getString(2)+" "+apndStr); //pass to array in order to search later
	        
	        int sortOrdr = GetSortOrder();
	        
	        Constants.bDriver.findElement(By.name(DataFromDB.Locator("txtStaticListSortOrder")+rowSize)).sendKeys(String.valueOf(sortOrdr));
	        Keywords.Click("btnSave");
	        //System.out.println("searListArray: "+searchStaticList);
		}
	}
	
	public static int GetTableRowCount(String getLoc) throws Throwable {
		List <WebElement> rows = GetElement.Gets(getLoc);
		System.out.println("Total Rows: "+rows.size());
		return rows.size();
	}
	
	public static int GetSortOrder() throws Throwable {
		int min = 1;
		int max = 99999;
		boolean eqCheck = false;
				
		int row = GetTableRowCount("tblPickList");
		
		while (eqCheck == false) {
			chkInd = 0;
			Random random = new Random();
		    rndm = random.ints(min,(max+1)).findFirst().getAsInt();

			for(int j=1; j<row; j++) {
		    	int inSortOrder = Integer.parseInt(Constants.bDriver.findElement(By.name("SortOrder"+j)).getAttribute("value"));
		    	if (rndm == inSortOrder) {
			    	chkInd = 1;
			    	break;
			    }
			}
		    if (chkInd==0) {
		    	eqCheck = true;
		    }
		}
		return rndm;
	}
	
	public static void CreateCalendar() throws Throwable {
		ResultSet getTestData = DataFromDB.TestData(DataFromDB.SQL("createCalendar"));
		Constants.bDriver.switchTo().frame("Mainframe");
		
		while (getTestData.next()) {
			Keywords.Click("btnAddNew");
			
			String apndStr = CurrDateTime.GetDateTime();
			Keywords.SendKeys("txtCalendarName", getTestData.getString(1)+" "+apndStr);
			searchCalendar.add(getTestData.getString(1)+" "+apndStr);
			Keywords.SendKeys("txtCalendarDesc", getTestData.getString(2));
			Keywords.SelectFromList("lstCalendarType", getTestData.getString(3));
			Keywords.SelectFromList("lstFrequency", getTestData.getString(4));
			Keywords.SelectFromList("lstOpenAccountProcessing", getTestData.getString(5));
			Keywords.SelectFromList("lstClosedAccountProcessing", getTestData.getString(6));
			Keywords.SelectFromList("lstHolidayCalendar", DataFromDB.DataReuse("holCalendar"));
			
			Keywords.Check("chkBusinessDaysMon");
			Keywords.Check("chkBusinessDaysTue");
			Keywords.Check("chkBusinessDaysWed");
			Keywords.Check("chkBusinessDaysThu");
			Keywords.Check("chkBusinessDaysFri");
			
			Keywords.Click("btnSave");
			Keywords.Click("btnCancelEdit");
		}
	}
	
	public static void CreateUser() throws Throwable {
		ResultSet getTestData = DataFromDB.TestData(DataFromDB.SQL("createUsers"));
		Constants.bDriver.switchTo().frame("Mainframe");
		
		while (getTestData.next()) {
			Keywords.Click("btnAddNew");
			String apndStr = CurrDateTime.GetDateTime();
			Keywords.SendKeys("txtUserId", getTestData.getString(1)+apndStr);
			Keywords.SendKeys("txtFirstName", getTestData.getString(2));
			Keywords.SendKeys("txtLastName", getTestData.getString(3)+apndStr);
			Keywords.SendKeys("txtPassword", getTestData.getString(4));
			Keywords.SendKeys("txtReEnterPassword", getTestData.getString(4));
			Keywords.SelectFromList("lstDefaultService", getTestData.getString(5));
			searchUser.add(getTestData.getString(1)+apndStr+":"+getTestData.getString(3)+apndStr+", "+getTestData.getString(2)); //pass to array in order to search later
			DataFromDB.UpdateDataReuse("User", getTestData.getString(2)+" "+getTestData.getString(3)+apndStr);
			
			Keywords.SelectFromList("lstAvailableEntitlementGroups", DataFromDB.DataReuse("EntitlementGroupGlobal"));
			Keywords.KeyPress("lstAvailableEntitlementGroups", Keys.CONTROL);
			Keywords.SelectFromList("lstAvailableEntitlementGroups", DataFromDB.DataReuse("EntitlementGroupRevenue"));
			Keywords.Click("btnAddGroups");
			
			Keywords.Click("tabCorporate");
			Keywords.SelectFromList("lstLevel", "Business Work Group");
			Keywords.SelectFromList("lstAvailableEntitlementGroups", DataFromDB.DataReuse("BusinessWorkGroup"));
			Keywords.Click("btnAddGroups");
			Keywords.Click("btnSave");
			Keywords.Click("btnCancelEdit");
		}
	}
	
	public static void CreateWorkFlowGroup () throws Throwable {
		ResultSet getTestData = DataFromDB.TestData(DataFromDB.SQL("createWorkFlowGroup"));
		Constants.bDriver.switchTo().frame("Mainframe");
		int count = 1;
		
		while (getTestData.next()) {
			String apndStr = CurrDateTime.GetDateTime();
			Keywords.Click("btnAddNew");
			Keywords.SelectFromList("lstWorkFlowType", getTestData.getString(1));
			Keywords.SelectFromList("lstBusinessWorkGroup", DataFromDB.DataReuse("BusinessWorkGroup"));
			Keywords.SendKeys("txtWorkFlowGroupName", getTestData.getString(2)+" "+apndStr);
			searchWorkflowGroup.add(getTestData.getString(2)+" "+apndStr); //pass to array in order to search later
			
			if (count == 1) {
				Keywords.SelectFromList("lstAvailableUsers", DataFromDB.DataReuse("User"));
				DataFromDB.UpdateDataReuse("Approver", getTestData.getString(2)+" "+apndStr);
			} else {
				Keywords.SelectFromList("lstAvailableUsers", "Super User");
				DataFromDB.UpdateDataReuse("Biller", getTestData.getString(2)+" "+apndStr);
			}
			
			Keywords.Click("btnAddGroups");
			Keywords.Click("btnSave");
			Keywords.Click("btnCancelEdit");
			count++;
		}	
	}
	
	public static void SetupWorkFlow() throws Throwable {
		Constants.bDriver.switchTo().frame("Mainframe");
		Keywords.SelectFromList("lstBWGWorkFlow", DataFromDB.DataReuse("BusinessWorkGroup"));
		Keywords.SelectFromList("lstBWGWorkFlowType", "Billing & Recon");
		Keywords.Click("btnBWGSearch");
		Keywords.Click("btnEditWorkFlow");
		
		ResultSet getTestData = DataFromDB.TestData(DataFromDB.SQL("setupWorkflow"));
	
		while (getTestData.next()) {
			Keywords.Click("btnWorkFlowAddRow");

			int rowSize = GetTableRowCount("tblWorkFlowTable");
			rowSize = rowSize-3;
			
			Constants.bDriver.findElement(By.name(DataFromDB.Locator("txtWorkFlowStatus")+rowSize)).sendKeys(getTestData.getString(1));
			Constants.bDriver.findElement(By.id(DataFromDB.Locator(getTestData.getString(2))+rowSize)).click();
			Constants.bDriver.findElement(By.name(DataFromDB.Locator("txtWorkFlowOrder")+rowSize)).sendKeys(getTestData.getString(3));
			searchSetupWorkflow.add(getTestData.getString(1));
		}
			
		Keywords.Click("btnSave");
	}
	
	public static void CreateWorkflowNarrative() throws Throwable{
		Constants.bDriver.switchTo().frame("Mainframe");
		String apndStr = CurrDateTime.GetDateTime();

		ResultSet getTestData = DataFromDB.TestData(DataFromDB.SQL("workflowNarrative"));
		
		while (getTestData.next()) {
			Keywords.Click("btnAddNew");
			Keywords.SelectFromList("lstNarrativeBWG", DataFromDB.DataReuse("BusinessWorkGroup"));
			Keywords.SendKeys("txtWorflowNarrativeName", getTestData.getString(1)+" "+apndStr);
			searchWorkflowNarrativeName.add(getTestData.getString(1)+" "+apndStr);
			Keywords.SelectFromList("lstNarrativeBWGType", getTestData.getString(2));
			Keywords.SelectFromList("lstApplyWorkflowStatusTo", getTestData.getString(3));
			Keywords.SelectFromList("lstOverrideWorlflowGroup", DataFromDB.DataReuse("Approver"));
			Keywords.Click("btnNarrativeAddRule");
			
			int rowSize = GetTableRowCount("tblAssignedRules");
			
			Select lstManualWorkflow = new Select(Constants.bDriver.findElement(By.name(DataFromDB.Locator("lstRuleType")+rowSize)));
			lstManualWorkflow.selectByVisibleText(getTestData.getString(4));
			
			Constants.bDriver.findElement(By.name(DataFromDB.Locator("lstManualWorkflow")+rowSize)).sendKeys(DataFromDB.DataReuse("Biller"));
			Constants.bDriver.findElement(By.name(DataFromDB.Locator("txtSuccessStatus")+rowSize)).sendKeys(getTestData.getString(5));
			Constants.bDriver.findElement(By.name(DataFromDB.Locator("txtOnSuccessGoToStep")+rowSize)).sendKeys(getTestData.getString(6));
			Constants.bDriver.findElement(By.name(DataFromDB.Locator("txtStepNumber")+rowSize)).sendKeys(getTestData.getString(7));
			Constants.bDriver.findElement(By.name(DataFromDB.Locator("txtStepName")+rowSize)).sendKeys(getTestData.getString(8));
			
			rowSize++;
		}
		Keywords.Click("btnSave");
		Keywords.Click("btnCancelEdit");
	}
	
	public static void CreateGeneralLedgerType() throws Throwable {
		Constants.bDriver.switchTo().frame("Mainframe");
		String apndStr = CurrDateTime.GetDateTime();
		
		ResultSet getTestData = DataFromDB.TestData(DataFromDB.SQL("generalLedgerType"));
		
		
		while (getTestData.next()) {
			Keywords.Click("btnAddNew");
			
			Keywords.SelectFromList("lstGeneralLedgerBusinessWorkGroup", getTestData.getString(1));
			Keywords.SelectFromList("lstGeneralLedgerLevel", getTestData.getString(2));
			Keywords.SendKeys("txtGeneralLedgerType", getTestData.getString(3)+" "+apndStr);
			searchGeneralLedgerType.add(getTestData.getString(3)+" "+apndStr);
			Keywords.SendKeys("txtGeneralLedgerTypeDesc", getTestData.getString(4));
			Keywords.SelectFromList("lstGeneralLedgerAccType", getTestData.getString(5));
			
			if (getTestData.getString(3).equals("ST - Base Fee")) {
				DataFromDB.UpdateDataReuse("feeBaseFee", getTestData.getString(3)+" "+apndStr);
			} else if (getTestData.getString(3).equals("ST - AR Billed Base Fee")) {
				DataFromDB.UpdateDataReuse("feeArBilledBaseFee", getTestData.getString(3)+" "+apndStr);
			} else if (getTestData.getString(3).equals("ST - Cash")) {
				DataFromDB.UpdateDataReuse("feeCash", getTestData.getString(3)+" "+apndStr);
			} else if (getTestData.getString(3).equals("ST - AR Unbilled Base Fee")) {
				DataFromDB.UpdateDataReuse("feeArUnbilledBaseFee", getTestData.getString(3)+" "+apndStr);
			} else if (getTestData.getString(3).equals("ST - Chart field")) {
				DataFromDB.UpdateDataReuse("feeChartField", getTestData.getString(3)+" "+apndStr);
			}
			
			Keywords.Click("btnGeneralLedgerAddRow");
						
			int rowSize = GetTableRowCount("tblGeneralLedgerPickList");
			rowSize = rowSize-5;
			System.out.println("Row Size: "+rowSize);
			
			Constants.bDriver.findElement(By.name(DataFromDB.Locator("txtGeneralLedgerPickList")+rowSize)).sendKeys(getTestData.getString(6));
			Constants.bDriver.findElement(By.name(DataFromDB.Locator("txtGeneralLedgerSOrtOrder")+rowSize)).sendKeys(getTestData.getString(7));
			
			//Constants.bDriver.findElement(By.xpath("//*[@id=\"formDiv\"]/table/tbody/tr[1]/td/form/table/tbody/tr/td/table/tbody/tr[4]/td/input[2]")).click();
			//Constants.bDriver.switchTo().alert().accept();
			
			Keywords.Click("btnSave");
			Keywords.Click("btnCancelEdit");
		}
	}
	
	public static void CreateFeeType () throws Throwable {
		Constants.bDriver.switchTo().frame("Mainframe");
		String apndStr = CurrDateTime.GetDateTime();
		Keywords.SelectFromList("lstUsageMode", "Revenue");
		Keywords.Click("btnAddNew");
		Keywords.SelectFromList("lstFeeTypeBusinessWorkGroup", "Global");
		Keywords.SendKeys("txtFeeTypeName", "ST - Base Fee"+" "+apndStr);
		searchFeeType.add("ST - Base Fee"+" "+apndStr);
		Keywords.SendKeys("txtFeeTypeNameDesc", "Smoke Test Base Fee");
		Keywords.Check("chkAccuralsRequired");
		Keywords.SendKeys("txtProcessOrder", "100");
		
		ResultSet getTestData = DataFromDB.TestData(DataFromDB.SQL("feeType"));
		
		while (getTestData.next()) {
			Keywords.Click("btnAccountingEntryAddNew");
			
			int rowSize = GetTableRowCount("tblAccountingEntryDefinition");
			rowSize = rowSize-3;
			
			int rowSize2 = GetTableRowCount("tblAccountingEntryDefinition");
			System.out.println("Rwo two Size: "+rowSize2);
			
			if (getTestData.getString(4) != null) {
				System.out.println(getTestData.getString(4)+" :Not Empty");
				Constants.bDriver.findElement(By.name(DataFromDB.Locator("lstGLGroup")+rowSize)).sendKeys(getTestData.getString(1));
				
				if (getTestData.getString(2).equals("ST - Base Fee")) {
					Constants.bDriver.findElement(By.name(DataFromDB.Locator("lstGLType")+rowSize)).sendKeys(DataFromDB.DataReuse("feeBaseFee"));
				} else if (getTestData.getString(2).equals("ST - AR Billed Base Fee")) {
					Constants.bDriver.findElement(By.name(DataFromDB.Locator("lstGLType")+rowSize)).sendKeys(DataFromDB.DataReuse("feeArBilledBaseFee"));
				} else if (getTestData.getString(2).equals("ST - Cash")) {
					Constants.bDriver.findElement(By.name(DataFromDB.Locator("lstGLType")+rowSize)).sendKeys(DataFromDB.DataReuse("feeCash"));
				} else if (getTestData.getString(2).equals("ST - AR Unbilled Base Fee")) {
					Constants.bDriver.findElement(By.name(DataFromDB.Locator("lstGLType")+rowSize)).sendKeys(DataFromDB.DataReuse("feeArUnbilledBaseFee"));
				} else if (getTestData.getString(2).equals("ST - Chart field")) {
					Constants.bDriver.findElement(By.name(DataFromDB.Locator("lstGLType")+rowSize)).sendKeys(DataFromDB.DataReuse("feeChartField"));
				}
				
				Constants.bDriver.findElement(By.name(DataFromDB.Locator("lstPerAllocation")+rowSize)).sendKeys(getTestData.getString(3));
				List <WebElement>  webEle = Constants.bDriver.findElements(By.name("Add Row"));
				System.out.println("Add Row Size: "+webEle.size());
				
				Keywords.Clicks("btnAccountingEntryAddNew", 1);
				Constants.bDriver.findElement(By.name(DataFromDB.Locator("lstChartFiled")+rowSize)).sendKeys(getTestData.getString(4));
				
			} else {
				System.out.println(getTestData.getString(4)+" :Empty");
				Constants.bDriver.findElement(By.name(DataFromDB.Locator("lstGLGroup")+rowSize)).sendKeys(getTestData.getString(1));
				
				if (getTestData.getString(2).equals("ST - Base Fee")) {
					Constants.bDriver.findElement(By.name(DataFromDB.Locator("lstGLType")+rowSize)).sendKeys(DataFromDB.DataReuse("feeBaseFee"));
				} else if (getTestData.getString(2).equals("ST - AR Billed Base Fee")) {
					Constants.bDriver.findElement(By.name(DataFromDB.Locator("lstGLType")+rowSize)).sendKeys(DataFromDB.DataReuse("feeArBilledBaseFee"));
				} else if (getTestData.getString(2).equals("ST - Cash")) {
					Constants.bDriver.findElement(By.name(DataFromDB.Locator("lstGLType")+rowSize)).sendKeys(DataFromDB.DataReuse("feeCash"));
				} else if (getTestData.getString(2).equals("ST - AR Unbilled Base Fee")) {
					Constants.bDriver.findElement(By.name(DataFromDB.Locator("lstGLType")+rowSize)).sendKeys(DataFromDB.DataReuse("feeArUnbilledBaseFee"));
				} else if (getTestData.getString(2).equals("ST - Chart field")) {
					Constants.bDriver.findElement(By.name(DataFromDB.Locator("lstGLType")+rowSize)).sendKeys(DataFromDB.DataReuse("feeChartField"));
				}
				
				Constants.bDriver.findElement(By.name(DataFromDB.Locator("lstPerAllocation")+rowSize)).sendKeys(getTestData.getString(3));
			}
	
		}
		Keywords.Click("btnSave");
		Keywords.Click("btnSearch");
	}
	
	public static void CreateHolidayCalendar() throws Throwable {
		Constants.bDriver.switchTo().frame("Mainframe");
		Keywords.Click("btnAddNew");
		
		String apndStr = CurrDateTime.GetDateTime();
		Keywords.SendKeys("txtHolidayCalendarName", "ST No Holiday"+" "+apndStr);
		
		DataFromDB.UpdateDataReuse("holCalendar", "ST No Holiday"+" "+apndStr);
		searchHolidayCalendar.add("ST No Holiday"+" "+apndStr);
		
		Keywords.Click("btnSave");
		Keywords.Click("btnCancelEdit");
	}
	
	public static void CreateHierarchyContact() throws Throwable {
		ResultSet getTestData = DataFromDB.TestData(DataFromDB.SQL("hierarchyContact"));
		String apndStr = CurrDateTime.GetDateTime();
		
		Constants.bDriver.switchTo().frame("Mainframe");
		Keywords.Click("btnAddNew");
		
		while (getTestData.next()) {
			Keywords.SelectFromList("lstContactBusinessWorkGroup", getTestData.getString(1));
			Keywords.SendKeys("txtSalutation", getTestData.getString(2));
			Keywords.SendKeys("txtClientContactID", getTestData.getString(3)+apndStr);
			Keywords.SendKeys("txtContactFirstName", getTestData.getString(4));
			Keywords.SendKeys("txtContactLastName", getTestData.getString(5)+" "+apndStr);
			searchHierarchyContact.add(getTestData.getString(5)+" "+apndStr);
			Keywords.SendKeys("txtContactCompany", getTestData.getString(6));
			Keywords.SelectFromList("lstContactPhoneType", DataFromDB.DataReuse("PhoneType"));
			Keywords.SendKeys("txtContactPhoneNumber", getTestData.getString(7));
			Keywords.SendKeys("txtContactEmail", getTestData.getString(8));
			Keywords.SendKeys("lkpPhoneActiveDate", getTestData.getString(9));
			Keywords.SelectFromList("lstContactCountry", getTestData.getString(10));
			Keywords.SendKeys("txtAddressLineOne", getTestData.getString(11));
			Keywords.SendKeys("txtAddressLineTwo", getTestData.getString(12));
			Keywords.SendKeys("txtContactCity", getTestData.getString(13));
			Keywords.SendKeys("txtContactZipCode", getTestData.getString(14));
			Keywords.SendKeys("lkpAddressActiveDate", getTestData.getString(15));
			Keywords.SelectFromList("lstContactState", getTestData.getString(16));
		}
		Keywords.Click("btnSave");
		Keywords.Click("btnCancelEdit");
	}
	
	public static void CreateHierarchyClient () throws Throwable {
		ResultSet getTestData = DataFromDB.TestData(DataFromDB.SQL("hierarchyClient"));
		String apndStr = CurrDateTime.GetDateTime();
		
		Constants.bDriver.switchTo().frame("Mainframe");
		Keywords.Click("btnAddNew");
		
		while (getTestData.next()) {
			Keywords.SelectFromList("lstClientBusinessWorkGroup", getTestData.getString(1));
			Keywords.SendKeys("txtClientName", getTestData.getString(2)+" "+apndStr);
			searchHierarchyClient.add(getTestData.getString(2)+" "+apndStr);
			Keywords.SendKeys("txtClientID", apndStr);
			Keywords.SelectFromList("lstClientType", DataFromDB.DataReuse("ClientType"));
			Keywords.SendKeys("lkpInceptionDate", getTestData.getString(3));
			
			Keywords.Click("tabBankInformation");
			Keywords.SelectFromList("lstClientBankName", DataFromDB.DataReuse("BankName"));
		}
	}
	
	public static void CreateHierarchyRemitClient () throws Throwable {
		ResultSet getTestData = DataFromDB.TestData(DataFromDB.SQL("hierarchyRemitClient"));
		String apndStr = CurrDateTime.GetDateTime();
		
		
		Constants.bDriver.switchTo().frame("Mainframe");
		Keywords.Click("btnAddNew");
		
		while (getTestData.next()) {
			System.out.println("Account Number: "+getTestData.getString(3));
			Keywords.SelectFromList("lstClientBusinessWorkGroup", getTestData.getString(1));
			Keywords.SendKeys("txtClientName", getTestData.getString(2)+" "+apndStr);
			searchHierarchyRemitClient.add(getTestData.getString(2)+" "+apndStr);
			Keywords.SendKeys("txtClientID", apndStr);
			Keywords.SelectFromList("lstClientType", DataFromDB.DataReuse("ClientType"));
			Keywords.SendKeys("lkpInceptionDate", getTestData.getString(3));
			
			Keywords.Click("tabBankInformation");
			Keywords.SelectFromList("lstClientBankName", DataFromDB.DataReuse("BankName"));
			Keywords.SendKeys("txtBankAccNumber", getTestData.getString(4));
			
			Keywords.Click("tabContact");
			Keywords.Click("btnContactAddRow");
			Keywords.SendKeys("txtRemitClientLastName", DataFromDB.DataReuse("ContactLastName"));
			Keywords.SendKeys("txtRemitClientFirstName", DataFromDB.DataReuse("ContactFirstName"));
			Keywords.Click("lstContactBrowse");
			Keywords.Click("lstApplyContact");
			Keywords.SelectFromList("lstRemitContactType", DataFromDB.DataReuse("ContactType"));
		}
		Keywords.Click("btnSave");
		Keywords.Click("btnCancelEdit");
	}
	
	public static void CreatePortfolio() throws Throwable{
		ResultSet getTestData = DataFromDB.TestData(DataFromDB.SQL("hierarchyPortfolio"));
		String apndStr = CurrDateTime.GetDateTime();
		
		Constants.bDriver.switchTo().frame("Mainframe");
		Keywords.Click("btnAddnew");
		
		while (getTestData.next()) {
			Keywords.SelectFromList("lstBusinessUnit", DataFromDB.DataReuse("BusinessUnit"));
			Keywords.SendKeys("txtPortfolioID", getTestData.getString(1)+" "+apndStr);
			searchPortfolioID.add(getTestData.getString(1)+" "+apndStr);
			Keywords.SendKeys("lkpRecordEffectiveDate", getTestData.getString(2));
			Keywords.SendKeys("txtPortfolioLongName", getTestData.getString(3)+" "+apndStr);
			Keywords.SendKeys("txtPortfolioShortName", getTestData.getString(4)+" "+apndStr);
			Keywords.SendKeys("lkpPortfolioInceptionDate", getTestData.getString(5));
			Keywords.SelectFromList("lstPortfolioBusinessWorkGroup", DataFromDB.DataReuse("BusinessWorkGroup"));
			Keywords.SendKeys("lkpBillingStartDate", getTestData.getString(6));
			Keywords.SelectFromList("lstPortfolioCurrency", getTestData.getString(7));
	
			Keywords.SendKeys("txtPortfolioClientName", DataFromDB.DataReuse("ClientName"));
			Keywords.Click("btnBrowserPortfolioClientName");
			Keywords.Click("btnApplyPortfolioClientName");
			
			Keywords.SelectFromList("lblPortfolioType", DataFromDB.DataReuse("PortfolioType"));
			
			Keywords.Click("btnPortfolioAddContact");
			Keywords.SendKeys("txtPortfolioContactLastName", DataFromDB.DataReuse("ContactLastName"));
			Keywords.SendKeys("txtPortfolioContactFirstName", DataFromDB.DataReuse("ContactFirstName"));
			Keywords.Click("btnBrowsePortfolioContact");
			Keywords.Click("btnApplyPortfolioContact");
			Keywords.SelectFromList("lstPortfolioContactType", DataFromDB.DataReuse("ContactType"));
		}
		Keywords.Click("btnSave");
		Keywords.Click("btnCancelEdit");
	}
	
	public static void CreateMarketValue() throws Throwable{
		ResultSet getTestData = DataFromDB.TestData(DataFromDB.SQL("marketValues"));
		Constants.bDriver.switchTo().frame("Mainframe");
		Keywords.Click("btnAddData");

		while (getTestData.next()) {
			int rowSize = GetTableRowCount("tblMarketValueData");
			rowSize = rowSize-3;
			System.out.println("Row Size: "+rowSize);
			
			Constants.bDriver.findElement(By.name(DataFromDB.Locator("txtMarketValueDate")+rowSize)).sendKeys(getTestData.getString(1));
			Constants.bDriver.findElement(By.name(DataFromDB.Locator("lstMarketValueSource")+rowSize)).sendKeys(getTestData.getString(2));
			Constants.bDriver.findElement(By.name(DataFromDB.Locator("lstMarketValueBusUnit")+rowSize)).sendKeys(DataFromDB.DataReuse("BusinessUnit"));
			Constants.bDriver.findElement(By.name(DataFromDB.Locator("txtMarketValueAccID")+rowSize)).sendKeys(DataFromDB.DataReuse("AccoutnID"));
			Constants.bDriver.findElement(By.name(DataFromDB.Locator("lstMarketValueLevel")+rowSize)).sendKeys(getTestData.getString(3));
			Constants.bDriver.findElement(By.name(DataFromDB.Locator("lstMarketValueLocalCurrency")+rowSize)).sendKeys(getTestData.getString(4));
			Constants.bDriver.findElement(By.name(DataFromDB.Locator("txtMarketValueLocalAmount")+rowSize)).sendKeys(getTestData.getString(5));
			searchLocalAmount.add(getTestData.getString(5));
			
			boolean chkLastRow = getTestData.isLast();
			if (chkLastRow != true) {
				Keywords.Click("btnAddDataRow");
			} 
			if (chkLastRow == true) {
				searchAccountID.add(DataFromDB.DataReuse("AccoutnID"));
			}
		}
		Keywords.Click("btnSave");
	}
	
	public static void CreateFeeSchedule () throws Throwable {
		Constants.bDriver.switchTo().frame("Mainframe");
		Keywords.Click("btnAddNew");
		
		ResultSet getTestData = DataFromDB.TestData(DataFromDB.SQL("feeSchedule"));
		String apndStr = CurrDateTime.GetDateTime();
		
		while (getTestData.next()) {
			boolean chkFirstRow = getTestData.isFirst();
			if (chkFirstRow == true) {
				Keywords.SelectFromList("lstFeeScheduleBusinessWorkGroup", getTestData.getString(1));
				Keywords.SendKeys("txtFeeScheduleName", getTestData.getString(2)+" "+apndStr);
				searchFeeSchedule.add(getTestData.getString(2)+" "+apndStr);
				Keywords.SendKeys("lkpScheduleRecordEffectiveDate", getTestData.getString(3));
				Keywords.SendKeys("txtFeeScheduleDescription", getTestData.getString(4));
				Keywords.SelectFromList("lstFeeScheduleCurrency", getTestData.getString(5));
				Keywords.SelectFromList("lstFeeScheduleStatus", getTestData.getString(6));
				Keywords.SendKeys("txtSchedulePrecision", getTestData.getString(7));
				Keywords.SelectFromList("lstScheduleComplexity", getTestData.getString(8));
				Keywords.SelectRadioButton("rdoScheduleType", 0);
				Keywords.SelectFromList("lstAnnualRateType", getTestData.getString(9));
			}
			
			Keywords.Click("btnTierAddRow");
			int rowSize = GetTableRowCount("tblTierTable");
			rowSize = rowSize-2;
			System.out.println("Row Size: "+rowSize);
			
			Constants.bDriver.findElement(By.name(DataFromDB.Locator("txtStartTier")+rowSize)).clear();
			Constants.bDriver.findElement(By.name(DataFromDB.Locator("txtStartTier")+rowSize)).sendKeys(getTestData.getString(10));
			
			Constants.bDriver.findElement(By.name(DataFromDB.Locator("txtEndTier")+rowSize)).clear();
			Constants.bDriver.findElement(By.name(DataFromDB.Locator("txtEndTier")+rowSize)).sendKeys(getTestData.getString(11));
			
			Constants.bDriver.findElement(By.name(DataFromDB.Locator("txtAnnualRate")+rowSize)).clear();
			Constants.bDriver.findElement(By.name(DataFromDB.Locator("txtAnnualRate")+rowSize)).sendKeys(getTestData.getString(12));
					 
		}
		Keywords.Click("btnSave");
		Keywords.Click("btnCancelEdit");
	}
	
	public static void CreateCalcRules () throws Throwable{
		Constants.bDriver.switchTo().frame("Mainframe");
		ResultSet getTestData = DataFromDB.TestData(DataFromDB.SQL("newCalcRules"));
		String apndStr = CurrDateTime.GetDateTime();
		
		while (getTestData.next()) {
			Keywords.SelectFromList("lstUsageMode", "Revenue");
			Keywords.Click("btnAddNew");
			
			Keywords.SelectFromList("lstCalcRuleType", getTestData.getString(1));
			Keywords.SelectFromList("lstCalcRulesBusinessWorkGroup", getTestData.getString(2));
			Keywords.SendKeys("txtCalcRuleName", getTestData.getString(3)+" "+apndStr);
			searchCalcRules.add(getTestData.getString(3)+" "+apndStr);
			Keywords.SendKeys("txtRuleRecordEffDate", getTestData.getString(4));
			Keywords.SendKeys("txtCalcRuleDesc", getTestData.getString(5));
			Keywords.SelectFromList("lstCalcRuleFeeType", getTestData.getString(6));
			Keywords.SelectFromList("lstCalcRuleStatus", getTestData.getString(7));
			Keywords.SelectRadioButton("rdoAdvanceArrears", 1);
			Keywords.SelectFromList("lstFeeCalculationCurrency", getTestData.getString(8));
			Keywords.SelectFromList("lstRuleFrequency", getTestData.getString(9));
			Keywords.SelectFromList("lstDayCount", getTestData.getString(10));
			Keywords.SelectFromList("lstOpenProration", getTestData.getString(11));
			Keywords.SelectFromList("lstCloseProration", getTestData.getString(12));
			Keywords.SelectFromList("lstRuleMarketValueSource", getTestData.getString(13));
			Keywords.SelectFromList("lstExchangeRateSource", getTestData.getString(14));
			Keywords.SelectFromList("lstExchangeRateType", getTestData.getString(15));
			Keywords.SelectFromList("lstAFBSource", getTestData.getString(16));
		}
		Keywords.Click("btnSave");
		Keywords.Click("btnCancelEdit");
	}
	
	public static void CreateCalculationGroup() throws Throwable{
		Constants.bDriver.switchTo().frame("Mainframe");
		String apndStr = CurrDateTime.GetDateTime();
			
		Keywords.SelectFromList("lstUsageMode", "Revenue");
		Keywords.Click("btnAddNew");
		
		Keywords.SendKeys("txtCalculationGroupName", "ST Calculation Group"+" "+apndStr);
		searchCalculationGroup.add("ST Calculation Group"+" "+apndStr);
		Keywords.SelectFromList("txtCalculationGroupBWG", DataFromDB.DataReuse("BusinessWorkGroup"));
		Keywords.SelectFromList("txtGroupWorkflowNarrative", DataFromDB.DataReuse("WorkflowNarrative"));
		
		Keywords.Click("btnSave");
		Keywords.Click("btnCancelEdit");
	}
	
	public static void CreateCalculationRecord() throws Throwable{
		ResultSet getTestData = DataFromDB.TestData(DataFromDB.SQL("calculationRecords"));
		Constants.bDriver.switchTo().frame("Mainframe");
		String apndStr = CurrDateTime.GetDateTime();
		
		while (getTestData.next()) {
			List<WebElement> chkUsage = GetElement.Gets("lstUsageMode");
			//Constants.bDriver.findElements(By.name(DataFromDB.Locator("lstUsageMode")));		
			chkUsage.get(1).sendKeys("Revenue");
			Keywords.Click("btnAddNew");
			
			Keywords.SelectFromList("lstCalRecBusinessWorkGroup", DataFromDB.DataReuse("BusinessWorkGroup"));
			Keywords.SendKeys("txtCalcRecRecordEffDate", getTestData.getString(1));
			Keywords.SendKeys("txtCalculationRecordName", getTestData.getString(2)+" "+apndStr);
			searchCalculationRecord.add(getTestData.getString(2)+" "+apndStr);
			Keywords.SelectFromList("lstCalRecCalculationGroup", DataFromDB.DataReuse("calculationGroup"));
			Keywords.SelectFromList("lstCalculationFrequency", getTestData.getString(3));
			Keywords.SelectFromList("lstBillableStatus", getTestData.getString(4));
			
			Keywords.SelectFromList("lstAssignedRulesBusinessUnit", DataFromDB.DataReuse("BusinessUnit"));
			Keywords.SendKeys("txtAssignedRulesAccountID", DataFromDB.DataReuse("AccoutnID"));
			Keywords.Clicks("btnBrowseID", 1);
			Keywords.Click("btnApplyAccountID");
			
			Keywords.Clicks("btnBrowseID", 2);
			Keywords.SendKeys("txtRuleSummaryRuleName", DataFromDB.DataReuse("ruleName"));
			Keywords.Clicks("btnBrowseID", 4);
			Keywords.Click("btnApplyRuleName");
			
			Keywords.SendKeys("txtAssignFeeSchedule", DataFromDB.DataReuse("feeSchedule"));
			Keywords.Click("btnBrowseFeeSchedule");
			Keywords.Click("btnApplyFeeSchedule");
			Keywords.SelectFromList("lstInputValue", getTestData.getString(5));
			Keywords.SelectFromList("lstInputValueLevel", getTestData.getString(6));
			Keywords.SelectFromList("lstInputDataFunction", getTestData.getString(7));

			Keywords.Clicks("btnBrowseID", 3);
			Keywords.SelectFromList("lstInvoiceGroupExchangeRateSource", getTestData.getString(8));
			Keywords.SelectRadioButton("rdoInvoiceGroupAdvanceArrears", 1);
			
			Keywords.Click("btnSaveCalculationRecord");
			Keywords.Click("btnCancelEdit");
		}
	}
}