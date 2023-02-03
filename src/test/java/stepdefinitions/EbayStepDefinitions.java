package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.EbayPages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class EbayStepDefinitions {

    EbayPages ebayPages = new EbayPages();
    @Given("Kullanici ebay anasayfaya gider")
    public void kullanici_ebay_anasayfaya_gider() {
        Driver.getDriver().get(ConfigReader.getProperty("ebayUrl"));
    }

    @When("arama kutusuna {string} yazip aratir")
    public void aramaKutusunaYazipAratir(String aranacakUrunIsmi) {
        ebayPages.searchBox.sendKeys(aranacakUrunIsmi+ Keys.ENTER);

    }

    @Then("Ebay anasayfada oldugunu test eder")
    public void ebayAnasayfadaOldugunuTestEder() {
        String expectedEbayUrl = "ebay.com";
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains(expectedEbayUrl));
    }

    @And("cikan sonuc sayisinin {int} den fazla oldugunu test eder")
    public void cikanSonucSayisininDenFazlaOldugunuTestEder(int sayi) {
        int sonucSayisi = Integer.parseInt(ebayPages.resultnumber.getText());

        Assert.assertTrue(sonucSayisi>sayi);

    }

    @And("sayfayi kapatir")
    public void sayfayiKapatir() {
        Driver.closeDriver();
    }

    @Then("cikan ilk sonuca tiklar")
    public void cikanIlkSonucaTiklar() {
        ebayPages.ilkCikanAramaSonucu.click();
    }

    @And("Sonucun yeni sayfada acildigini gorur ve urun fiyatinin $ cinsinden oldugunu test eder")
    public void sonucunYeniSayfadaAcildiginiGorurVeUrunFiyatinin$CinsindenOldugunuTestEder() {

        String hedefTitle= "Xiaomi Redmi Note 9 128GB";

        ReusableMethods.switchToWindow(hedefTitle);
        Assert.assertTrue(Driver.getDriver().getTitle().contains(hedefTitle));

        Assert.assertTrue(ebayPages.urunFiyatTuru.getText().contains("$"));
    }
}
