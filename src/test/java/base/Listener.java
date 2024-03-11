package base;

import ch.qos.logback.core.util.FileUtil;
import org.codehaus.plexus.util.FileUtils;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.junit.jupiter.engine.execution.DefaultTestInstances;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import telecomunications.positive.MobilePhoneReplenishmentPositivePageTest;

import java.io.File;
import java.io.IOException;

public class Listener implements TestWatcher {
    private static Logger LOGGER = LoggerFactory.getLogger(Listener.class);


    @Override
    public void testFailed(ExtensionContext context, Throwable cause){
        LOGGER.info("Test {} - FAILED", context.getTestMethod().get().getName());
        String screenShortName = context.getTestMethod().get().getName()+ String.valueOf(System.currentTimeMillis()).substring(9,13);
        TakesScreenshot takesScreenshot = (TakesScreenshot) ((BaseTest)(context.getRequiredTestInstances().getAllInstances().get(0))).driver;
        File source = ((TakesScreenshot) takesScreenshot).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(source, new File("build/reports/tests/"+screenShortName+".png"));
        } catch (IOException e) {
            LOGGER.info("Exception on saving screenshot");
            e.printStackTrace();
        }
    }
}
