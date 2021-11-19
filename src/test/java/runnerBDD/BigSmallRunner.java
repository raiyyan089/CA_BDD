package runnerBDD;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(
		features ={"features"},
		glue = {"StepDefinitions"},
		dryRun = false,
		monochrome = true)

public class BigSmallRunner extends AbstractTestNGCucumberTests
{

}