package Tests;

import Pages.BasePage;
import Pages.SearchPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import javax.sql.rowset.serial.SerialArray;


public class Tests extends BaseTest {
SearchPage searchPage;

public void setUp(){
    searchPage = PageFactory.initElements(driver, SearchPage.class);
}


@Test
    public void checkSearch(){
    openPage();
    searchPage.checkInputText("легковые автомобили");


}

//@Test
//    public void selectedCity(){
//    new SearchPage();
//


}


