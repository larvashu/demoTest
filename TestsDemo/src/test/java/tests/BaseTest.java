package tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import utils.DriverFactory;

import java.io.IOException;

public abstract class BaseTest {
    protected WebDriver driver;

    @BeforeEach
    public void setup() {
        driver = DriverFactory.getDriver();
    }

    @AfterAll
    public static void teardown() {
        DriverFactory.quitDriver();
    }

    @AfterAll
    public static void displayRaport() throws IOException {
        // Use PowerShell to execute the allure serve command
        ProcessBuilder processBuilder = new ProcessBuilder("powershell", "-Command", "allure serve allure-results");
        processBuilder.start();
    }
}
