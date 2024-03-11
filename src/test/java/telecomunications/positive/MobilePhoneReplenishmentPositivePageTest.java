package telecomunications.positive;
import base.BaseTest;
import org.junit.jupiter.api.Test;

import static constants.Constants.MobileReplenishmentData.*;
import static constants.Constants.URLs.*;

public class MobilePhoneReplenishmentPositivePageTest extends BaseTest{
    @Test
    public void checkIsRedirectToAuth() {
        basePage.goToURL(MOBILE_PAYMENT_URL);
        mobilePhoneReplenishmentPage.selectCardFromWallet();
        basePage.isAuthWidgetPresent();

    }

    @Test
   public void checkMinimumReplenishmentAmount(){
       basePage.goToURL(MOBILE_PAYMENT_URL);
       mobilePhoneReplenishmentPage
               .enterPhoneNumber(MOBILE_PAYMENT_PHONE_NUMBER)
               .enterAmount("1")
               .enterCardForPayment(MOBILE_PAYMENT_CARD)
               .enterExpDate(MOBILE_PAYMENT_CARD_EXP_DATE)
               .enterCVV(MOBILE_PAYMENT_CARD_CVV)
               .submitToTheCard()
               .checkPaymentsDetailsIsPresentInTheCard("Mobile payment. Phone number +380686979712");

    }





}
