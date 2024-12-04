package tests.inventoryPage;

import static org.junit.jupiter.api.Assertions.*;

import io.qameta.allure.Description;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import pages.InventoryPage;
import tests.BaseTest;
import utils.Urls;

public class InventoryTest extends BaseTest {
    private InventoryPage inventoryPage;

    @Override
    @BeforeEach
    public void setup() {
        super.setup();
        driver.get(Urls.inventoryPage); // Nawigacja do strony Inventory
        inventoryPage = new InventoryPage(driver); // Inicjalizacja strony
    }

    @Test
    @Order(1)
    public void testLogoDisplayed() {
        assertTrue(inventoryPage.isLogoDisplayed());
    }


    @Test
    @Order(2)
    @Description("Test weryfikujący mozliwość usuwania produktow z koszyka")
    public void testRemoveFromCart() {
        inventoryPage.addToCart(0);
        inventoryPage.addToCart(1);
        inventoryPage.removeFromCart(0);
        assertEquals(1, inventoryPage.getCartItemCount());
    }


    @Test
    @Order(3)
    @Description("Test weryfikujący mozliwosc dodawania produktow do koszyka.")
    public void testAddToCart() {
        inventoryPage.addToCart(0);
        inventoryPage.addToCart(1);
        assertEquals(2, inventoryPage.getCartItemCount());
    }


}
