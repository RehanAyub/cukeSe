package selenium;

import org.openqa.selenium.By;

import static cuke.SeleniumCukeHooks.driver;
import static org.junit.Assert.assertEquals;

public class SeleniumScript {
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
}
