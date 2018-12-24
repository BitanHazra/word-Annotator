import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Cosinesimilarity
{
	File f1;
	File f2;
	String s1="",s2="";
	int c;
	String target;
	FileReader filereader = null;
	String[] listpos  = {"CC","CD","DT","EX","FW","IN","JJ","JJR","JJS","LS","MD","NN","NNS","NNP","NNPS","PDT","POS","PRP","PRP$","RB","RBR","RBS","RP","TO","SYM","UH","VB","VBD","VBG","VBN","VBP","VBZ","WDT","WP","WP$","WRB"};
	int[] listval  = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	int[] listval2 = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	double[] numval    = {0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0};
	double[] denomvalA  = {0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0};
	double[] denomvalB  = {0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0};
	double denomvalAS = 0.0;
	double denomvalBS = 0.0;
	double denomvalT = 0.0;
	double numT = 0.0;
	int len=0;
	double result=0.0;

	public Cosinesimilarity()
	{
		try{
				s1 ="";
				filereader = new FileReader("tagged.txt");
			
				while((c=filereader.read()) != -1)
				{
					s1 = s1 + (char)c;
					
				}
				
				for(int i=0;i<listpos.length;i++)
				{
					Pattern patern = Pattern.compile(listpos[i]);
					Matcher m = patern.matcher(s1);
					while(m.find())
					{
						len++;
					}
					listval[i] = len;
					len = 0;
				}
				filereader.close();
					
		}catch(FileNotFoundException fnf){}
		catch(IOException ioe){}

		try{
				s1 ="";
				filereader = new FileReader("tagged2.txt");
			
				while((c=filereader.read()) != -1)
				{
					s1 = s1 + (char)c;
					
				}
				
				for(int i=0;i<listpos.length;i++)
				{
					Pattern patern = Pattern.compile(listpos[i]);
					Matcher m = patern.matcher(s1);
					while(m.find())
					{
						len++;
					}
					listval2[i] = len;
					len = 0;
				}
			
			filereader.close();
					
		}catch(FileNotFoundException fnf){}
		catch(IOException ioe){}

		resultcalculation();
		result = numT/denomvalT;
		System.out.println(result);

	}

	void resultcalculation()
	{
		for(int i=0;i<listval2.length;i++)
			{
				numval[i] = listval[i] * listval2[i];
				denomvalA[i] = listval[i] * listval[i];
				denomvalB[i] = listval2[i] * listval2[i];
			}
		for(int i=0;i<denomvalA.length;i++)
			{
			denomvalAS = denomvalAS + denomvalA[i];
			denomvalBS = denomvalBS + denomvalB[i];
			numT = numT + numval[i];
			}
			denomvalT = denomvalAS * denomvalBS;
			denomvalT = Math.sqrt(denomvalT);

	}
	
	public static void main(String[] args)
	{
		new Cosinesimilarity();
	}
}
