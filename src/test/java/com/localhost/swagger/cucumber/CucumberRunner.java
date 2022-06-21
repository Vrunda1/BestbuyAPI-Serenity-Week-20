package com.localhost.swagger.cucumber;


import com.localhost.swagger.testbase.TestBase;
import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/java/resources/feature/"
        ,tags = "@test2")

public class CucumberRunner extends TestBase {

}

