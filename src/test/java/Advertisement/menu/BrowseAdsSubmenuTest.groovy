package Advertisement.menu

class BrowseAdsSubmenuTest extends GroovyTestCase {
    void testPerformAction() {
        String message = "An unknown error has occurred. "
        int number = 9;
        BrowseAdsSubmenu browseAdsSubmenu = new BrowseAdsSubmenu();
        assertNotNull(browseAdsSubmenu.performAction(number), true);
    }
}