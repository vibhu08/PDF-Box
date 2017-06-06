package myproject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class HadingExtractWithScheduler {

	
	
	public static void main(String args[]) throws IOException
	   {
		
	File file = new File("D:/PDFWork/MY_PDF_DIRECTORY"); 
	String s[]=file.list();
	
	for(String s1 :s )
	{
		
		 File f=new File("D:/PDFWork/MY_PDF_DIRECTORY/"+s1);
		 PDDocument document = PDDocument.load(f); 
		 PDFTextStripper pdfStripper = new PDFTextStripper();
		 pdfStripper.setParagraphStart("/t");
		    
		ArrayList<String> l= new ArrayList<String>();
		int n=0;

		    for (String line: pdfStripper.getText(document).split(pdfStripper.getParagraphStart()))
		            {
		                int c=0;
		                line=line.trim();
		    	        for(int i=0;i<line.length();i++)
		                {
		                   
		                    if( ((i>0)&&(line.charAt(i)!=' ')&&(line.charAt(i-1)==' ')) || ((line.charAt(i)!=' ')&&(i==0)) )
		                    {
		                    c++;
		                    }
		                    
		                }
		    	        if(c<=5 && c>0)
		                {
		    	        	l.add(line);
		    	        	n++;
		                	System.out.println(line);
		                System.out.println("********************************************************************");
		                }  
		            }
		    
		    BufferedWriter br=new BufferedWriter(new FileWriter("D://PDFWork//PdfBox_Examples//"+s1+"_Heading"+".txt"));
		    for(int i=0;i<n;i++)
		    {
		    	br.write(l.get(i));
		    	br.newLine();
		    }
		    br.close();
		
	}

}
}
