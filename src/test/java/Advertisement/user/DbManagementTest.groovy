package Advertisement.user

class DbManagementTest extends GroovyTestCase {
    void testAddUser() {
        Users user = new Users(1, "Test Unit", "testname", "testing123", "2018.05.01.", "06201234567", "testunit@gmail.com");
        String expectedName = "Test Unit";
        assertEquals(expectedName, user.getName());
    }
}
