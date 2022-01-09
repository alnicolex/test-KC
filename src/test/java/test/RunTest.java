package test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

/**
 * Excecute tests
 */
@CucumberOptions(features = "src/test/java/features/purchase.feature")
public class RunTest extends AbstractTestNGCucumberTests{


}
