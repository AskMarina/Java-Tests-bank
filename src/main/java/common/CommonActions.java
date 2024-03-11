package common;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static common.Config.BROWSER_AND_PLATFORM;
import static constants.Constants.TimeOutVariables.IMPLICIT_WAIT;

public class CommonActions {
    public static WebDriver createDriver() {
        WebDriver driver = null;
        switch (BROWSER_AND_PLATFORM) {
            case "CHROME_WINDOWS":
                System.setProperty("webdriver.chrome.chromedriver", "src/main/resources");
                driver = new ChromeDriver();
                break;
            case "MOZILLA_WINDOWS":
                System.setProperty("webdriver.chrome.chromedriver", "src/main/resources");
                driver = new FirefoxDriver();
                break;
            default:
                Assertions.fail("Incorrect browser name: " + BROWSER_AND_PLATFORM);
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
        return driver;
    }
}
