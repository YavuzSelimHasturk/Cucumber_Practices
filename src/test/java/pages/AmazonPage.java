package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AmazonPage {

    public AmazonPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "twotabsearchtextbox")
    public WebElement searchBox;

    @FindBy(xpath = "(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]")
    public WebElement resultnumber;

    @FindBy(xpath = "(//*[@class='a-size-medium a-color-base a-text-normal'])[1]")
    public WebElement ilkCikanAramaSonucu;

    @FindBy(xpath = "(//*[@id='submit.buy-now-announce'])")
    public WebElement buttonBuyNow;

    @FindBy(xpath = "(//*[@id='productTitle'])[1]")
    public WebElement urunAdi;

    @FindBy(xpath = "(//*[@class='a-icon a-icon-star a-star-4-5'])[1]")
    public WebElement ratingSection;

    @FindBy(xpath = "(//*[@id='imgTagWrapperId'])[1]")
    public WebElement urunPhoto;

    @FindBy(xpath = "(//*[text()=' Details '])[4]")
    public WebElement labelShippingDetails;

    @FindBy(xpath = "(//*[@class='a-popover a-popover-no-header a-declarative a-arrow-bottom'])[1]")
    public WebElement sectionShippingDetails;
}
