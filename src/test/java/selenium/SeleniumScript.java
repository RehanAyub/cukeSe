package selenium;

import org.openqa.selenium.*;

import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.Assert.assertEquals;
import static selenium.WebDriverFactory.createDriverFor;

public class SeleniumScript {
    private WebDriver driver;

    public void setWebDriver() {
        String targetBrowser = System.getProperty("target_browser");

        if (targetBrowser == null || isBadAntValue(targetBrowser)) defaultTo("firefox");
        else setDriverTo(targetBrowser);

        setTimeoutTo(30, SECONDS);
    }

    private boolean isBadAntValue(String targetBrowser) {
        return targetBrowser.startsWith("${");
    }

    public void gotoGoogleUkFrontPage() {
        driver.get("http://www.google.co.uk/");
    }

    public void searchForThirstyBear() {
        driver.findElement(By.id("gbqfq")).clear();
        driver.findElement(By.id("gbqfq")).sendKeys("thirsty bear software");
        driver.findElement(By.id("gbqfb")).click();
    }

    public void clickOnFirstLink() {
        String urlToGrab = driver.findElement(By.xpath("//a[em]")).getAttribute("href");
        driver.get(urlToGrab);
    }

    public void checkWeAreOnThirstyBearHomePage() {
        assertEquals("Home", driver.getTitle());
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
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

}
