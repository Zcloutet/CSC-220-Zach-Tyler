
import java.math.*;
import java.text.DecimalFormat;
import java.io.*;
import java.util.*;
public class Scanning
{
	static double zeroes,ones,twos,threes,fours,fives,sixes,sevens,eights,nines,total = 0;
	public static void main (String [] args) throws IOException 
	{
		List<Long> arr = new  ArrayList();
		readFile(arr);
		long [] num = new long [arr.size()];
		findFirst(arr,num);
		calc(num);
		drawTable();
	}


	public static void readFile(List arr) throws IOException
	{
		
		Scanner input = new Scanner(new File("C:/Data Structures/Assignment/Assignment#1/random.txt")).useDelimiter(",");
		
		//System.out.println("" + input.delimiter());

		while (input.hasNext() == true)
		{
			String line = input.nextLine();	
	
				long n = Long.parseLong(line.replaceAll(",",""));
				
				arr.add(n);

			//input.skip("//n*");
			//System.out.println(line);
		
		}
		input.close();
		
	}
	public static double[] getPercentage(double first1[], double firstPer[], double total)
	{
		DecimalFormat df = new DecimalFormat("##.##"); 
		df.setRoundingMode(RoundingMode.HALF_UP);
		for (int i=0;i<first1.length;i++)
		{
			double n = ((first1[i]/total)*100);
			firstPer[i] = Double.parseDouble(df.format(n));
			first1[i] = Math.round(first1[i]);
		}
		return firstPer;
		
	}
	
	public static long[] findFirst(List<Long> arr, long []num)
    {
		long k = 0;
        for (int i = 0; i< arr.size();i++)
        {
            k = arr.get(i);
            while(k > 9)
            {
                k/= 10;
            }
            num[i] = k;
            //System.out.println(num[i]);
        }
        return num;
        
    }
	
	public static void calc(long [] num)
	{
		
		
		for(int i=0; i<num.length;i++)
		{
			if (num[i]==0)
			{
				zeroes += 1;
			}
			else if (num[i] == 1)
			{
				ones += 1;
			}
			else if (num[i] == 2)
			{
				twos += 1;
			}	
			else if (num[i] == 3)
			{
				threes += 1;
			}	
			else if (num[i] == 4)
			{
				fours += 1;
			}	
			else if (num[i] == 5)
			{
				fives += 1;
			}	
			else if (num[i] == 6)
			{
				sixes += 1;
			}
			else if (num[i] == 7)
			{
				sevens += 1;
			}	
			else if (num[i] == 8)
			{
				eights += 1;
			}	
			else if (num[i] == 9)
			{
				nines+=1;
			}	
			//System.out.println("9:"+nines+" 8:"+eights+" 7:"+sevens+" 6:"+sixes+" 5:"+fives+" 4:"+fours+" 3:"+threes+" 2:"+twos+" 1:"+ones);
			total +=1;
		}
	}

	
	public static void drawTable()
	{
		double [] first1 = {zeroes,ones,twos,threes,fours,fives,sixes,sevens,eights,nines};
		double firstPer [] = new double [first1.length];
		getPercentage(first1,firstPer,total);
		double totalPerc = total/total*100;
		System.out.println("--------------------------------");
		System.out.println("Leading Digit    Count         %");
		System.out.println("--------------------------------");
		int n=10;
		for(int i =0; i<n; i++)
		{
			int length = (int) first1[i];
			int perLength = (int) firstPer[i];
			//System.out.println(length);
			if (length < 10 && perLength < 10)
			{
				if (length == 0 && perLength == 0)
					System.out.println(i+"                "+(int)first1[i]+"          "+firstPer[i]+"%");
				else
					System.out.println(i+"                "+(int)first1[i]+"         "+firstPer[i]+"%");
			}
			else if (length < 10 && perLength >= 10)
				System.out.println(i+"                "+(int)first1[i]+"        "+firstPer[i]+"%");
			else if (length >=10 && perLength < 10)
				System.out.println(i+"                "+(int)first1[i]+"        "+firstPer[i]+"%");
			else if (length >= 100)
				if (length >=1000)
					System.out.println(i+"                "+(int)first1[i]+"     "+firstPer[i]+"%");
				else
					System.out.println(i+"                "+(int)first1[i]+"      "+firstPer[i]+"%");
			else 
				System.out.println(i+"                "+(int)first1[i]+"       "+firstPer[i]+"%");
			
		}
		System.out.println("--------------------------------");
		if(total >=1000)
			System.out.println("TOTAL            "+total+" "+totalPerc+"0%");
		else 
			System.out.println("TOTAL            "+total+"   "+totalPerc+"0%");
		System.out.println("================================");
		
		//write function for calculating percentages, rewrite print statements into for loop
	
	}
	
	
	
}