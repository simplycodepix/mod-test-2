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
    void formatTicketCheck() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Apple", 0.99, 5, ShoppingCart.ItemType.NEW);
        cart.addItem("Banana", 20.00, 4, ShoppingCart.ItemType.SECOND_FREE);
        cart.addItem("A long piece of toilet paper", 17.20, 1, ShoppingCart.ItemType.SALE);
        cart.addItem("Nails", 2.00, 500, ShoppingCart.ItemType.REGULAR);

        String expected = "# Item                          Price Quan. Discount   Total \n"
                + "------------------------------------------------------------\n"
                + "1 Apple                          $.99     5        -   $4.95 \n"
                + "2 Banana                       $20.00     4      50%  $40.00 \n"
                + "3 A long piece of toilet paper $17.20     1      70%   $5.16 \n"
                + "4 Nails                         $2.00   500      50% $500.00 \n"
                + "------------------------------------------------------------\n"
                + "4                                                    $550.11 ";

        assertEquals(expected, cart.formatTicket());
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