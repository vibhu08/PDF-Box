package myproject;

import java.io.IOException; 
import java.util.Calendar; 
import java.util.GregorianCalendar;
  
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import org.apache.pdfbox.pdmodel.PDPage;

public class AddingAttributes {
   public static void main(String args[]) throws IOException 
   {
      PDDocument document = new PDDocument();
      PDPage blankPage = new PDPage();
      document.addPage( blankPage );
      PDDocumentInformation pdd = document.getDocumentInformation();
      pdd.setAuthor("Tutorialspoint");
      pdd.setTitle("Sample document"); 
      pdd.setCreator("PDF Examples"); 
      pdd.setSubject("Example document"); 
      Calendar date = new GregorianCalendar();
      date.set(2015, 11, 5); 
      pdd.setCreationDate(date); 
      date.set(2016, 6, 5); 
      pdd.setModificationDate(date);  
      pdd.setKeywords("sample, first example, my pdf"); 
      document.save("D:/PDFWork/PdfBox_Examples/doc_attributes.pdf");
      System.out.println("Properties added successfully ");
      document.close();

   }
}