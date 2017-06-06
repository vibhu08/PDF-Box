package myproject;import java.io.File;

import org.apache.pdfbox.pdmodel.PDDocument; 
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

public class InsertingImage {

 public static void main(String args[]) throws Exception 
 {
    File file = new File("D:/PDFWork/PdfBox_Examples/sample.pdf");
    PDDocument doc = PDDocument.load(file);
    PDPage page = doc.getPage(0);
    PDImageXObject pdImage = PDImageXObject.createFromFile("D:/PDFWork/PdfBox_Examples/images.png",doc);
    PDPageContentStream contents = new PDPageContentStream(doc, page);
    contents.drawImage(pdImage, 70, 250);
    System.out.println("Image inserted");
    contents.close();
    doc.save("D:/PdfBox_Examples/sample.pdf");
    doc.close();
   }
}