package Tests;

import Pages.MainHeader;
import org.testng.annotations.Test;

public class TestScenario extends BaseTest {

    @Test
    public void checkSearchFilter(){
        new MainHeader().checkSearch();


    }




}
