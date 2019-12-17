package com.cucumber.testrunner.simplecucumberframework;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources", glue = {
	"com.cucumber.stepdefinition.simplecucumberframework" })

        // If you want to skip a particular tag use ~@SmokeTest (Use ~)
	//If you want to use multiple combinations of grouping @SmokeTest AND @RegressionTest


public class MyApplicationRunner {

}
