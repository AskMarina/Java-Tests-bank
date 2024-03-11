package pages.loan_facilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CarLoancePage {
    WebDriver driver;
    public final By tabAgreement = By.xpath("//div[@class='item_ryTYvf_Qfl']");
    public CarLoancePage(WebDriver driver) {
        this.driver = driver;
    }
    public CarLoancePage selectAgreementsTab(){
        driver.findElement(tabAgreement).click();
        return this;

    }
}
