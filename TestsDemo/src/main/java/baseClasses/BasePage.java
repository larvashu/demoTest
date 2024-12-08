package baseClasses;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public abstract class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String getPageTitle() {
        return driver.getTitle();
    }


    protected WebElement waitForElement(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    @Step("Kliknij na element {element}")
    protected void click(WebElement element) {
        waitForElement(element).click();
    }

    @Step("Wpisz wartosc {text} do elementu {element}")
    protected void type(WebElement element, String text) {
        WebElement el = waitForElement(element);
        el.clear();
        el.sendKeys(text);
    }
    public void navigateTo(String url) {
        driver.get(url);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public boolean isElementDisplayed(String cssSelector) {
        return driver.findElement(By.cssSelector(cssSelector)).isDisplayed();
    }
}
