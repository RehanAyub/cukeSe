package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;

interface DriverBuilder {
    WebDriver getDriver();
}

public final class WebDriverFactory {
    private static Map<String, DriverBuilder> driverBuilders = new HashMap<String, DriverBuilder>();

    static {
        driverBuilders.put("firefox", new FirefoxDriverBuilder());
        driverBuilders.put("chrome", new ChromeDriverBuilder());
    }

    private WebDriverFactory() {
        // stop construction
    }

    public static WebDriver createDriverFor(final String targetBrowser) {
        DriverBuilder builder = driverBuilders.get(targetBrowser);

        if (builder == null)
            throw new RuntimeException(String.format("Browser type [%s] not supported", targetBrowser));

        return builder.getDriver();
    }
}

class FirefoxDriverBuilder implements DriverBuilder {
    public WebDriver getDriver() {
        return new FirefoxDriver();
    }
}

class ChromeDriverBuilder implements DriverBuilder {
    public WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        return new ChromeDriver();
    }
}