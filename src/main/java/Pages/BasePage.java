package Pages;

import Helper.Configuration;
import Tests.BaseTest;
import org.junit.Before;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage {


    public BasePage(WebDriver driver){
        PageFactory.initElements(driver, this);

    }




@FindBy(id = "search-text")
   public static WebElement searchInput;

@FindBy(id ="param_subcat" )
    public static WebElement brandCar;

@FindBy(id = "main-category-choose-label")
    public static WebElement category;

@FindBy(id = "#cityField")
    public static WebElement city;

//    protected BasePage category(){
//        driver.findElement(By.cssSelector("main-category-choose-label"));
//
//  return this;
// }
//
//    protected BasePage brandCar(){
//        driver.findElement(By.cssSelector("param_subcat"));
//  return this;
// }
//
//    protected BasePage priceFrom(){
//        driver.findElement(By.cssSelector("#param_price .filter-item-from"));
//    return this;
// }
//
//    protected BasePage priceTo(){
//        driver.findElement(By.cssSelector("#param_price .filter-item-to"));
//  return this;
//
// }
//
// protected WebElement city(String city){
//
//        WebElement el = driver.findElement(By.cssSelector("#cityField"));
//        return el;
// }




}



