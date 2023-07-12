package com.tayfa.excelAutomation;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadExcel {

    @Test
    public void test () throws IOException {
        String dosyaYolu = "src/test/resources/Kitap.xlsx";
        FileInputStream file = new FileInputStream(dosyaYolu);
        //Workbook (excel)dosyaisini okuyalim
        Workbook excel = WorkbookFactory.create(file);

//      //Sheet secimi, tioki array'de oldugu gibi indeks degeri 0' dan basliyor
        Sheet sheet = excel.getSheetAt(0);

        // Satirlar- rows
        Row birinciSatir = sheet.getRow(0);

        //Hucreler-cells

        Cell isim = birinciSatir.getCell(0);
        Cell sayi = birinciSatir.getCell(1);
        Cell kategori = birinciSatir.getCell(2);
//        Cell yorum = birinciSatir.getCell(3);

        System.out.println(isim.toString());
        System.out.println(sayi.toString());
        System.out.println(kategori.toString());
//        System.out.println(yorum.toString());
        System.out.println("********" + sheet.getRow(1).getCell(1).toString());
        //****Ikinci satir
        Row ikinciSatir = sheet.getRow(1);

        Cell isimm = ikinciSatir.getCell(0);
        System.out.println(isimm.toString());

        System.out.println(sheet.getRow(1).getCell(1));//BU sekilde yazildugunda atama islemi yapmadan dogrudan
                                                            // yazdirildigi icin daha kisa bir kod blogu kullaniyoruz.
        //Son satir indeksini alma
        int sonSatir = sheet.getLastRowNum();
        System.out.println(sonSatir);//3 ***Bu yontem son satiri gostermekle birlikte oncesindeki satirlarin data
        //barindirip barindirmadigini bilemiyoruz. Bunun icin farkli bir method kullanmak gerek==>
        //Icersinde data olan satir sayisi
        int satirSayisi = sheet.getPhysicalNumberOfRows();
        System.out.println(satirSayisi);//4
        System.out.println("*******");
        for (int i = 0 ; i<=sonSatir ; i++){
            Cell data = sheet.getRow(i).getCell(1);//Boylece tum satirlarin birinci indeksinde yer alan datalari yani
            //1. sutunda yer alan datalari elde etlis oluyoruz.
            System.out.println(data.toString());
        }
        //***Yukardaki fori dongusu ile yaptigimiz islemi 3. satir icin froEach ile yapalim==>
        System.out.println("forEach");
        for (Row each:sheet
             ) {
            Cell veri = each.getCell(2);
            System.out.println(veri.toString());
        }

        //Sutun sayisi alma
        int sutunSayisi = sheet.getRow(2).getLastCellNum();//3. satidaki son hucrenin numarasini getirir
        System.out.println(sutunSayisi);//4
        //Bir satirdaki verilerin fori dongusu ile yazdirilmasi
        System.out.println("Bir satirdaki verilerin fori dongusu ile yazdirilmasi");
        for(int i =0 ; i<sutunSayisi ; i++){
            Cell hucre = sheet.getRow(2).getCell(i);
            System.out.print(hucre.toString() +"," );
        }
        System.out.println();

        for (Cell hucre:sheet.getRow(3)
             ) {
            System.out.println(hucre.toString());
        }



        excel.close();
        file.close();
    }


}
