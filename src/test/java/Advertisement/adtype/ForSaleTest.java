package Advertisement.adtype;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ForSaleTest {

    @Test
    void getPrice() {
        ForSale forSale = new ForSale(3, 10, "I am selling my nice flat", "Szabadka", 1982, 23000, false, "2018.01.01.");
        assertEquals(forSale.getPrice(), 23000);
    }
}