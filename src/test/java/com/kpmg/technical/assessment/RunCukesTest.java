package com.kpmg.technical.assessment;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/resources",
        tags = "@end-to-end",
        dryRun = false,
        plugin = {"json:target/cucumber.json"})
public class RunCukesTest {
}
