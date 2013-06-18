package cuke;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;
import static selenium.WebDriverFactory.createDriverFor;

public class SeleniumCukeHooks {
    private static WebDriver driver;

    public static WebDriver driver() {
        return driver;
    }

    @Before("@Selenium")
    public void setupSeleniumbrowser() {
        String targetBrowser = System.getProperty("target_browser");

        if (targetBrowser == null || isBadAntValue(targetBrowser)) defaultTo("firefox");
        else setDriverTo(targetBrowser);

        setTimeoutTo(30, SECONDS);
    }

    @After("@Selenium")
    public void killSeleniumDriverWindow() {
        closeBrowser();
    }

    private void setTimeoutTo(final int timeout, final TimeUnit timeUnit) {
        driver.manage().timeouts().implicitlyWait(timeout, timeUnit);
    }

    private void defaultTo(String targetBrowser) {
        driver = createDriverFor(targetBrowser);
    }

    private void setDriverTo(String targetBrowser) {
        driver = createDriverFor(targetBrowser);
    }

    private boolean isBadAntValue(String targetBrowser) {
        return targetBrowser.startsWith("${");
    }

    private void closeBrowser() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }

}
