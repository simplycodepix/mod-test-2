package shoppingCart;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void appendFormattedCheck() {
        StringBuilder sb = new StringBuilder();
        ShoppingCart.appendFormatted(sb, "Append Formatted Check", 0, 14);
        assertEquals(sb.toString(), "Append Formatt ");

        sb = new StringBuilder();
        ShoppingCart.appendFormatted(sb, "Append Formatted Check", 0, 15);
        assertEquals(sb.toString(), "Append Formatte ");

        sb = new StringBuilder();
        ShoppingCart.appendFormatted(sb, "Append Formatted Check", 0, 5);
        assertEquals(sb.toString(), "Appen ");

        sb = new StringBuilder();
        ShoppingCart.appendFormatted(sb, "Append Formatted Check", 1, 15);
        assertEquals(sb.toString(), "Append Formatte ");

        sb = new StringBuilder();
        ShoppingCart.appendFormatted(sb, "Append Formatted Check", -1, 15);
        assertEquals(sb.toString(), "Append Formatte ");
    }

    @Test
    void calculateDiscountCheck() {
        assertEquals(0, ShoppingCart.calculateDiscount(ShoppingCart.ItemType.NEW, 15));
        assertEquals(0, ShoppingCart.calculateDiscount(ShoppingCart.ItemType.NEW, 1));
        assertEquals(1, ShoppingCart.calculateDiscount(ShoppingCart.ItemType.REGULAR, 15));
        assertEquals(0, ShoppingCart.calculateDiscount(ShoppingCart.ItemType.REGULAR, 1));
        assertEquals(80, ShoppingCart.calculateDiscount(ShoppingCart.ItemType.SECOND_FREE, 400));
        assertEquals(55, ShoppingCart.calculateDiscount(ShoppingCart.ItemType.SECOND_FREE, 50));
        assertEquals(52, ShoppingCart.calculateDiscount(ShoppingCart.ItemType.SECOND_FREE, 20));
        assertEquals(50, ShoppingCart.calculateDiscount(ShoppingCart.ItemType.SECOND_FREE, 7));
        assertEquals(50, ShoppingCart.calculateDiscount(ShoppingCart.ItemType.SECOND_FREE, 3));
        assertEquals(0, ShoppingCart.calculateDiscount(ShoppingCart.ItemType.SECOND_FREE, 1));
        assertEquals(80, ShoppingCart.calculateDiscount(ShoppingCart.ItemType.SALE, 400));
        assertEquals(75, ShoppingCart.calculateDiscount(ShoppingCart.ItemType.SALE, 50));
        assertEquals(72, ShoppingCart.calculateDiscount(ShoppingCart.ItemType.SALE, 20));
        assertEquals(71, ShoppingCart.calculateDiscount(ShoppingCart.ItemType.SALE, 10));
        assertEquals(70, ShoppingCart.calculateDiscount(ShoppingCart.ItemType.SALE, 7));
    }
}