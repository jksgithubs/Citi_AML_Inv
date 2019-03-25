package main.test.runner.RevPort;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		strict = false,
		features = {"src/main/test/features"},        
        glue = {"src/main/test/stepDefs"},
        tags = {"@Scenario1, @Scenario2"},
/*		plugin= {
	            "pretty","html:test-outout", 
	            "json:json_output/cucumber.json", 
	            "junit:junit_xml/cucumber.xml"
	        },*/
        monochrome = true
		)

public class featureRunner {
	
}