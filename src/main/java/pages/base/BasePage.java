package pages.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static constants.Constants.TimeOutVariables.EXPLICIT_WAIT;
import static constants.Constants.URLs.AUTH_WIDGET_URL;

public class BasePage {
    public WebDriver driver;
    public final By authWidget = By.xpath(AUTH_WIDGET_URL);
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }


    public void goToURL(String url){
        driver.get(url);

    }


    /**
     * wait for visibility element in DOM model
     */

    public WebElement waitElementIsVisible(WebElement element){
        new WebDriverWait(driver, EXPLICIT_WAIT).until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    /**
     * Check if the authorization frame is visible
     */
    public void isAuthWidgetPresent(){
        WebElement authFrame = driver.findElement(authWidget);
    }
}
