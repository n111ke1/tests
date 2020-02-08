package Tests;

import Pages.BasePage;
import Pages.SearchPage;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;


public class Tests extends BaseTest {
private static SearchPage searchPage;


@BeforeEach
public void setUp(){
    searchPage = PageFactory.initElements(driver, SearchPage.class);
}


@Test
    public void checkSearch(){
    openPage();
    searchPage.checkFieldValue("легковые автомобили", BasePage.searchInput);
}

@Test
    public void checkCity(){
    openPage();
    searchPage.checkFieldValue("Днепр", BasePage.city);
}

@Test
    public void checkCategoryValue(){
    openPage();
    searchPage.checkFieldValueByText("Легковые автомобили");

}


//@Test
//    public void selectedCity(){
//    new SearchPage();
//


}


