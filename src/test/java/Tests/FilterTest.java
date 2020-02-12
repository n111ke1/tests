package Tests;

import Helper.ThreadDriver;
import Pages.BasePage;
import Pages.FilterPage;
import Pages.SearchPage;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.PageFactoryFinder;


public class FilterTest extends BaseTest {
private static SearchPage searchPage;
private static FilterPage filterPage;



@BeforeEach
public void initPages() {
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
    public void checkFieldsPriceAfterInputLetters(){
    openPage();
    filterPage.checkInputFieldPriceFrom("test")
            .checkInputFieldPriceTo("test");
}

@Test
    public void checkTransmissionCheck(){
    openPage();
    filterPage.checkTransmissionTypeAll()
            .checkTransmissionTypeAllAfterSelectedAnother();

}


@Test
    public void checkMotorMileageInput(){
    openPage();
    filterPage.motorMileageFromInput("100000")
            .motorMileageToInput("200000");

}
@Test
    public void checkMotorMileageSelect(){
    openPage();
    filterPage.selectMotorMileageFrom("100000")
            .selectMotorMileageToSelect("200000");
}

@Test /**This test cant working because Olx get in result mix currency of price in $ and in hrn**/
    public void checkPriceinResultLIst(){
    openPage();
    filterPage.checkPriceAfterSort("100000", "600000" );
}








}


