package Pages;


import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class SearchPage extends  BasePage {


    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public SearchPage checkInputText(String inputText){

        String el = searchInput().getAttribute("value");
        Assert.assertEquals(el, inputText, "invalid searchInputValue");
        return this;
    }

//    public SearchPage checkSelectedCity(String CityText){
//            city(CityText);
//        return this;
//    }




}
