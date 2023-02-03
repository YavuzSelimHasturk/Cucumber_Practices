@wip
Feature: Ebayde aranan urunun bir takim ozelliklerini gorebilmeliyim

  Background: Arama yapilana kadar yapilacak islemler
  Given Kullanici ebay anasayfaya gider
  Then Ebay anasayfada oldugunu test eder



  Scenario:

  Given Kullanici ebay anasayfaya gider
  When arama kutusuna "xiaomi note 9" yazip aratir
  And cikan sonuc sayisinin 50 den fazla oldugunu test eder
  And sayfayi kapatir

  Scenario:

    Given arama kutusuna "xiaomi note 9" yazip aratir
    Then cikan ilk sonuca tiklar
    And  Sonucun yeni sayfada acildigini gorur ve urun fiyatinin $ cinsinden oldugunu test eder
    And sayfayi kapatir

  Scenario:
    Given Kullanici ebay anasayfaya gider
    When arama kutusuna "xiaomi note 9" yazip aratir
    Then cikan ilk sonuca tiklar
    And urunun satici pozitif feedbacklerinin, odeme yontemlerinin, urun fotosunun gorunur oldugunu test eder
    And sayfayi kapatir

  Scenario:
    Given Kullanici ebay anasayfaya gider
    When arama kutusuna "xiaomi note 9" yazip aratir
    Then cikan ilk sonuca tiklar
    And urun hakkinda "shipping,returns&payments" bolumune gider
    And Shipping country olarak Luxembourg in secilebildigini test eder
    And sayfayi kapatir
