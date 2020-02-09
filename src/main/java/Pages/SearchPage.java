package Pages;


import Helper.ElementActions;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class SearchPage extends  BasePage {


    public SearchPage(WebDriver driver) {
        super(driver);
    }



    public SearchPage checkFieldValue(String inputText, WebElement el){
        ElementActions.waitElementPresent(el);
        String text =  el.getAttribute("value");
        Assert.assertEquals("error", inputText, text);
        return this;
    }

    public SearchPage checkFieldValueByText(String text){
        ElementActions.waitElementPresent(category);
        String fieldText = category.getText();
        Assert.assertEquals(fieldText,text);

        return this;
    }






//    public SearchPage checkSelectedCity(String CityText){
//            city(CityText);
//        return this;
//    }




}
