package myproject;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;
public class PDFToImage {

   public static void main(String args[]) throws Exception
   {
      File file = new File("D:/PDFWork/PdfBox_Examples/sample.pdf");
      PDDocument document = PDDocument.load(file);
      PDFRenderer renderer = new PDFRenderer(document);
      BufferedImage image = renderer.renderImage(0);
      ImageIO.write(image, "JPEG", new File("D:/PDFWork/PdfBox_Examples/myimage.jpg"));
      System.out.println("Image created");
      document.close();

   }
}
