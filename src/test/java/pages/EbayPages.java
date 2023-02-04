package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class EbayPages {

    public EbayPages(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//input[@class='gh-tb ui-autocomplete-input']")
    public WebElement searchBox;

    @FindBy(xpath = "(//span[@class='BOLD'])[12]")
    public WebElement resultnumber;

    @FindBy(xpath = "(//*[@class='s-item__image-wrapper image-treatment'])[2]")
    public WebElement ilkCikanAramaSonucu;

    @FindBy(xpath = "//*[text()='Buy It Now']")
    public WebElement buttonBuyItNow;

    @FindBy(xpath = "//*[@data-testid='x-about-this-seller']")
    public WebElement sellerInformation;

    @FindBy(xpath = "(//*[@class='ux-labels-values__values col-9'])[5]")
    public WebElement paymentOptions;

    @FindBy(id="mainImgHldr")
    public WebElement urunphoto;

    @FindBy(xpath = "//*[text()='Shipping, returns & payments']")
    public WebElement shippng_returns_payments;

    @FindBy(id="shCountry")
    public WebElement dropdownCountry;
}
