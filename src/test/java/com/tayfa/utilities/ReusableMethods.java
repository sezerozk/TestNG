package com.tayfa.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ReusableMethods {

    public static void sleep (int miliseconds){
        try {
            Thread.sleep(miliseconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<WebElement> getBasliklar(){
        return Driver.getDriver().findElements(By.xpath("(//table)[1]//th"));
        //Burada findElements'in buldugu elementleri liste seklinde dondurdugunu unutmamak gerek.
    }

    public static List<WebElement> getSatirlar(){
        return Driver.getDriver().findElements(By.xpath("(//table)[1]//tr"));
    }

    public static List<WebElement> getTumHucreler(){
        return  Driver.getDriver().findElements(By.xpath("(//table)[1]//tr/td"));
    }

    public static List<WebElement> getSatirdakiHucreler(int satir){
        return Driver.getDriver().findElements(By.xpath("(//table)[1]//tr["+satir+"]"));
        //Burada "" icerisine yazilmis olan bir ifadenin ikinci bir "" isareti ve + isareti yardimiyla
        // tipki "" icerisinden cikarilmis gibi algilandigini gormus olduk.
    }

    public static WebElement getNoktasal(int satir, int sutun){
        return Driver.getDriver().findElement(By.xpath("(//table)[1]//tr["+satir+"]/td["+sutun+"]"));
    }

}
