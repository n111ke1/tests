package Pages;

import Helper.Configuration;
import Tests.BaseTest;
import org.junit.Before;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage {


    private WebDriver driver;
    private WebDriverWait wait;

    public BasePage(WebDriver driver){
        this.driver = driver;
//        this.wait = new WebDriverWait(driver, 8);
    }




    protected WebElement searchInput(){
        WebElement el = driver.findElement(By.cssSelector("#search-text"));
//      WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated((By.cssSelector("#search-text")) ));
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



