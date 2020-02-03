package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.FindsByCssSelector;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Factory;

public class BasePage {

    @FindBy(id = "header-container")
    public WebElement header;

    @FindBy(id = "search-text")
    public WebElement searchInput;

    @FindBy(id = "main-category-choose-label")
    public WebElement category;

    @FindBy(id = "param_subcat")
    public WebElement brandCar;

    @FindBy(css = "#param_price .filter-item-from")
    public WebElement priceFrom;



    @FindBy(css = "#param_price .filter-item-to")
    public WebElement priceTo;


}



