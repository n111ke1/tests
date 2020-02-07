package Pages;

import Tests.BaseTest;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage extends BaseTest  {



//   public WebElement setSelector(String cssSelector){
//
//     WebElement element = driver.findElement(By.cssSelector(cssSelector));
//    return element;
//   }
   private WebDriverWait waitElement(){
       String exWait =  properties.getProperty("explicitlyWait");
        return new WebDriverWait(driver, Long.parseLong(exWait));

    }

    protected WebElement checkElementIsVisible (WebElement element){
        WebElement el = waitElement().until(ExpectedConditions.visibilityOf((element)));
        return el;
    }



  protected WebElement searchInput(){
     WebElement el = waitElement().until(ExpectedConditions.visibilityOfElementLocated((By.cssSelector("#search-text")) ));
    return el;
   }



    protected BasePage category(){
        driver.findElement(By.cssSelector("main-category-choose-label"));
  return this;
 }

    protected BasePage brandCar(){
        driver.findElement(By.cssSelector("param_subcat"));
  return this;
 }

    protected BasePage priceFrom(){
        driver.findElement(By.cssSelector("#param_price .filter-item-from"));
    return this;
 }

    protected BasePage priceTo(){
        driver.findElement(By.cssSelector("#param_price .filter-item-to"));
  return this;

 }

 protected WebElement city(String city){

        WebElement el = driver.findElement(By.cssSelector("#cityField"));
        return el;
 }




}



