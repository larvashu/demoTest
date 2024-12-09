package tests.inventoryPage;

import static org.junit.jupiter.api.Assertions.*;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.*;
import pages.InventoryPage;
import tests.BaseTest;
import utils.Urls;

@DisplayName("Przegladarka produktów")
@Feature("Przegladarka produktów")
public class InventoryTest extends BaseTest {
    private InventoryPage inventoryPage;

    @BeforeEach
    public void _setup() {
        driver.get(Urls.inventoryPage); // Nawigacja do strony Inventory
        inventoryPage = new InventoryPage(driver); // Inicjalizacja strony
    }

    @Test
    @Order(1)
    @Description("Test potwierdzajacy ze Logo jest widoczne")
    @Tag("Smoke")
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
    @Description("Test weryfikujący dodanie produktu do koszyka.")
    //Nie skupiam sie na poprawnosci dzialania testu; brak metody resetujacej koszyk,
    //Test zostawiam specjalnie failujacy, zeby widac bylo ze dziala
    public void testAddToCart() {
        System.out.println( "Hello World! fffff135ffffff" );
        inventoryPage.addToCart(0);
        inventoryPage.addToCart(1);
        assertEquals(3, inventoryPage.getCartItemCount());
    }

}
