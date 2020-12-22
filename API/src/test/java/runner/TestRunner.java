package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="C:\\Users\\Harneet\\git\\LearningGitr\\API\\src\\test\\java\\feature\\F2.feature",
		glue="stepDefination"
		)
public class TestRunner {

}
