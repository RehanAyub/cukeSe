package cuke;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import selenium.SeleniumScript;

public class SeleniumCukeHooks {
    public static final SeleniumScript script = new SeleniumScript();

    @Before("@Selenium")
    public void setupSeleniumbrowser() {
        script.setWebDriver();
    }

    @After("@Selenium")
    public void killSeleniumDriverWindow() {
        script.closeBrowser();
    }

}
