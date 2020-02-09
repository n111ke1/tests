package Tests;

import Pages.BasePage;
import Pages.FilterPage;
import Pages.SearchPage;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;


public class Tests extends BaseTest {
private static SearchPage searchPage;
private static FilterPage filterPage;

@BeforeEach
public void setUp(){
    searchPage = PageFactory.initElements(driver, SearchPage.class);
    filterPage = PageFactory.initElements(driver, FilterPage.class);
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
@Test
    public void checkCarBrandsNameInList(){
    openPage();
    filterPage.activateCarBrandField().checkCarBrandsName();

}
@Test
    public void checkFieldPriceAfterInputLetters(){
    openPage();
    filterPage.checkPpriceFieldAfterInputLiters();
}









}


