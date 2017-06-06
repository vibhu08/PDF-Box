package myproject;

import java.io.File; 
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument; 
import org.apache.pdfbox.pdmodel.PDDocumentInformation;

public class RetrivingAttributes {
   public static void main(String args[]) throws IOException 
   {
      File file = new File("D:/PDFWork/PdfBox_Examples/doc_attributes.pdf");
      PDDocument document = PDDocument.load(file);
      PDDocumentInformation pdd = document.getDocumentInformation();
      System.out.println("Author of the document is :"+ pdd.getAuthor());
      System.out.println("Title of the document is :"+ pdd.getTitle());
      System.out.println("Subject of the document is :"+ pdd.getSubject());
      System.out.println("Creator of the document is :"+ pdd.getCreator());
      System.out.println("Creation date of the document is :"+ pdd.getCreationDate());
      System.out.println("Modification date of the document is :"+pdd.getModificationDate()); 
      System.out.println("Keywords of the document are :"+ pdd.getKeywords()); 
      document.close();        
   }  
}