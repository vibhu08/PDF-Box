package myproject;

import java.io.File;
import java.io.IOException;
 
import org.apache.pdfbox.pdmodel.PDDocument; 
import org.apache.pdfbox.pdmodel.PDPage;
public class LoadingExistingDocument {

   public static void main(String args[]) throws IOException
   {
      File file = new File("D:/PDFWork/PdfBox_Examples/my_doc.pdf"); 
      PDDocument document = PDDocument.load(file); 
      System.out.println("PDF loaded"); 
      document.addPage(new PDPage());  
      document.save("D:/PDFWork/PdfBox_Examples/sample.pdf");
      document.close(); 
        
   }  
}