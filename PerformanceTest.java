package org.citi.risk.insight.utils;

import java.io.File;
import org.apache.jmeter.engine.StandardJMeterEngine;
import org.apache.jmeter.save.SaveService;
import org.apache.jmeter.util.JMeterUtils;
import org.apache.jorphan.collections.HashTree;

public class PerformanceTest {
	public static void Run() throws Throwable {
		StandardJMeterEngine JMeter = new StandardJMeterEngine();

	    //Initialize JMeter Properties, locale and JMeter home
	    JMeterUtils.loadJMeterProperties("D:\\JKsWind\\@Tools\\Apche\\apache-jmeter-5.2.1\\bin\\jmeter.properties");
	    JMeterUtils.setJMeterHome("D:\\JKsWind\\@Tools\\Apche\\apache-jmeter-5.2.1");
	    JMeterUtils.initLocale();

	    //Initialize JMeter SaveService
	    SaveService.loadProperties();

	    //Load existing .jmx Test Plan
	    HashTree jmeterTestPlan = SaveService.loadTree(new File("C:\\Users\\10654393\\Desktop\\WebserviceThread.jmx"));

	    //Run JMeter Test
	    JMeter.configure(jmeterTestPlan);
	    JMeter.run();
	        
	    /*Summariser summer = null;
	    String summariserName = JMeterUtils.getPropDefault("summariser.name", "summary");//$NON-NLS-1$
	    if (summariserName.length() > 0) {
	    	summer = new Summariser(summariserName);
	       }

	    String logFile = "C:\\Users\\10654393\\Desktop\\testresults.jtl";
	    ResultCollector logger = new ResultCollector(summer);
	    logger.setFilename(logFile);
	    testPlanTree.add(testPlanTree.getArray()[0], logger);*/
	        
	    //jmeter.stopTest();
	}
}