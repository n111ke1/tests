package Pages;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;





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

@FindBy(id = "cityField")
    public static WebElement city;


    public BasePage() {
    }
}



