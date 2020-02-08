package Tests;

import Pages.BasePage;
import Pages.SearchPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;


public class Tests extends BaseTest {


@Test
    public void checkSearch(){
    openPage();
    new SearchPage(driver)
            .checkInputText("легковые автомобили");

}

//@Test
//    public void selectedCity(){
//    new SearchPage();
//


}


