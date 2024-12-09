package pages;

import baseClasses.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static io.qameta.allure.Allure.step;

public class LoginPage extends BasePage {
    // Lokatory elementów
    private final By usernameField = By.id("user-name");
    private final By passwordField = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By errorMessage = By.cssSelector("[data-test='error']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterUsername(String username) {
        step("Wprowadzenie nazwy użytkownika: " + username);
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        step("Wprowadzenie hasła: " + password);
        driver.findElement(passwordField).sendKeys(password);
    }

    public InventoryPage clickLoginButton() {
        step("Kliknij przycisk logowania");
        driver.findElement(loginButton).click();
        return new InventoryPage(driver);
    }

    // Pobranie tekstu błędu (jeśli występuje)
    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }
}
