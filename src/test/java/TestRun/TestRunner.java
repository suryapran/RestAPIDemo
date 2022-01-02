package TestRun;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/features" , glue ="stepdefinition",plugin="json:target/jsonReports/cucumberReport.json")

public class TestRunner {
 
	//tags= {"@DeletePlace"}  to run desired testcases only.here only deleteplace execute
	//plugin="json:target/jsonReports/cucumberReport.json"  == it will create json report
	//plugin="html:target/jsonReports/cucumber-Report.html == it will create html report
}
