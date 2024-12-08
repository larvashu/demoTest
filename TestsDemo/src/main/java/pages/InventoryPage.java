package pages;

import baseClasses.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

import static io.qameta.allure.Allure.step;

public class InventoryPage extends BasePage {
    private final By inventoryItemNames = By.cssSelector(".inventory_item_name");
    private final By inventoryItemPrices = By.cssSelector(".inventory_item_price");

    @FindBy(className = "inventory_item")
    private List<WebElement> inventoryItems;

    @FindBy(css = ".btn_inventory")
    private List<WebElement> addToCartButtons;

    @FindBy(css = ".shopping_cart_badge")
    private WebElement cartBadge;

    @FindBy(css = ".app_logo") // Logo element
    private WebElement logo;

    @FindBy(css = ".product_sort_container")
    private WebElement sortDropdown;

    public InventoryPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void addToCart(int index) {
        if (index < addToCartButtons.size()) {
            click(addToCartButtons.get(index));
        }
    }
    @Step("Pobierz wszystkie nazwy produktów")
    public List<String> getAllItemNames() {
        return driver.findElements(inventoryItemNames).stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    @Step("Pobierz nazwę pierwszego elementu")
    public String getFirstItemName() {
        return getAllItemNames().get(0);
    }

    @Step("Pobierz nazwę ostatniego elementu")
    public String getLastItemName() {
        List<String> items = getAllItemNames();
        return items.get(items.size() - 1);
    }

    public void removeFromCart(int index) {
        if (index < addToCartButtons.size()) {
            click(addToCartButtons.get(index)); // Button changes to "Remove"
        }
    }

    public int getCartItemCount() {
        try {
            return Integer.parseInt(cartBadge.getText());
        } catch (Exception e) {
            return 0;
        }
    }

    public void sortItems(String sortOption) {
        step("Sortuj według: " + sortOption);
        Select dropdown = new Select(sortDropdown);
        dropdown.selectByVisibleText(sortOption); // Select an option by its visible text
    }

    @Step("Pobierz wszystkie ceny produktów")
    public List<Double> getAllItemPrices() {
        return driver.findElements(inventoryItemPrices).stream()
                .map(priceElement -> Double.parseDouble(priceElement.getText().replace("$", "")))
                .collect(Collectors.toList());
    }

    @Step("")
    public boolean isLogoDisplayed() {
        return logo.isDisplayed();
    }
}
