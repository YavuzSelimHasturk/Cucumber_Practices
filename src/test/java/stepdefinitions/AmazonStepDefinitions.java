package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AmazonStepDefinitions {

    AmazonPage amazonPage = new AmazonPage();
    Actions actions = new Actions(Driver.getDriver());
    @Given("Kullanici amazon anasayfaya gider")
    public void kullanici_amazon_anasayfaya_gider() {
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
    }

    @When("arama kutusuna {string} yazip aratir")
    public void aramaKutusunaYazipAratir(String aranacakUrunIsmi) {
        aranacakUrunIsmi = ConfigReader.getProperty("aranacakUrun");

        amazonPage.searchBox.sendKeys(aranacakUrunIsmi+ Keys.ENTER);

    }

    @Then("Amazon anasayfada oldugunu test eder")
    public void amazonAnasayfadaOldugunuTestEder() {
        String expectedAmazonUrl = "amazon.com";
        assertTrue(Driver.getDriver().getCurrentUrl().contains(expectedAmazonUrl));
    }


    @And("sayfayi kapatir")
    public void sayfayiKapatir() {
        Driver.quitDriver();
    }

    @Then("cikan ilk sonuca tiklar")
    public void cikanIlkSonucaTiklar() {
        amazonPage.ilkCikanAramaSonucu.click();
    }


    @And("Sonucun acildigini gorur ve {string} gorundugunu test eder")
    public void AcildiginiGorurVeGorundugunuTestEder(String gorunenYazi) {
        gorunenYazi = ConfigReader.getProperty("gorunenYazi");

        ReusableMethods.bekle(2);
        assertEquals(gorunenYazi,amazonPage.buttonBuyNow.getText());

    }

    





    @Given("cikan sonuc sayisinin {string} den fazla oldugunu test eder")
    public void cikanSonucSayisininDenFazlaOldugunuTestEder(String sayi) {

        int girilenSayi = Integer.parseInt(ConfigReader.getProperty("sayi"));
        String[] sonucSayisi = amazonPage.resultnumber.getText().split(" ");
        System.out.println(Arrays.toString(sonucSayisi));
        int kalanSayi = Integer.parseInt(sonucSayisi[2]);

        assertTrue(kalanSayi>girilenSayi);

    }

    @And("urunun adinin, ratinginin, urun fotosunun gorunur oldugunu test eder")
    public void urununAdininRatingininUrunfotosununGorunurOldugunuTestEder() {
        ReusableMethods.bekle(2);
        Assert.assertTrue(amazonPage.urunAdi.isDisplayed());
        ReusableMethods.bekle(2);
        Assert.assertTrue(amazonPage.ratingSection.isDisplayed());
        ReusableMethods.bekle(2);
        Assert.assertTrue(amazonPage.urunPhoto.isDisplayed());

    }

    @And("acilan sayfada yer alan shipping details yazisina tiklar")
    public void acilanSayfadaYerAlanShippingDetailsYazisinaTiklar() {
        ReusableMethods.bekle(2);
        amazonPage.labelShippingDetails.click();
        ReusableMethods.bekle(2);
    }

    @And("shipping Details bilgilerinin gorundugunu test eder")
    public void shippingDetailsBilgilerininGorundugunuTestEder() {
        assertTrue(amazonPage.sectionShippingDetails.isDisplayed());
    }

    @When("arama kutusuna listedeki {string} yazip aratir")
    public void aramaKutusunalistedekiYazipAratir(String aranacakUrunIsmi) {


        amazonPage.searchBox.sendKeys(aranacakUrunIsmi+ Keys.ENTER);

    }
}
