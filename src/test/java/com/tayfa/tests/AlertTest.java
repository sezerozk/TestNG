package com.tayfa.tests;

import com.tayfa.utilities.Driver;
import com.tayfa.utilities.ReusableMethods;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class AlertTest {


    @Test
    public void test(){
        /*
        ALERT ISLEMLERI;
        Eger bir sayfada javaScript ile olusturulmus bir alert varsa acilan alert
        penceresini kapatmadan sayfada baska bir islem yapilamaz. Ayrica axilan pencereyi
        inspect ile incelemek de mumkun olmaz. Ancak alert html ile olusturulmus
        olursa sayfada baskaca islemler yapmak da mumkun olur.
        Driver.getDriver().switchTo().==>Buradan sonra cikan secenekler arasinda alert, window
        ya da frame seceneklerden birisi secilebiliyor. Frame'den web sayfasina geri donmek icin defaultContent
        secilebilir. Burada alert dedeigmiz zaman acik olan alert e gecis yapabiliyoruz.
        Alert denilen bu yapi esasen bir interface ve icerisinde 4 tane method barindiriyor. Bunlar;
        dismiss()               ==> iptal et -cancel
        accept()                ==> kabul etmek icin
        getText()               ==> alertin icerdigi yaziyi almak icin
        sendKeys(String var1)   ==> alerte yazi gondermek icin
         */
        Driver.getDriver().get("https://www.tutorialsteacher.com/codeeditor?cid=js-1");
        ReusableMethods.sleep(2000);
        WebElement autoriser = Driver.getDriver().findElement(By.xpath("//button[@id='ez-accept-all']"));
        autoriser.click();
        ReusableMethods.sleep(2000);
        Driver.getDriver().navigate().refresh();
        ReusableMethods.sleep(3000);
        Driver.getDriver().navigate().refresh();

        int size = Driver.getDriver().findElements(By.id("iframe")).size();
        Driver.getDriver().switchTo().frame(0);

        WebElement displayMessages = Driver.getDriver().findElement(By.xpath("//button"));
        displayMessages.click();
        Alert alrt = Driver.getDriver().switchTo().alert();;
        ReusableMethods.sleep(3000);
        System.out.println(alrt.getText());
        Driver.getDriver().switchTo().alert().accept();
        ReusableMethods.sleep(1000);
        System.out.println(alrt.getText());
        Driver.getDriver().switchTo().alert().accept();
        ReusableMethods.sleep(1000);
        System.out.println(alrt.getText());
        Driver.getDriver().switchTo().alert().accept();
        ReusableMethods.sleep(1000);
        System.out.println(alrt.getText());
        Driver.getDriver().switchTo().alert().accept();
        ReusableMethods.sleep(2000);
        WebElement homeLinki = Driver.getDriver().findElement(By.xpath("//a[@title='TutorialsTeacher.com Home']"));
        ReusableMethods.sleep(2000);


        homeLinki.click();

    }

    @Test
    public void test1(){
        Driver.getDriver().get("https://chercher.tech/practice/practice-pop-ups-selenium-webdriver");

        WebElement alerts = Driver.getDriver().findElement(By.xpath("//div//input[@name='alert']"));

        alerts.click();

        //Driver.getDriver().switchTo().alert().accept(); bu sekilde alerti kabul edecegimiz gibi
        // asagidaki gibi bir kullanim da mumkundur.

        Alert alert = Driver.getDriver().switchTo().alert();
        ReusableMethods.sleep(2000);
        System.out.println(alert.getText());//I am alert
        ReusableMethods.sleep(2000);
        alert.accept();

        WebElement confirmationBox = Driver.getDriver().findElement(By.xpath("//div//input[2]"));

        confirmationBox.click();
        ReusableMethods.sleep(2000);
        System.out.println(alert.getText());//I am confirm
        ReusableMethods.sleep(2000);
        alert.accept();
        ReusableMethods.sleep(2000);

        Driver.getDriver().quit();


    }
}
