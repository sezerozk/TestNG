package com.tayfa.excelAutomation;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteExcel {
    @Test
    public void test() throws IOException {
        String dosyaYolu = "src/test/resources/Kitap.xlsx";
        FileInputStream file = new FileInputStream(dosyaYolu);
        Workbook excel = WorkbookFactory.create(file);
        FileOutputStream fileOutputStream = new FileOutputStream(dosyaYolu);//Dosya uzerinde degisiklik yapip kaydedebilmek
        //icin FileOutputStream'e ihtiyacimiz var.

        Sheet sheet = excel.getSheetAt(0);


        //Yeni bir hucre olusturmak ve icerisine data eklemek
        sheet.getRow(0).createCell(3).setCellValue("Yorum");
        sheet.getRow(1).createCell(3).setCellValue("5");
        sheet.getRow(2).createCell(3).setCellValue("5");
        sheet.getRow(3).createCell(3).setCellValue("30");

        //Satir silmek icin
//        Row silinecekatir = sheet.getRow(4);
//        sheet.removeRow(silinecekatir);

        //Hucre silmek icin
//        Cell silinecekHucre = sheet.getRow(2).getCell(2);
//        sheet.getRow(2).removeCell(silinecekHucre);
//Silinmek istenen kism bos oldugu zaman hata veriyor ve excel dosyasini da bozuyor o sebeple
//satir ve hucre silmekle ilgili kisimlari yorum satiri olarak biraktim.



        excel.write(fileOutputStream);

        excel.close();
        file.close();

    }

}
