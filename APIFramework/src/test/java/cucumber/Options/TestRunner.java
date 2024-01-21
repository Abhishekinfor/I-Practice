package cucumber.Options;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="C:\\Users\\arangaswamy\\OneDrive - Infor\\Documents\\Abhishek_workspace\\APIFramework\\src\\test\\java\\features\\placeValidations.feature", 
        glue="stepDefinitons"
		)
public class TestRunner {

}
