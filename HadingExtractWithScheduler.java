package myproject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
class ScheduledTask extends TimerTask {

	Date now; 
	public void run() 
	{
		now = new Date(); 
		File file = new File("D:/PDFWork/MY_PDF_DIRECTORY"); 
		String s[]=file.list();
		
		for(String s1 :s )
		{
			
			 File f=new File("D:/PDFWork/MY_PDF_DIRECTORY/"+s1);
			 PDDocument document = null;
			try {
				document = PDDocument.load(f);
			} catch (IOException e) {
				e.printStackTrace();
			} 
			 PDFTextStripper pdfStripper = null;
			try {
				pdfStripper = new PDFTextStripper();
			} catch (IOException e) {
				e.printStackTrace();
			}
			 pdfStripper.setParagraphStart("/t");
			    
			ArrayList<String> l= new ArrayList<String>();
			int n=0;

			    try {
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
				} catch (IOException e) {
					e.printStackTrace();
				}
			    
			    BufferedWriter br = null;
				try {
					br = new BufferedWriter(new FileWriter("D://PDFWork//PdfBox_Examples//"+s1+"_Heading"+".txt"));
				} catch (IOException e) {
					e.printStackTrace();
				}
			    for(int i=0;i<n;i++)
			    {
			    	try {
						br.write(l.get(i));
					} catch (IOException e) {
						e.printStackTrace();
					}
			    	try {
						br.newLine();
					} catch (IOException e) {
						e.printStackTrace();
					}
			    }
			    try {
					br.close();
					document.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			f.delete();
		}
		System.out.println("Time is :" + now); // Display current time
	}
}
public class HadingExtractWithScheduler
{
	 
	
	
	public static void main(String args[]) throws IOException, InterruptedException
	   {
		
		Timer time = new Timer(); // Instantiate Timer Object
		ScheduledTask st = new ScheduledTask(); // Instantiate SheduledTask class
		time.schedule(st, 0, 120000);   // Create Repetitively task for every 2 minutes
	    Thread.sleep(480000);//Sleep for 8 minutes
	    System.out.println("Exiting");
	    System.exit(0);

}
}
