package com.tayfa.tests;

import com.tayfa.utilities.Driver;
import com.tayfa.utilities.ReusableMethods;
import org.testng.annotations.Test;


public class GoogleAramaTest {

    //TestNG ile calisilirken testler method icersinde gerceklestiriliyor.
@Test
    public void aramaTesti(){
        Driver.getDriver().get("https://www.google.com");

        ReusableMethods.sleep(3000);

        String title = Driver.getDriver().getTitle();
        System.out.println(title);

    //navigate().to=> tipki get methodu gibi istedigimiz sayfaya gitmemizi sagliyor. Arada detay bir fark var.
    // navigate().back()=> Bir onceki sayfaya goturur.
    // navigate().forward()=> Geri geldigimiz sayfaya goturur.
    // navigate().refresh()=> Sayfayi yeniler.

    Driver.getDriver().navigate().to("https://www.amazon.com");

    String titleAmazon = Driver.getDriver().getTitle();
    System.out.println(titleAmazon);

    ReusableMethods.sleep(3000);

    Driver.getDriver().navigate().back();

    ReusableMethods.sleep(3000);

    Driver.getDriver().navigate().forward();

    ReusableMethods.sleep(2000);

    //navigate kullandigimiz zaman bir sayfa gecmisi ya da cerez olmuyor. get methodunu kullandigimiz zaman
    // sifir'dan bir sayfa aciyoruz.

    Driver.getDriver().quit();
//  Driver.closeDriver();
    //driver' i kapatmak icin quit ve close isimlerinde iki farkli method var.
    // Quit tum tarayiciyi kapatirken close sadece acik sekmeyi kapatiyor.
    }


}
