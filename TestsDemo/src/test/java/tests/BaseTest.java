package tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import utils.DriverFactory;

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
}
