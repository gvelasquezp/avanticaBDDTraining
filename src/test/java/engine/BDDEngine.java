package engine;

import org.testng.annotations.Test;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(features={"src//test//java//features"}
				,glue={"tests"})

@Test
public class BDDEngine extends AbstractTestNGCucumberTests{

}
