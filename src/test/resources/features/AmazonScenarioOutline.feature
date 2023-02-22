Feature: Amazonda urun aratma

  Scenario Outline: Amazonda farkli urunler aratma testi

    * Kullanici amazon anasayfaya gider
    * arama kutusuna listedeki "<aranacak urunler>" yazip aratir
    * sayfayi kapatir


    Examples:
      |aranacak urunler|
      |xiaomi note 9   |
      |logitech mouse  |
      |sony laptop     |


