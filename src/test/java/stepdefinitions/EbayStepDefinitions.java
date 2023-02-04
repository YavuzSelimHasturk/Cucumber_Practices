package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.EbayPages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class EbayStepDefinitions {

    EbayPages ebayPages = new EbayPages();
    Actions actions = new Actions(Driver.getDriver());
    @Given("Kullanici ebay anasayfaya gider")
    public void kullanici_ebay_anasayfaya_gider() {
        Driver.getDriver().get(ConfigReader.getProperty("ebayUrl"));
    }

    @When("arama kutusuna {string} yazip aratir")
    public void aramaKutusunaYazipAratir(String aranacakUrunIsmi) {
        aranacakUrunIsmi = ConfigReader.getProperty("aranacakUrun");

        ebayPages.searchBox.sendKeys(aranacakUrunIsmi+ Keys.ENTER);

    }

    @Then("Ebay anasayfada oldugunu test eder")
    public void ebayAnasayfadaOldugunuTestEder() {
        String expectedEbayUrl = "ebay.com";
        assertTrue(Driver.getDriver().getCurrentUrl().contains(expectedEbayUrl));
    }


    @And("sayfayi kapatir")
    public void sayfayiKapatir() {
        Driver.quitDriver();
    }

    @Then("cikan ilk sonuca tiklar")
    public void cikanIlkSonucaTiklar() {
        ebayPages.ilkCikanAramaSonucu.click();
    }


    @And("Sonucun yeni sayfada acildigini gorur ve {string} gorundugunu test eder")
    public void sonucunYeniSayfadaAcildiginiGorurVeGorundugunuTestEder(String gorunenYazi) {
        gorunenYazi = ConfigReader.getProperty("gorunenYazi");

        String origin = Driver.getDriver().getWindowHandle();

        Assert.assertNotSame(Driver.getDriver().getWindowHandle(), origin);

        ReusableMethods.bekle(3);

        assertEquals(gorunenYazi,ebayPages.buttonBuyItNow.getText());

    }

    @And("urunun Seller information, odeme yontemlerinin, urun fotosunun gorunur oldugunu test eder")
    public void urununSaticiSellerInformationOdemeYontemlerininUrunFotosununGorunurOldugunuTestEder() {

        ReusableMethods.bekle(3);
        assertTrue(ebayPages.sellerInformation.isDisplayed());

        ReusableMethods.bekle(2);
        actions.moveToElement(ebayPages.urunphoto).perform();
        assertTrue(ebayPages.urunphoto.isDisplayed());

        ReusableMethods.bekle(3);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        assertTrue(ebayPages.paymentOptions.isDisplayed());
    }

    @And("urun hakkinda {string} bolumune gider")
    public void urunHakkindaBolumuneGider(String aranacakBolum) {
        aranacakBolum= "Shipping,returns & payments";
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.scrollToElement(ebayPages.shippng_returns_payments).perform();

        ebayPages.shippng_returns_payments.click();

    }

    @And("Shipping country olarak {string} secilebildigini test eder")
    public void shippingCountryOlarakSecilebildiginiTestEder(String secilecekUlke) {
        secilecekUlke = ConfigReader.getProperty("secilecekUlke");
        Select select = new Select(ebayPages.dropdownCountry);
        select.selectByVisibleText(secilecekUlke);
        ReusableMethods.bekle(3);

        String secilenUlke = ebayPages.dropdownCountry.getText();

        assertEquals(secilenUlke,secilecekUlke);

    }

    @Given("cikan sonuc sayisinin {string} den fazla oldugunu test eder")
    public void cikanSonucSayisininDenFazlaOldugunuTestEder(String sayi) {

        int girilenSayi = Integer.parseInt(ConfigReader.getProperty("sayi"));
        int sonucSayisi = Integer.parseInt(ebayPages.resultnumber.getText());

        assertTrue(sonucSayisi>girilenSayi);

    }
}
