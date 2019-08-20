package com.kpmg.technical.assessment;

import com.kpmg.technical.assessment.driver.DriverManager;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks extends DriverManager {

    private DriverManager manager = new DriverManager();

    @Before
    public void setUp() {
        manager.openBrowser();
        manager.navigateToUrl();
        manager.maximiseBrowser();
        manager.initialiseExplicitWait();
        manager.handlePrivacyMessage();
    }

    @After
    public void tearDown(Scenario scenario) {

        if (scenario.isFailed()) {
            manager.embedScreenshot(scenario);
        }

        /**
         * as per test requirements taking physical screenshot, but ideally take screen shot only when test failed as above code
         */
        manager.takeScreenshot();
        manager.closeBrower();
    }
}
