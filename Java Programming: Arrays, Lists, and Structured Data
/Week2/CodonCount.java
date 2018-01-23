

import edu.duke.*;
import java.util.*;

public class CodonCount
{
   
    private HashMap<String, Integer> DNAmap;

    
    public CodonCount()
    {
        
        DNAmap = new HashMap<String, Integer>();
    }

     private void buildCodonMap(int start, String dna)
    {
      DNAmap.clear();
      String current;
      for(int i = 0;i < (dna.length() - start)/3;i++)
      {
    	  current = dna.substring(start+i*3, start+i*3+3);
          if (!DNAmap.containsKey(current)) DNAmap.put(current, 1);
          else DNAmap.put(current, DNAmap.get(current)+1);
      }
    }
    
    private String getMostCommonCodon()
    {
      int value = 0;  
      int largestcount = 0;
      String largestkey = null;
      for(String key : DNAmap.keySet())
      {
          value = DNAmap.get(key);
          if (largestcount < value)
          {
              largestcount = value;
              largestkey = key;
          }
      }
      return largestkey;
    }
    
   
    private void printCodonCounts(int start, int end) 
    {
        int value = 0;
        for(String key : DNAmap.keySet()) 
        {
            value = DNAmap.get(key);
            if (value >= start && value <= end)
                System.out.println( key + " " + value + "\t");
        }
    }
    
    public void tester()
    {
         FileResource fr = new FileResource();
         String dna = fr.asString().trim();
         dna = dna.toUpperCase();
         int start = 1;
         int end = 5;
         
         buildCodonMap(0, dna);
         System.out.println("Reading frame starting with 0 results in "+DNAmap.size()+" unique codons"+"\t");
         String largest = getMostCommonCodon();
         System.out.println("Most common codon is "+largest+" with count "+DNAmap.get(largest)+"\t"); 
         System.out.println("Counts of codons between "+start+" and "+end+" inclusive are:"+"\t");
         printCodonCounts(start, end);
         
         buildCodonMap(1, dna);
         System.out.println("Reading frame starting with 1 results in "+DNAmap.size()+" unique codons"+"\t");
         largest = getMostCommonCodon();
         System.out.println("Most common codon is "+largest+" with count "+DNAmap.get(largest)+"\t"); 
         System.out.println("Counts of codons between "+start+" and "+end+" inclusive are:"+"\t");
         printCodonCounts(start, end);
         
         buildCodonMap(2, dna);
         System.out.println("Reading frame starting with 2 results in "+DNAmap.size()+" unique codons"+"\t");
         largest = getMostCommonCodon();
         System.out.println("Most common codon is "+largest+" with count "+DNAmap.get(largest)+"\t"); 
         System.out.println("Counts of codons between "+start+" and "+end+" inclusive are:"+"\t");
         printCodonCounts(start, end);
    }
}

