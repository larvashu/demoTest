package tests;

import baseClasses.BaseReport;
import extensions.ScreenShotOnFailure;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.DriverFactory;

import java.io.ByteArrayInputStream;
import java.io.IOException;

@ExtendWith(ScreenShotOnFailure.class) // Apply the screenshot extension here
public abstract class BaseTest extends BaseReport {

    protected static WebDriver driver;

    @BeforeAll
    public static void setup() {
        driver = DriverFactory.getDriver();
    }

    @AfterAll
    public static void teardown() throws IOException {
        DriverFactory.quitDriver();
        displayRaport();
    }

    // Custom TestWatcher to capture test result
    @ExtendWith(ScreenshotOnFailureWatcher.class)
    public static class ScreenshotOnFailureWatcher implements TestWatcher {

        @Override
        public void testFailed(ExtensionContext context, Throwable cause) {
            // Capture screenshot if test fails
            takeScreenshot(context.getDisplayName());
        }

        @Override
        public void testSuccessful(ExtensionContext context) {
            // Optionally, we can add handling for successful tests if needed.
        }

        @Override
        public void testAborted(ExtensionContext context, Throwable cause) {
            // Optionally, we can add handling for aborted tests if needed.
        }

        private void takeScreenshot(String testName) {
            try {
                // Capture the screenshot as a byte array
                TakesScreenshot screenshot = (TakesScreenshot) driver;
                byte[] screenshotBytes = screenshot.getScreenshotAs(OutputType.BYTES);

                // Attach the screenshot to the Allure report
                Allure.addAttachment(testName + "_screenshot.png", new ByteArrayInputStream(screenshotBytes));
            } catch (Exception e) {
                e.printStackTrace(); // Log any exception that occurs while taking the screenshot
            }
        }
    }
}
