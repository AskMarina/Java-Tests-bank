package loan_facilities.positive;

import base.BaseTest;
import org.junit.jupiter.api.Test;

import static constants.Constants.URLs.AUTO_CREDIT_URL;

public class CarLoansPositiveTest extends BaseTest {
    @Test
    public void selectAgreementsTabInPublicSession(){
        basePage.goToURL(AUTO_CREDIT_URL);
        carLoancePage.selectAgreementsTab();
        basePage.isAuthWidgetPresent();
    }
}
