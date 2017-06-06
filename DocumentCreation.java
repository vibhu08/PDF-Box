package myproject;

import java.io.IOException; 
import org.apache.pdfbox.pdmodel.PDDocument;
  
public class DocumentCreation {
    
   public static void main (String args[]) throws IOException
   {
      PDDocument document = new PDDocument();    
      document.save("D:/PDFWork/PdfBox_Examples/my_doc.pdf");
      System.out.println("PDF created");  
      document.close();

   }  
}