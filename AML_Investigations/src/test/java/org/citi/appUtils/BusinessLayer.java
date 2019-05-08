package org.citi.appUtils;

import java.sql.ResultSet;
import org.citi.utils.Constants;
import org.citi.utils.CurrDateTime;
import org.citi.utils.DataFromDB;
import org.citi.utils.Keywords;

public class BusinessLayer {
	public static void CreateBWG() throws Throwable {
		//get TestData to copy entitlement group
		ResultSet getData = DataFromDB.TestData("newBWG");
		
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
			//searchBWGroup.add(getData.getString(1)+" "+appndStr); //pass to array in order to search later
					
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
}