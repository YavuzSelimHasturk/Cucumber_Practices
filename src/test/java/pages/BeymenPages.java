package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class BeymenPages {

    public BeymenPages()   {
        PageFactory.initElements(Driver.getDriver(),this);;
    }

    @FindBy(xpath = "//button[@id='onetrust-accept-btn-handler']")
    public WebElement cerezKabul;

    @FindBy(id="genderManButton")
    public WebElement genderManButton;

    @FindBy(xpath = "//input[@aria-controls='3-suggestions']")
    public WebElement searchbox;

    @FindBy(xpath = "(//*[@class='m-productCard__photo'])[1]")
    public WebElement firstProduct;
}
