package com.tayfa.tests;

import com.tayfa.utilities.Driver;
import com.tayfa.utilities.ReusableMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.Set;

public class WindowHandlesTest {

    @Test
    public void test(){
        /*
        getWindowHandle     ==>1 tane string
        getWindowHandle o an uzerinde bulunulan sayfanin handle degerini getiriyor.
        getWindowHandles    ==> icerisinde String data turunde veriler barindiran bir set-kume donduruyor
        getWindowHandles o sirada acik olan tum sayfalarin handle degerlerini getiyor
         */
        Driver.getDriver().get("https://www.w3schools.com/html/");
        String w3schoolHandle = Driver.getDriver().getWindowHandle();
        System.out.println("w3s" + w3schoolHandle);
        ReusableMethods.sleep(2000);
        WebElement accept = Driver.getDriver().findElement(By.id("accept-choices"));
        accept.click();
        ReusableMethods.sleep(2000);
        WebElement facebook = Driver.getDriver().findElement(By.xpath("//div//a[@title = 'Facebook']"));

        facebook.click();
        ReusableMethods.sleep(5000);
        WebElement autoriser = Driver.getDriver().findElement(By.xpath("//div[@class='x9f619 x1n2onr6 x1ja2u2z " +
                "x78zum5 xdt5ytf x193iq5w xeuugli x1iyjqo2 xs83m0k x150jy0e x1e558r4 xjkvuk6 x1iorvi4 xdl72j9']"));
        autoriser.click();
        ReusableMethods.sleep(3000);
        String facebookHandle = Driver.getDriver().getWindowHandle();
        System.out.println("face" + facebookHandle);

//        String str = Driver.getDriver().getWindowHandle();
//        Set<String> liste = Driver.getDriver().getWindowHandles();
//        System.out.println(str);
//        System.out.println(liste);

        ReusableMethods.sleep(5000);
        Driver.getDriver().switchTo().window(w3schoolHandle);
        ReusableMethods.sleep(2000);
        Driver.getDriver().switchTo().window(facebookHandle);





    }
}
