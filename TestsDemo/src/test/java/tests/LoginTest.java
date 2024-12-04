package tests;

import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.InventoryPage;
import pages.LoginPage;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LoginTest {
    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/v1/");
        loginPage = new LoginPage(driver);
    }

    @Test
    @Order(1)
    @Description("Test potwierdzajacy mozliwosc zalogowania sie poprawnymi danymi.")
    public void testSuccessfulLogin() {
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        InventoryPage inventoryPage = loginPage.clickLoginButton();

        // Sprawdzamy, czy zostaliśmy przeniesieni na stronę produktów
        assertTrue(inventoryPage.isLogoDisplayed(),
                "Logo should be displayed after successful login.");
    }

    @Test
    @Order(2)
    @Description("Test weryfikujący nieudane logowanie w przypadku uzycia zlych danych")
    public void testInvalidLogin() {
        loginPage.enterUsername("invalid_user");
        loginPage.enterPassword("wrong_password");
        loginPage.clickLoginButton();

        // Sprawdzamy komunikat o błędzie
        String expectedErrorMessage = "Epic sadface: Username and password do not match any user in this service";
        assertEquals(expectedErrorMessage, loginPage.getErrorMessage(), "Error message should match the expected text.");
    }

    @Test
    @Order(3)
    public void testLoginWithEmptyFields() {
        loginPage.enterUsername("");
        loginPage.enterPassword("");
        loginPage.clickLoginButton();

        // Sprawdzamy komunikat o błędzie
        String expectedErrorMessage = "Epic sadface: Username is required";
        assertEquals(expectedErrorMessage, loginPage.getErrorMessage(), "Error message should indicate that username is required.");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
