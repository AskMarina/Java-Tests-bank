package base;

import common.CommonActions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.base.BasePage;
import pages.loan_facilities.CarLoancePage;
import pages.telecomunications.MobilePhoneReplenishmentPage;

import java.io.File;
import java.time.LocalTime;
import java.util.Objects;

import static common.Config.*;

@ExtendWith(Listener.class)
//@Execution(ExecutionMode.CONCURRENT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {
    protected WebDriver driver = CommonActions.createDriver();
    protected BasePage basePage = new BasePage(driver);
    protected CarLoancePage carLoancePage = new CarLoancePage(driver);
    protected MobilePhoneReplenishmentPage mobilePhoneReplenishmentPage = new MobilePhoneReplenishmentPage(driver);
    private static Logger LOGGER = LoggerFactory.getLogger(BaseTest.class);

    static {
        LOGGER.info("Start time:" + LocalTime.now());
        LOGGER.info("Start clear report dir: build/report");
        File allureResult = new File("allure-results");
        for (File item : Objects.requireNonNull(allureResult.listFiles())
        ) {
            item.delete();
        }
        if (IS_CLEAR_REPORT_DIR){
            File screenReport = new File("build/reports/tests");
            for (File item : Objects.requireNonNull(screenReport.listFiles())
            ) {
                item.delete();
            }


        }

    }

    @AfterEach
    void clearCookiesAndLoanStorage() {
        if (IS_CLEAR_COOKIES) {
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
            driver.manage().deleteAllCookies();
            javascriptExecutor.executeScript("window.sessionStorage.clear()");
        }
    }

    @AfterAll
    void close() {
        if (!IS_BROWSER_OPEN) {
            driver.close();
        }
    }

}
