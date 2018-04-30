package Advertisement.adtype

class ForRentTest extends GroovyTestCase {
    void testLoadForRent() {
        Map <Integer, ForRent> rentAds = new TreeMap <>();
        ForRent forRent = new ForRent();
        assertEquals(true, forRent.loadForRent());
    }
}
