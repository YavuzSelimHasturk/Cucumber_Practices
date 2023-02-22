package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.Keys;
import pages.BeymenPages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import static org.junit.Assert.*;

public class BeymenStepDefinitions {

    BeymenPages beymen = new BeymenPages();

    @Given("kullanici Beymen sayfasina gider")
    public void kullanici_beymen_sayfasina_gider() {

        Driver.getDriver().get(ConfigReader.getProperty("beymenUrl"));
    }
    @Then("Cerezleri kabul eder ve cinsiyet secimini yapar")
    public void cerezleriKabulEderVeCinsiyetSeciminiYapar() {

        ReusableMethods.bekle(3);
        beymen.cerezKabul.click();
        ReusableMethods.bekle(2);
        beymen.genderManButton.click();

    }
    @Given("Beymen anasayfasinin acildigini kontrol eder")
    public void beymen_anasayfasinin_acildigini_kontrol_eder() {
      String str= "Beymen";

      assertTrue(Driver.getDriver().getTitle().contains(str));
    }
    @Given("Arama kutucuguna {string} kelimesini girer ve aratir")
    public void arama_kutucuguna_kelimesini_girer_ve_aratir(String aranacakUrun) {
        aranacakUrun = ConfigReader.getProperty("aranacakBeymen");
        beymen.searchbox.sendKeys(aranacakUrun+ Keys.ENTER);
    }
    @Then("Sonuca gore sergilenen urunlerden rastgele bir urun secer")
    public void sonuca_gore_sergilenen_urunlerden_rastgele_bir_urun_secer() {
        beymen.firstProduct.click();
    }
    @Then("Secilen urunun urun bilgisi ve tutar bilgisini txt dosyasina yazdirir")
    public void secilen_urunun_urun_bilgisi_ve_tutar_bilgisini_txt_dosyasina_yazdirir() {

    }
    @Then("Secilen urunu sepete ekler")
    public void secilen_urunu_sepete_ekler() {

    }
    @Then("Urun sayfasindaki fiyat ile sepette yer alan urunun fiyatinin dogrulugunu karsilastirir")
    public void urun_sayfasindaki_fiyat_ile_sepette_yer_alan_urunun_fiyatinin_dogrulugunu_karsilastirir() {

    }
    @Then("Adet sayisini arttirarak urun adedinin {int} oldugunu dogrular")
    public void adet_sayisini_arttirarak_urun_adedinin_oldugunu_dogrular(Integer int1) {

    }
    @Then("Urunu sepetten silerek sepetin bos oldugunu kontrol eder")
    public void urunu_sepetten_silerek_sepetin_bos_oldugunu_kontrol_eder() {


    }



}
