package myproject;
import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class AddingMultipleLines {
   public static void main(String args[]) throws IOException
   {
      File file = new File("D:PDFWork//PdfBox_Examples/new.pdf");
      PDDocument doc = PDDocument.load(file); 
      PDPage page = doc.getPage(0);  
      PDPageContentStream contentStream = new PDPageContentStream(doc, page); 
      contentStream.beginText(); 
      
      contentStream.setLeading(14.5f);
      contentStream.newLineAtOffset(25, 725);
      contentStream.setFont( PDType1Font.TIMES_BOLD, 16 );
      String text="HOLY" ;
      contentStream. showText(text);
      contentStream.newLine();
      contentStream.setFont( PDType1Font.TIMES_ROMAN, 16 );
      String text1="This is a paragraph.A paragraph has multiples lines" ;
      contentStream. showText(text1);
      contentStream.newLine();
      contentStream.endText();
      System.out.println("Content added");
      contentStream.close();
     
      
     
      
      doc.save(new File("D:PDFWork//PdfBox_Examples/new1.pdf"));
      doc.close();
   }
}
