/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pkg1;
import java.io.*;
import java.util.ArrayList;
/**
 *
 * @author James
 */
public class Assignment1 
{
    private static final String FILENAME = "C:\\Users\\James\\Documents\\NetBeansProjects\\Assighnment 1\\src\\assignment\\pkg1\\buildings_height.txt";
        
    public static void main(String[] args)  
    {
       int[]  array = readFile();
       printArray(array);
       array = findFirst(array);
       printArray(array);
    }
    
    public static int [] readFile()
    {
        int [] num = null; 
        ArrayList<Integer> number = new ArrayList<>();
        
        try
        {
           BufferedReader br = new BufferedReader(new FileReader(FILENAME));
           String line;
           int n = 0;
           int i = 0;
           num = new int [400];
           
            while((line = br.readLine()) != null)
            {

                // turn all the strings into integers have to get rid of the commas
                n = Integer.parseInt(line.replaceAll("," , ""));
                num[i] = n;
                //System.out.println(number);
            i++; 
            }            
            br.close();
        }catch (IOException e) {}
        return num;
    }
    public static void printArray(int [] arr)
    {
        for(int i =0; i < arr.length; i++)
        {
            System.out.println(arr[i]);
        }
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxx");
    }
    public static int [] findFirst(int [] arr)
    {
        int k = 0;
        int [] first = new int [arr.length];
        for (int i = 0; i< arr.length;i++)
        {
            k = arr[i];
            while(k > 9)
            {
                k/= 10;
            }
            first[i] = k;
        }
        return first;
    }
    
}
