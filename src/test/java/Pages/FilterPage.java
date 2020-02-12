package Pages;

import Helper.ElementActions;
import Helper.ThreadDriver;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static java.lang.Integer.*;
import static java.lang.Thread.sleep;

public class FilterPage extends BasePage {

    public FilterPage(WebDriver driver) {
        super(driver);
    }



    @FindBy(id = "param_subcat")
    private WebElement carBrandField;

    @FindBy(css = "#param_subcat .suggestinput li a")
    private List<WebElement> carBrandNames;

    @FindBy(css = ".filter-both-item .price:nth-child(1) .num-input input")
    private WebElement priceFromFieldInput;

    @FindBy(css = ".filter-both-item .price:nth-child(2) .num-input input")
    private WebElement priceToFieldInput;

    @FindBy(css = ".filter-item-transmission_type")
    private WebElement transmissionTypeCheckBox;

    @FindBy(css = ".filter-item-transmission_type .suggestinput [type='checkbox'][data-text='Механическая']")
    private WebElement transmissionTypeMechanichal;

    @FindBy(css = ".filter-both-item .price:nth-child(1) .header")
    private WebElement priceFromField;
    @FindBy(css = ".filter-both-item .price:nth-child(2) .header")
    private WebElement priceToField;


    @FindBy(css = "#param_motor_mileage .filter-item:nth-child(1) input")
    private WebElement motorMileageFromInput;

    @FindBy(css = "#param_motor_mileage .filter-item:nth-child(2) input")
    private WebElement motorMileageToInput;

    @FindBy(css = "#param_motor_mileage .filter-item:nth-child(1)")
    private WebElement motorMileageFrom;

    @FindBy(css = "#param_motor_mileage .filter-item:nth-child(2)")
    private WebElement motorMileageTo;

    @FindBy(css = "#offers_table .price")
    private List<WebElement> resultPrices;


    public FilterPage activateCarBrandField() {
        ElementActions.waitElementPresent(carBrandField);
        carBrandField.click();
        return this;
    }

    public FilterPage checkCarBrandsName() {
        ElementActions.waitElementPresent(carBrandNames.get(10));

        return this;

    }


    public FilterPage inputFieldPriceTo(String price) {
        ElementActions.waitElementPresent(priceToField);
        priceToField.click();
        priceToFieldInput.sendKeys(price);
        priceToFieldInput.sendKeys(Keys.ENTER);

        return this;
    }

    public FilterPage inputFieldPriceFrom(String price) {
        ElementActions.waitElementPresent(priceFromField);
        priceFromField.click();
        priceFromFieldInput.sendKeys(price);
        priceFromFieldInput.sendKeys(Keys.ENTER);

        return this;
    }


    public FilterPage checkInputFieldPriceFrom(String price) {
        inputFieldPriceFrom(price);
        WebElement inputedFromEl = ThreadDriver.getWebDriver().findElement(By.cssSelector(".filter-both-item .option-from"));
        System.out.println(inputedFromEl.getAttribute("value"));
        Assert.assertEquals(inputedFromEl.getAttribute("value"), "");
        return this;


    }

    public FilterPage checkInputFieldPriceTo(String price) {
        inputFieldPriceTo(price);
        WebElement inputedToEl = ThreadDriver.getWebDriver().findElement(By.cssSelector(".filter-both-item .option-to"));
        Assert.assertEquals(inputedToEl.getAttribute("value"), "");
        return this;

    }


    public FilterPage motorMileageFromInput(String forCheck) {
//        WebElement Field = ThreadDriver.getWebDriver().findElement(By.cssSelector("#param_motor_mileage .filter-item:nth-child(1)"));
        WebElement hiddenElement = ThreadDriver.getWebDriver().findElement(By.cssSelector("#param_motor_mileage .filter-item:nth-child(1) .hidden"));

        WebElement buttonSearch = ThreadDriver.getWebDriver().findElement(By.id("search-submit"));
        ElementActions.waitElementPresent(motorMileageFrom);
        motorMileageFrom.click();
        motorMileageFromInput.sendKeys(forCheck);
        ElementActions.moveMouseToElement(buttonSearch);
        ElementActions.waitElementDisappear(hiddenElement);

        Assert.assertEquals(motorMileageFrom.getText(), "от " + forCheck + " км");

        return this;

    }

    public FilterPage motorMileageToInput(String forCheck) {
//        WebElement el = ThreadDriver.getWebDriver().findElement(By.cssSelector("#param_motor_mileage .filter-item:nth-child(2)"));
        WebElement hiddenElement = ThreadDriver.getWebDriver().findElement(By.cssSelector("#param_motor_mileage .filter-item:nth-child(2) .hidden"));

        WebElement buttonToMove = ThreadDriver.getWebDriver().findElement(By.id("search-submit"));
        ElementActions.waitElementPresent(motorMileageTo);
        motorMileageTo.click();
        motorMileageToInput.sendKeys(forCheck);
        ElementActions.moveMouseToElement(buttonToMove);
        ElementActions.waitElementDisappear(hiddenElement);

        Assert.assertEquals(motorMileageTo.getText(), "до " + forCheck + " км");


        return this;

    }


    public FilterPage selectMotorMileageFrom(String selectValue) {
        WebElement el = ThreadDriver.getWebDriver().findElement(By.cssSelector("#param_motor_mileage .filter-item:nth-child(1) .button-from"));
        ElementActions.waitElementPresent(motorMileageFrom);
        motorMileageFrom.click();
        WebElement elSelect = ThreadDriver.getWebDriver().findElement(By.cssSelector("#param_motor_mileage .filter-item:nth-child(1) .suggestinput .search-choose[data-value='" + selectValue + "']"));
        elSelect.click();
        Assert.assertEquals(el.getText(), "от " + selectValue + " км");

        return this;
    }


    public FilterPage selectMotorMileageToSelect(String selectValue) {
        WebElement el = ThreadDriver.getWebDriver().findElement(By.cssSelector("#param_motor_mileage .filter-item:nth-child(2) .button-to"));
        ElementActions.waitElementPresent(motorMileageTo);
        motorMileageTo.click();
        WebElement elSelect = ThreadDriver.getWebDriver().findElement(By.cssSelector("#param_motor_mileage .filter-item:nth-child(2) .suggestinput .search-choose[data-value='" + selectValue + "']"));
        elSelect.click();
        Assert.assertEquals(el.getText(), "до " + selectValue + " км");

        return this;
    }


    public FilterPage checkPriceAfterSort(String priceFrom, String priceTo) {
        inputFieldPriceFrom(priceFrom);
        WebElement loader = ThreadDriver.getWebDriver().findElement(By.cssSelector("#loader"));
        ElementActions.waitElementDisappear(loader);
        inputFieldPriceTo(priceTo);
        ElementActions.waitElementDisappear(loader);
        ElementActions.waitElementsPresents(resultPrices);

        for (WebElement i : resultPrices) {
            String mes = "This test cant working because Olx get in result mix currency of price in $ and in hrn";
            Assert.assertTrue(mes,parseInt(i.getText()) >= parseInt(priceFrom) && parseInt(i.getText()) <= parseInt(priceTo));
        }
        return this;
    }






    public FilterPage checkTransmissionTypeAll(){
    ElementActions.waitElementPresent(transmissionTypeCheckBox);
    transmissionTypeCheckBox.click();
    transmissionTypeCheckBox.findElement(By.id("f-all-filter_enum_transmission_type_45")).isSelected();
    return  this;
}

public FilterPage checkTransmissionTypeAllAfterSelectedAnother(){
    ElementActions.waitElementPresent(transmissionTypeMechanichal);
    transmissionTypeMechanichal.click();
    Assert.assertFalse(transmissionTypeCheckBox.findElement(By.id("f-all-filter_enum_transmission_type_45")).isSelected());

    return this;
}







}
