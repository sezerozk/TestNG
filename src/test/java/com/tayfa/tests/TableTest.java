package com.tayfa.tests;

import com.tayfa.pages.W3Schools;
import com.tayfa.utilities.Driver;
import com.tayfa.utilities.ReusableMethods;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class TableTest {

    W3Schools nesne = new W3Schools();
    String url = "https://www.w3schools.com/html/html_tables.asp";
    @Test
    public void tumBasliklar (){

        Driver.getDriver().get(url);
        for (WebElement each:nesne.basliklar
             ) {
            System.out.println(each.getText());
        }

    }

    @Test
    public void tumHucreler(){
        Driver.getDriver().get(url);
        for (WebElement each:nesne.tumHucreler
        ) {
            System.out.println(each.getText());
        }
    }

    @Test
    public void basliklarReusableMethods(){
        Driver.getDriver().get(url);
        List<WebElement> liste = ReusableMethods.getBasliklar();
        for (WebElement each: liste
             ) {
            System.out.println(each.getText());
        }
    }

    @Test
    public void satirlarReusableMethods(){
        Driver.getDriver().get(url);
        List<WebElement> liste = ReusableMethods.getSatirlar();
        for (WebElement each:liste
             ) {
            System.out.println(each.getText());
        }
    }

    @Test
    public void tumHucrelerReusableMethods(){
        Driver.getDriver().get(url);
        List<WebElement> liste = ReusableMethods.getTumHucreler();
        for (WebElement each:liste
        ) {
            System.out.println(each.getText());
        }
    }

    @Test
    public void satiradkiHucrelerReusableMethods(){
        Driver.getDriver().get(url);
        List<WebElement> liste = ReusableMethods.getSatirdakiHucreler(3);
        for (WebElement each:liste
        ) {
            System.out.println(each.getText());
        }
    }

    @Test
    public void istenenNoktakiHucreReusableMethods(){
        Driver.getDriver().get(url);
        WebElement element = ReusableMethods.getNoktasal(6,3);
        System.out.println(element.getText());
    }
    /*
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
