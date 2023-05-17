package invoice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    void testConstructor(){
        ArithmeticException  ae = assertThrows(ArithmeticException.class,() -> new Product("a",-2));
        assertEquals("Price cannot be negative",ae.getMessage());
    }

}