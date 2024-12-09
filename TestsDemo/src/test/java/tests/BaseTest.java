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
}
