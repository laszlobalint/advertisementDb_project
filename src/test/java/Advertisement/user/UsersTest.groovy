package Advertisement.user

class UsersTest extends GroovyTestCase {
    void testSetPassword() {
        Users user = new Users(1, "Test Unit", "testname", "testing123", "2018.05.01.", "06201234567", "testunit@gmail.com");
        user.setPassword("newpasswordrequired001")
        String expectedPassword = "newpasswordrequired001";
        assertEquals(expectedPassword, user.getPassword());
    }


}
