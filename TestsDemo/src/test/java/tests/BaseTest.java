package tests;

import baseClasses.BaseReport;
import extensions.ScreenShotOnFailure;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import utils.DriverFactory;
import java.io.IOException;

@ExtendWith(ScreenShotOnFailure.class)
public abstract class BaseTest extends BaseReport {

    protected static WebDriver driver;

    @BeforeAll
    public static void setup() {
        driver = DriverFactory.getDriver();
    }

    @AfterAll
    public static void teardown() throws IOException {
        DriverFactory.quitDriver();
        //displayRaport();
        //TODO: Nalezy odkomentowac powyzsza linie, zeby reporty wlaczaly sie automatycznie (1 zakladka per testKlasa)
    }
}
