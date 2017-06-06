package myproject;

import java.io.File; 
import java.io.IOException;
  
import org.apache.pdfbox.pdmodel.PDDocument; 
import org.apache.pdfbox.pdmodel.PDPage; 
import org.apache.pdfbox.pdmodel.PDPageContentStream; 
import org.apache.pdfbox.pdmodel.font.PDType1Font;
  
public class AddingText {
   public static void main (String args[]) throws IOException 
   {
      File file = new File("D:/PDFWork/PdfBox_Examples/my_doc.pdf");
      PDDocument document = PDDocument.load(file);
      PDPage page = document.getPage(1);
      PDPageContentStream contentStream = new PDPageContentStream(document, page);
      contentStream.beginText(); 
      contentStream.setFont(PDType1Font.TIMES_ROMAN, 12);
      contentStream.newLineAtOffset(25, 500);
      String text = "This is the sample document and we are adding content to it."; 
      contentStream.showText(text);      
      contentStream.endText();
      System.out.println("Content added");
      contentStream.close();
      document.save(new File("D:/PDFWork/PdfBox_Examples/new.pdf"));
      document.close();
   }
}