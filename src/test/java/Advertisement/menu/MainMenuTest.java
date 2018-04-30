package Advertisement.menu;

import Advertisement.dbaccess.DataService;
import Advertisement.user.Users;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.sql.SQLException;
import java.util.NavigableMap;
import java.util.TreeMap;

import static org.mockito.Mockito.mock;

public class MainMenuTest {
    MainMenu mainMenu;

    @Mock
    DataService dataServiceMock;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Before
    public void init() {
        dataServiceMock = mock(DataService.class);
        mainMenu = new MainMenu(dataServiceMock);
    }

    @Test(expected = Exception.class)
    public void testPerformAction() throws Exception {
        NavigableMap<Integer, Users> users = new TreeMap<>();
        Mockito.doThrow(new SQLException()).when(dataServiceMock).insertUsers(users);
        mainMenu.performAction(0);
    }

    @Test
    public void testMapIsEmpty() {
        NavigableMap<Integer, Users> users = new TreeMap<>();
    }
}
