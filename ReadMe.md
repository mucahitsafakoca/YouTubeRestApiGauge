# Gauge-Test Projesi README Dosyası

Bu proje, [Gauge](https://gauge.org/) ve [Rest-Assured](https://rest-assured.io/) kütüphaneleri kullanılarak API testlerini otomatikleştirmek için Maven tabanlı bir Java projesidir.

## Proje Yapısı

- **specs/**: Bu klasörde Gauge özellik dosyaları bulunur. Özellik dosyaları, test senaryolarını ve adımlarını içerir.
- **src/main/java/**: Proje için Java kaynak dosyalarının bulunduğu klasördür. Bu klasörde, test senaryolarını gerçekleştirmek için gerekli Java sınıfları yer alır.
- **src/test/java/**: Bu klasörde, test senaryolarını ve adımlarını gerçekleştirmek için yardımcı sınıflar ve utiliteler bulunur.
- **pom.xml**: Maven projesinin yapılandırma dosyasıdır. Bağımlılıkları, sürümleri ve proje yapılandırmasını içerir.

## Bağımlılıklar

Proje, aşağıdaki bağımlılıkları kullanır:

- Gauge: Test senaryolarını ve adımlarını tanımlamak için kullanılır.
- Rest-Assured: API testleri için HTTP isteklerini göndermek ve yanıtları kontrol etmek için kullanılır.
- JSON: JSON verileri ile çalışmak için kullanılır.
- TestNG: Testlerin düzenlenmesi ve yürütülmesi için kullanılır.
- AssertJ: Testlerde daha okunabilir ve esnek doğrulama ifadeleri yazmak için kullanılır.
- JUnit Jupiter: Testlerin yürütülmesi için kullanılır.

## Testlerin Çalıştırılması

# YouTube Data API v3 Test Çalışması

Bu proje, belirli senaryoları gerçekleştiren API testlerini içerir.

## Senaryo 1: "witcher" Araması Yapma

- **Senaryo:** "witcher" için channelId ile Arama Yapma
    1. Belirli bir token ile "witcher" için channelId ile bir arama yapılır.
    2. Arama sonuçları alınır ve channelId içeren bir yanıt döner.

## Senaryo 2: "Selenium 101" Araması ve Video Beğenme

- **Senaryo:** "Selenium 101" için Arama ve Video Beğenme
    1. Belirli bir token ile "Selenium 101" için bir arama yapılır.
    2. Arama sonuçları alınır ve bir video seçilir.
    3. Seçilen video beğenilir.
    4. Yorum yapılır.

## Senaryo 3: Kanala Abone Olma ve Abonelikten Çıkma

- **Senaryo:** Belirli bir ID'ye sahip kanala abone olma ve abonelikten çıkma
    1. "UCEvO4Rl-u8EvwRrOfNPgtAQ" ID'sine sahip bir kanala abone olunur.
    2. Abonelik işlemi başarılı bir şekilde gerçekleştirilir.
    3. Daha sonra kanaldan abonelik iptal edilir.

## Test Durumu

Senaryoları test etmek için aşağıdaki adımları içerir:

1. **Senaryo 1 Testi:** "witcher" için channelId ile Arama Yapma
    - API'ye "witcher" için channelId ile bir arama yapılır.
    - Arama sonuçları doğru bir şekilde döner.

2. **Senaryo 2 Testi:** "Selenium 101" için Arama ve Video Beğenme
    - API'ye "Selenium 101" için bir arama yapılır.
    - Bir video seçilir, beğenilir ve yorum yapılır.
    - İşlemler başarıyla gerçekleştirilir.

3. **Senaryo 3 Testi:** Kanala Abone Olma ve Abonelikten Çıkma
    - Belirli bir ID'ye sahip kanala abone olunur ve abonelik işlemi doğrulanır.
    - Abonelik iptali yapılır ve başarıyla sonuçlanır.

## Testleri Çalıştırma


Testleri çalıştırmak için Maven ve Java'nın bilgisayarınızda yüklü olması gerekmektedir. Aşağıdaki komutu kullanarak testleri çalıştırabilirsiniz:

```bash
mvn test
```

Bu komut, Maven aracılığıyla projenin derlenmesini ve testlerin çalıştırılmasını sağlar.

## API DOC
https://developers.google.com/youtube/v3/docs

