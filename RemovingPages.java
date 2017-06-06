package myproject;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;

public class RemovingPages {

   public static void main(String args[]) throws IOException 
   {
      File file = new File("D:/PDFWork/PdfBox_Examples/sample.pdf");
      PDDocument document = PDDocument.load(file);
      int n= document.getNumberOfPages();
      System.out.print(n);
      document.removePage(2);
      System.out.println("page removed");
      document.save("D:/PDFWork/PdfBox_Examples/sample.pdf");
      document.close();

   }
}