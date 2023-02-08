@wip
Feature: Amazonda aranan urunu ve bir takim ozelliklerini gorebilmeliyim

    Background: Arama yapilana kadar yapilacak islemler

      Given Kullanici amazon anasayfaya gider
      Then Amazon anasayfada oldugunu test eder
      And arama kutusuna "aranacakUrun" yazip aratir

    Scenario: Urun aramasinda cikan sonuc sayisi test edilebilmeli
    Given cikan sonuc sayisinin "sayi" den fazla oldugunu test eder


    Scenario: Aranan urunun yeni sayfada acildigi ve ilgili butonun gorundugu test edilir
    Given cikan ilk sonuca tiklar
    And  Sonucun acildigini gorur ve "ilgiliButon" gorundugunu test eder


  Scenario:Aranan urunun sayfasinda urun adi, ratingi, photo ile ilgili testler yapilir
    Given cikan ilk sonuca tiklar
    And urunun adinin, ratinginin, urun fotosunun gorunur oldugunu test eder


  Scenario: Aranan urunun shipping detaylari test edilir
    Given cikan ilk sonuca tiklar
    And acilan sayfada yer alan shipping details yazisina tiklar
    And shipping Details bilgilerinin gorundugunu test eder
