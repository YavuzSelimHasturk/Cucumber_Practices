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

    @FindBy(xpath = "(//span[@class='ux-textspans'])[14]")
    public WebElement urunFiyatTuru;
}
