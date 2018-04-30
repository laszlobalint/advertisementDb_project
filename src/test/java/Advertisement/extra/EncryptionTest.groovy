package Advertisement.extra

class EncryptionTest extends GroovyTestCase {
    void testEncrypt() {
        Encryption encryption = new Encryption();
        String toEncrypt = "Some text for test";
        assertNotSame(toEncrypt, encryption.encrypt(toEncrypt));
    }
}
