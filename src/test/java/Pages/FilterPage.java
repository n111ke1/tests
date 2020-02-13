package Pages;

import Helper.ElementActions;
import Helper.ThreadDriver;
import org.junit.Assert;
import org.openqa.selenium.*;
import static java.lang.Integer.*;




public class FilterPage extends BasePage {

    public FilterPage(WebDriver driver) {
        super(driver);
    }


    public FilterPage activateCarBrandField() {
        ElementActions.waitElementPresent(carBrandField);
        carBrandField.click();
        return this;
    }

    public FilterPage checkCarBrandsName() {
        ElementActions.waitElementPresent(carBrandNames.get(10));
        return this;

    }


    public FilterPage setValueFieldPriceTo(String price) {
        ElementActions.waitElementPresent(priceToField);
        priceToField.click();
        priceToFieldInput.sendKeys(price);
        priceToFieldInput.sendKeys(Keys.ENTER);
        return this;
    }

    public FilterPage setValueFieldPriceFrom(String price) {
        ElementActions.waitElementPresent(priceFromField);
        priceFromField.click();
        priceFromFieldInput.sendKeys(price);
        priceFromFieldInput.sendKeys(Keys.ENTER);
        return this;
    }


    public FilterPage checkInputFieldPriceFrom(String price) {
        setValueFieldPriceFrom(price);
        WebElement inputedFromEl = ThreadDriver.getWebDriver().findElement(By.cssSelector(".filter-both-item .option-from"));
        Assert.assertEquals(inputedFromEl.getAttribute("value"), "");
        return this;


    }

    public FilterPage checkInputFieldPriceTo(String price) {
        setValueFieldPriceTo(price);
        WebElement inputedToEl = ThreadDriver.getWebDriver().findElement(By.cssSelector(".filter-both-item .option-to"));
        Assert.assertEquals(inputedToEl.getAttribute("value"), "");
        return this;

    }


    public FilterPage motorMileageFromInput(String forCheck) {
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
        WebElement elSelect = ThreadDriver.getWebDriver()
                .findElement(By.cssSelector("#param_motor_mileage .filter-item:nth-child(2) .suggestinput .search-choose[data-value='" + selectValue + "']"));
        elSelect.click();
        Assert.assertEquals(el.getText(), "до " + selectValue + " км");
        return this;
    }


    public FilterPage checkPriceAfterSort(String priceFrom, String priceTo) {
        setValueFieldPriceFrom(priceFrom);
        WebElement loader = ThreadDriver.getWebDriver().findElement(By.cssSelector("#loader"));
        ElementActions.waitElementDisappear(loader);
        setValueFieldPriceTo(priceTo);
        ElementActions.waitElementDisappear(loader);

        if(emptyResults.isDisplayed()){
            System.out.println(ThreadDriver.getWebDriver().findElement(By.cssSelector("#body-container .content .emptynew .marker")).getText());
        }
        else {
            ElementActions.waitElementsPresents(resultPrices);

            for (WebElement i : resultPrices) {
                String mes = "This test cant working because Olx get in result mix currency of price in $ and in hrn";
                Assert.assertTrue(mes, parseInt(i.getText()) >= parseInt(priceFrom) && parseInt(i.getText()) <= parseInt(priceTo));
            }
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
