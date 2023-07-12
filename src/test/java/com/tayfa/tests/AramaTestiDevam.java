package com.tayfa.tests;

import com.tayfa.pages.AmazonPage;
import com.tayfa.utilities.Driver;
import com.tayfa.utilities.ReusableMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class AramaTestiDevam {

    @Test
    public void webElement() {
        AmazonPage page = new AmazonPage();
        Driver.getDriver().get("https://www.amazon.com");
//        WebElement aramaKutusu = Driver.getDriver().findElement(By.id("twotabsearchtextbox"));
        WebElement aramaKutusu = page.aramaKutusu;//Burada daha once bu sayfada buldugumuz arala kutusu webelemntini
        //AmazonPage class'indan olusturdgumuz nesne kanaliyla bulduk. Bu sekilde calismak daha verimli ve daha
        //profesyonel ve bu sekilde calismaya Page object model deniliyor.
        aramaKutusu.sendKeys("macbook pro" + Keys.ENTER);//sendKeys methodunu yazi gondermek icin kullaniyoruz

        ReusableMethods.sleep(3000);

        Driver.getDriver().navigate().to("https://www.amazon.com/Apple-MacBook-16-inch-512GB-Renewed/dp/B09P43P66P/ref=sr_1_4?crid=37VOTIK03VXI3&keywords=macbook%2Bpro&qid=1684404335&sprefix=macbook%2Bpro%2B%2Caps%2C165&sr=8-4&th=1");
        WebElement cevaplananSorular = Driver.getDriver().findElement(By.id("ask_feature_div"));
//        WebElement cevaplananSorular = Driver.getDriver().findElement(By.className("a-size-base"));
        WebElement cevaplananSorular1 = Driver.getDriver().findElement(By.partialLinkText("19 answered questions"));
        System.out.println(cevaplananSorular.getText());//getText methodu ile webelementin icerdigi metini string olarak
        //aliyoruz
        System.out.println(cevaplananSorular1.getText());

        WebElement baslik = Driver.getDriver().findElement(By.tagName("h1"));
        System.out.println(baslik.getText());

        List<WebElement> linkler = Driver.getDriver().findElements(By.tagName("a"));//findElements o sayfadaki aranan
        // nitelikteki tum elementleri liste seklinde
        //bize donduruyor.
        for (WebElement element : linkler
        ) {
            System.out.println(element.getText());
        }
    }
     /*
        OZET
        Selenium'da kullanabildigimiz 8 farkli locator var.
        1. id
        2. name
        3. className
        4. tagName
        5. linkText            (a elementi)
        6. partialLinkText     (a elementi)
        7. xpath               (tum elementler)
        8. cssSelector         (css degerleri)

        Inceleme bolumunde ctrl+f ile arama yapildigi zaman(CSS Selector ile arama
        yapilacaksa) id degeri ile arama yapilacaksa
        id degerinden once # ifadesi class degeri ile arama yapilacaksa class degerinden once . ifadesi kullanilir.
        CSS selector ile arama yaparken eger tag name ile arama yapiliyorsa tag name en basa yazilmak zorunda. Onun
        disinda siralama onemli degil.

        <div  class="icerik">
            <span class="yazi">
                Selamlar
            </span>
        </div>
        cssSelector("span")            ==>tag name ile arama
        cssSelector("div")             ==>distaki elemeentin tag name i ile arama
        cssSelector("span.yazi")       ==>tag name ve class degeri ile arama
        cssSelector(".yazi .icerik")   ==>elementin class degeri  ve distaki elementin class degeri ile arama bunu
                                          yapabilmek icin iki class degeri arasinda bir BOSLUK olmasi gerektigi unutulmamali.
                                          Bu durum class'larda bu sekilde olmakla birlikte tagName ile arama yaparken bosluk
                                          koyulmasi aranan tagNameler arasinda cocuk ebeveyn iliskisi oldugunu degil
                                          sonra yazilan tagNAme'in once yazilan tagNAme icerisinde yer aldiginin gostergesi
                                          oluyor. Ornegin:
        cssSelector("div p")           ==>Burada div taginin icerisinde yer alan p elementlerini aramis oluyoruz.
        cssSelector("div>p")           ==>Bu sekilde yazildiginda parent'i div olan p elementlerini aramis oluyoruz.
        cssSelector("div+p")           ==>Bu sekilde yazildiginda cocuk ebeveyn iliskisi olmamakla birlikte div elemeentinin
                                          hemen yaninda yer alan bir p elementi aramis oluyoruz.
        cssSelector("div span")        ==>parent elementin tag name i div child elementin tag nami span olan element aramasi
        cssSelector("div.icerik span.yazi")
        cssSelector'leri incelemek icin su linke gidilebilir
        https://www.w3schools.com/cssref/css_selectors.php
        Goruldugu uzere cssSelector ile neredeyse tum webElement'leri bulabiliyoruz. Ve fakat uygulamada
        cssSelector genellikle class degerleri icerisinde arama yapildigi zamanlarda kullaniliyor. Diger elementlerin
        bulunmazi icin genellikle xpath kullaniliyor.

       ORNEK:
       <a class="link google"
       href="https://google.com">
        google
      </a>

       Eger bir elementin birden fazla class degeri varsa bu webelemnti class degeri ile bulamiyoruz.
       Burada da link ve google seklinde iki farkli class degeri oldugu icin bu webelementi classname locator'ini
       kullanarak bulamayiz. Ancak cssSelector'le su sekilde bulabiliriz:
       cssSelector(".link.google")
       div>p seklinde yapilacak bir arama ile parent'i div olan tum p webelementlerini bulmamizi saglayacaktir
       .sidesection>h4>a ==> Burada class degeri sidesection olan child'i h4 ve onun da child'i a olan bir
       webelement bulmus olduk.

       xpath:
       ***Bir array gibi kullanilabiliyor.
       Ornegin;
       (//a[@href="/colors/colors_picker.asp"])[2] ===> Burada xpath ile yaptigimiz arada arana kriterlere uygun
       iki farkli sonuc cikti ve cikan bu sonuclar icersinde en sona yazilan indeks degeri ile gecis yapabiliyoruz.
       Xpath'in cssSelector'a gore avantajli oldugu noktalardan birisi bu.
        //h4/a    ====> Burada xpath ile sunu demis oluyoruz HTML kodlari icersinde h4'u bul ve onun icerisinde
        a elementini bul. Yani ust soydan alt soya ilerliyoruz.
        //div[@class="w3-col l2 m12"]/div[3]/h4/a ===> Burada class degerini bildigimiz bir div webelementinden
        baslamak uzere yukarida asagiya aradigimiz webelemente ulasiyoruz.
        Xpath ile parent'dan child'a ulasmak mumkun oldugu gibi child'dan paretn'a ulasmak da mumkun.
        Bunun icin su yazim kurali uygulaniyor"/.." slash isaretinden sonra iki nokta koyuldugu zaman
        bulunan webelementin paretnt'ina gecilebiliyor.
        Ayrica / ile ust soydan alt soya geciyorken // kullanildigi zaman dededen toruna ulasabiliyoruz.Daha dogrusu
        o elementin icerisnde yer alan tum elementler icerisinde arama yapmis oluyoruz. Torunun torunu da olabilir
        aradigimiz element.
       ***webelementin icerdigi yaziya gore elementi bulmamiza yardimci oluyor
       //tagName[@attribute="deger"]
       *****Xpath ozel durumlar:
       //tagName[@attribute="deger"]    ==>Normal kullanim
       //tagName[.="deger"]             ==>Burada tagNAmeéi bilenen bir webelementin herhangi bir attribute'nun degerini
       vererek arama yapiyoruz.
       //tagName[@attribute1="deger1" or/and @attribute2="deger2"]
       // *[.="yazi"]                    ==> Burada tagnami herhangi bir tag olan ve herhangi bir attribute'unun icersinde
       yazi seklinde bir ifade oan webelementi ariyoruz. Goruldugu uzere tagnami ya da attribute'u bilinmese dahi
       icerdigi deger bilinen webelement xpath ile bulunabiliyor.
       // *[contains(text(),"hamza")]    ==>Burada aranan elementin ismi dahi verilmeden sadece icerdigi yazilara
       bakilmasini sagliyoruz. Ornekte hamza ifadesini iceren bir webelement aramasi yapiyoruz.Esasen //'dan sonra
       boluk olmaksizin * konulmasi gerekiyor fakat yorum satiri isareti ile karistigi icin bosluk biraktim.
       <table>
            <thead>
                <tr>
                    <th>...</th>
                    <th>...</th>
                    <th>...</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>...</td>
                    <td>...</td>
                    <td>...</td>
                </tr>
                 <tr>
                    <td>...</td>
                    <td>...</td>
                    <td>...</td>
                </tr>
            </tbody>
       </table>

      ==>Burada html de table tagname ile olusturulmus bir tablonun yapisini goruyoruz. Kisaca aciklamak gerekirse
      html de tablolar table tagi ya da baska taglarla olusturulabiliyor. Burada table tagname i ile olusuturulan
      tablolarin yapisini goruyoruz. Tablo icersindeki bir webelement arandigi zaman bu yapiyi bilmek aranan elementin
      bulunabilmesi icin gerekli. Ilk olarak <thead> kismi tablodaki basliklar icin kullaniliyor ancek her zaman bu sekilde
      kullanilmiyor kimi zaman direk <tbody> kisminin icerisine konulabiliyor yine de <td> tagi ile degil <th> tagi ile
      konuluyor. <tr> ifadesi tablodaki satirlara <td> ifadesi tablodaki sutunlara karsilik geliyor.



      */





}

















