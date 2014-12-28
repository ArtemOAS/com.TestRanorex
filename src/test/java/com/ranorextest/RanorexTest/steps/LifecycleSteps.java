package com.ranorextest.RanorexTest.steps;

import com.ranorextest.RanorexTest.webdriver.WebDriverFactory;
import org.apache.log4j.Logger;
import org.jbehave.core.annotations.AfterStory;
import org.jbehave.core.annotations.BeforeStory;

/**
 * Created by Тёма on 26.12.2014.
 */
public class LifecycleSteps {

    private static final Logger LOG = Logger.getLogger(LifecycleSteps.class);

    @BeforeStory
    public void initWebDrover() {
        LOG.info("BeforeStory init web driver");
        WebDriverFactory.getWebDriver();
    }

    @AfterStory
    public void quiteBrowser() {
        LOG.info("AfterStory quit driver");
        WebDriverFactory.quit();
    }

}
