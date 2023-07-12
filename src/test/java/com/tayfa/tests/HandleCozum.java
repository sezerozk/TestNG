package com.tayfa.tests;

import com.tayfa.utilities.Driver;
import com.tayfa.utilities.ReusableMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.Set;

public class HandleCozum {

    @Test
    public void test() {
        //Mehmet Ali abinin cozumu==>
        /*
        getWindowHandle     ==>1 tane string
        getWindowHandle o an uzerinde bulunulan sayfanin handle degerini getiriyor.
        getWindowHandles    ==> icerisinde String data turunde veriler barindiran bir set-kume donduruyor
        getWindowHandles o sirada acik olan tum sayfalarin handle degerlerini getiyor
         */
        Driver.getDriver().get("https://www.w3schools.com/html/");
        String window1 = Driver.getDriver().getWindowHandle();
        System.out.println("w3s " + window1);
        ReusableMethods.sleep(2000);
        WebElement accept = Driver.getDriver().findElement(By.id("accept-choices"));
        accept.click();
        ReusableMethods.sleep(2000);
        WebElement facebook = Driver.getDriver().findElement(By.xpath("//div//a[@title = 'Facebook']"));
        facebook.click();

        String face = Driver.getDriver().getWindowHandle();
        System.out.println(face);


        ReusableMethods.sleep(3000);
        //butun windowlari aldik
        Set<String> allWindows = Driver.getDriver().getWindowHandles();
        System.out.println("allWindows: " + allWindows);

        for (String eachWindow : allWindows) {
            //window1 => w3s window
            //aranan window (aktiv olan w3s) aktif olan degilse if calistir aranani aktif et
            if (!eachWindow.equals(window1)) {
                Driver.getDriver().switchTo().window(eachWindow);
                System.out.println("w3s " + eachWindow);
            }
        }
        ReusableMethods.sleep(5000);
        WebElement autoriser = Driver.getDriver().findElement(By.xpath("(//div[@class='x9f619 x1n2onr6 x1ja2u2z" +
                " x78zum5 xdt5ytf x193iq5w xeuugli x1iyjqo2 xs83m0k x150jy0e x1e558r4 xjkvuk6 x1iorvi4 xdl72j9'])[2]"));
        autoriser.click();

        /*
        ONEMLI NOT: Burada suan cok dikkat edilmesi gerek. W3school sayfasinda calisirken oradaki facebook
        button una tikliyoruz ve ekrande ikinci bir pencere olarak facebook penceresi aciliyor. Fakat driver'imiz
        hala w3school sayfasinda oldugundan facebook penceresinde aradigimiz elementi bulamiyoruz ya da getWindowHandle
        methoddunu kullandigimizda hala driver w3school sayfasindaa oldugundan w3school sayfasinin id sini getiriyor.
        Bu sebeple driver'i swithTo().window() methodu ile calismak istedigimiz sayfaya yonlendirmemiz gerek.
         */





//        String str = Driver.getDriver().getWindowHandle();
//        Set<String> liste = Driver.getDriver().getWindowHandles();
//        System.out.println(str);
//        System.out.println(liste);

//        ReusableMethods.sleep(5000);
//        Driver.getDriver().switchTo().window(w3schoolHandle);
//        ReusableMethods.sleep(2000);
//        Driver.getDriver().switchTo().window(facebookHandle);

        //acik olan browser kapat
        Driver.closeDriver();
    }
}