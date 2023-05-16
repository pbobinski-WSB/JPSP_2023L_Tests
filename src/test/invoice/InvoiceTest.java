package invoice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InvoiceTest {

    Invoice invoice;
    @BeforeEach
    void setUp() {
        invoice =  new Invoice(new Address("1","2","3","4","5"));
    }
    @Test
    void add() {
        assertEquals(0,invoice.getItems().size());
        Product product = new Product("a",2);
        invoice.add(product,5);
        assertEquals(1,invoice.getItems().size());
    }

    @Test
    void format() {
        assertEquals("                     I N V O I C E\n" +
                "\n" +
                "\n" +
                "\n" +
                "Description                      Price  Qty   Total\n" +
                "\n" +
                "AMOUNT DUE: $    0,00",invoice.format());
        Product product = new Product("a",2);
        invoice.add(product,5);
        assertEquals("                     I N V O I C E\n" +
                "\n" +
                "\n" +
                "\n" +
                "Description                      Price  Qty   Total\n" +
                "\n\n" +
                "AMOUNT DUE: $    0,00",invoice.format());
    }

    @Test
    void getAmountDue() {
        assertEquals(0,invoice.getAmountDue());
        Product product = new Product("a",2);
        invoice.add(product,5);
        assertEquals(10,invoice.getAmountDue());
    }
}