package tests.inventoryPage;

import io.qameta.allure.Description;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import pages.InventoryPage;
import tests.BaseTest;
import utils.Urls;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SortTest extends BaseTest {
    private InventoryPage inventoryPage;

    @Override
    @BeforeEach
    public void setup() {
        super.setup();
        driver.get(Urls.inventoryPage); // Nawigacja do strony Inventory
        inventoryPage = new InventoryPage(driver); // Inicjalizacja strony
    }

    @Test
    @Description("Test weryfikujący poprawność sortowania produktów według nazw od Z do A.")
    public void testSortByNameDescending() {
        inventoryPage.sortItems("Name (Z to A)");

        List<String> itemNames = inventoryPage.getAllItemNames();
        // posortowana kopia listy
        List<String> sortedNames = new ArrayList<>(itemNames);
        sortedNames.sort(Comparator.reverseOrder());

        // Asercja
        assertEquals(sortedNames, itemNames);
    }
    @Test
    @Description("Test weryfikujący poprawność sortowania produktów według ceny rosnąco.")
    public void testSortByPriceLowToHigh() {
        // Sortowanie produktów po cenie rosnąco
        inventoryPage.sortItems("Price (low to high)");

        // Pobranie wszystkich cen
        List<Double> itemPrices = inventoryPage.getAllItemPrices();

        // posortowana kopia listy
        List<Double> sortedPrices = new ArrayList<>(itemPrices);
        sortedPrices.sort(Comparator.naturalOrder());

        assertEquals(sortedPrices, itemPrices);
    }

}
