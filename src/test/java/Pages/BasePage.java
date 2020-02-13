package Pages;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class BasePage {

    public BasePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

/***Elements for Search block***/
    @FindBy(id = "search-text")
   public  WebElement searchInput;

    @FindBy(id ="param_subcat" )
    public WebElement brandCar;

    @FindBy(id = "main-category-choose-label")
    public  WebElement category;

    @FindBy(id = "cityField")
    public WebElement city;


/***Elements for filters block***/

    @FindBy(id = "param_subcat")
    public WebElement carBrandField;

    @FindBy(css = "#param_subcat .suggestinput li a")
    public List<WebElement> carBrandNames;

    @FindBy(css = ".filter-both-item .price:nth-child(1) .num-input input")
    public WebElement priceFromFieldInput;

    @FindBy(css = ".filter-both-item .price:nth-child(2) .num-input input")
    public WebElement priceToFieldInput;

    @FindBy(css = ".filter-item-transmission_type")
    public WebElement transmissionTypeCheckBox;

    @FindBy(css = ".filter-item-transmission_type .suggestinput [type='checkbox'][data-text='Механическая']")
    public WebElement transmissionTypeMechanichal;

    @FindBy(css = ".filter-both-item .price:nth-child(1) .header")
    public WebElement priceFromField;
    @FindBy(css = ".filter-both-item .price:nth-child(2) .header")
    public WebElement priceToField;

    @FindBy(css = "#param_motor_mileage .filter-item:nth-child(1) input")
    public WebElement motorMileageFromInput;

    @FindBy(css = "#param_motor_mileage .filter-item:nth-child(2) input")
    public WebElement motorMileageToInput;

    @FindBy(css = "#param_motor_mileage .filter-item:nth-child(1)")
    public WebElement motorMileageFrom;

    @FindBy(css = "#param_motor_mileage .filter-item:nth-child(2)")
    public WebElement motorMileageTo;

    @FindBy(css = "#offers_table .price")
    public List<WebElement> resultPrices;

}



