@wip
Feature: Ebayde aranan urunu ve bir takim ozelliklerini gorebilmeliyim

    Background: Arama yapilana kadar yapilacak islemler
    Given Kullanici ebay anasayfaya gider
    Then Ebay anasayfada oldugunu test eder
    And arama kutusuna "aranacakUrun" yazip aratir

    Scenario: Urun aramasinda cikan sonuc sayisi test edilebilmeli
    Given cikan sonuc sayisinin "sayi" den fazla oldugunu test eder
    And sayfayi kapatir

    Scenario: Aranan urunun yeni sayfada acildigi ve ilgili butonun gorundugu test edilir
    Given cikan ilk sonuca tiklar
    And  Sonucun yeni sayfada acildigini gorur ve "ilgiliButon" gorundugunu test eder
    And sayfayi kapatir

  Scenario:Aranan urunun sayfasinda photo, payment, seller informationla ilgili testler yapilir
    Given cikan ilk sonuca tiklar
    And urunun adinin, ratinginin, urun durumunun gorunur oldugunu test eder
    And sayfayi kapatir

  Scenario: Aranan urunun shipping olarak farkli ulkelere gonderilebildigi test edilir
    Given cikan ilk sonuca tiklar
    And urun hakkinda "shipping,returns&payments" bolumune gider
    And Shipping country olarak "Israel" secilebildigini test eder
    And sayfayi kapatir
