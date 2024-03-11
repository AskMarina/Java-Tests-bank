package pages.telecomunications;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.base.BasePage;

public class MobilePhoneReplenishmentPage extends BasePage {
    public MobilePhoneReplenishmentPage(WebDriver driver) {
        super(driver);
    }
    private final By buttonWallet = By.xpath("//div[contains(text(),'My wallet')]");
    private final By inputPhoneNumber = By.xpath("//input[@data-qa-node='phone-number']");
    private final By inputAmount = By.xpath("//input[@data-qa-node='amount']");
    private final By inputCardForPayment = By.xpath("//input[@autocomplete='cc-number']");
    private final By inputExpDate = By.xpath("//input[@data-qa-node='expiredebitSource']");
    private final By inputCVV = By.xpath("//input[@data-qa-node='cvvdebitSource']");
    private final By buttonSubmitToTheCard = By.xpath("//button[@data-qa-node='submit']");
    private final By paymentDetails = By.xpath("//div[@class='sc-eldPxv cAZrXE']");
    /**
     *Choose a card from the wallet
     */
    public MobilePhoneReplenishmentPage selectCardFromWallet(){
        driver.findElement(buttonWallet).click();
        return this;
    }
    /**
     * Enter a phone number excluding country code
     * @param number phone number
     */
    public MobilePhoneReplenishmentPage enterPhoneNumber(String number){
        driver.findElement(inputPhoneNumber).sendKeys(number);
        return this;
    }
    /**
     * Enter the payment amount for the phone
     * @param amount payment amount
     */
    public MobilePhoneReplenishmentPage enterAmount(String amount){
        driver.findElement(inputAmount).sendKeys(Keys.CONTROL, "a");
        driver.findElement(inputAmount).sendKeys(Keys.DELETE);
        driver.findElement(inputAmount).sendKeys(amount);
        return this;
    }

    /**
     *Enter a credit or debit card number
     * @param CardForPayment card number
     */
    public MobilePhoneReplenishmentPage enterCardForPayment(String CardForPayment){
        driver.findElement(inputCardForPayment).sendKeys(CardForPayment);
        return this;
    }

    /**
     *Expiration date of the card
     */
    public MobilePhoneReplenishmentPage enterExpDate(String ExpDate){
        driver.findElement(inputExpDate).sendKeys(ExpDate);
        return this;
    }

    /**
     * CVV card numbers
     */
    public MobilePhoneReplenishmentPage enterCVV(String CVV){
        driver.findElement(inputCVV).sendKeys(CVV);
        return this;
    }

    /**
     *Click the add to cart button
     */
    public MobilePhoneReplenishmentPage submitToTheCard(){
        driver.findElement(buttonSubmitToTheCard).click();
        return this;
    }

    /**
     * @param text - the text
     */
    public MobilePhoneReplenishmentPage checkPaymentsDetailsIsPresentInTheCard(String text){
        waitElementIsVisible(driver.findElement(paymentDetails));
        WebElement details = driver.findElement(paymentDetails);
        Assertions.assertEquals(text,details.getText());
        return this;
    }




}
