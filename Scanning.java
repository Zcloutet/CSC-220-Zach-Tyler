package stuff;
import java.io.*;
import java.util.*;
public class Scanning 
{
	static int zeroes=0;
	static int ones=0;
	static int twos=0;
	static int threes=0;
	static int fours=0;
	static int fives=0;
	static int sixes=0;
	static int sevens=0; 
	static int eights=0;
	static int nines=0;
	static int total=0;
	public static void main (String [] args) throws IOException 
	{
		List<Integer> arr = new  ArrayList();
		
		readFile(arr);
		int [] num = new int [arr.size()];
		findFirst(arr,num);
		calc(num);
		drawTable();
	}


	public static void readFile(List arr) throws IOException
	{
		
		Scanner input = new Scanner(new File("C:/Users/Zach/Desktop/Assignment/Assignment#1/mountain_height.txt"));
		//input.useDelimiter(",");
		//System.out.println("" + input.delimiter());
		
	
		while (input.hasNext() == true)
		{
			String line = input.next();
			int n = Integer.parseInt(line.replaceAll(",", ""));
		
			//System.out.println(n);
			arr.add(n);
			
			
		
		}
		input.close();
		
	}
	

	public static int [] findFirst(List arr, int []num)
    {
		int k = 0;
        for (int i = 0; i< arr.size();i++)
        {
            k = (int) arr.get(i);
            while(k > 9)
            {
                k/= 10;
            }
            num[i] = k;
            //System.out.println(num[i]);
        }
        return num;
        
    }
	
	public static void calc(int [] num)
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
		float [] swag = {zeroes,ones,twos,threes,fours,fives,sixes,sevens,eights,nines};
		System.out.println(swag[0]);
		
		
		System.out.println("--------------------------------");
		System.out.println("Leading Digit    Count         %");
		System.out.println("--------------------------------");
		System.out.println("0                "+zeroes+"  "+(double)zeroes/total);
		System.out.println("1                "+ones+"  "+(double)ones/total);
		System.out.println("2                "+twos+"  "+(double)twos/total);
		System.out.println("3		 "+threes+"  "+(double)threes/total);
		System.out.println("4		 "+fours+"  "+(double)fours/total);
		System.out.println("5		 "+fives+(float)zeroes/total);
		System.out.println("6		 "+sixes);
		System.out.println("7		 "+sevens);
		System.out.println("8		 "+eights);
		System.out.println("9		 "+nines);
		System.out.println("--------------------------------");
		System.out.println("TOTAL            "+total+"           %");
		System.out.println("================================");
		
		//write function for calculating percentages, rewrite print statements into for loop, get delimiter to work
	
	}
	
	
	
}