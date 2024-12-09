package extensions;

import io.qameta.allure.Allure;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.DriverFactory;

import java.io.ByteArrayInputStream;

public class ScreenShotOnFailure implements TestWatcher {

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        // Capture screenshot if test fails
        takeScreenshot(context.getDisplayName());
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        // Optionally, handle successful tests if needed.
    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
        // Optionally, handle aborted tests if needed.
    }

    private void takeScreenshot(String testName) {
        WebDriver driver = DriverFactory.getDriver(); // Get the WebDriver instance
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
