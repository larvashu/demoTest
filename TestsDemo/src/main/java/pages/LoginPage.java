package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    // Lokatory elementów
    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");
    private By errorMessage = By.cssSelector("[data-test='error']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    // Wprowadzenie nazwy użytkownika
    @Step("Wprowadzenie nazwy użytkownika")
    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    // Wprowadzenie hasła
    @Step("Wprowadzenie hasła")
    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    // Kliknięcie przycisku logowania
    @Step("Klikniecie przycisku logowania")
    public InventoryPage clickLoginButton() {
        driver.findElement(loginButton).click();
        return new InventoryPage(driver);
    }

    // Pobranie tekstu błędu (jeśli występuje)
    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }
}
