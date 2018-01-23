import java.util.Scanner;
public class Part2
{
     public String findSimpleGene(String dna,  String startCodon, String stopCodon)
    {
        boolean lowercaseflag = false;
        String dna1= dna;
        char ch=dna1.charAt(0);
        
        
        
        if(Character.isLowerCase(ch))
        {
            lowercaseflag = true;
            dna = dna.toUpperCase();
        }
        
        
        
        int startIndex = dna.indexOf("ATG");
        int stopIndex = dna.indexOf("TAA", startIndex + 3);
        
        while(startIndex != -1 && stopIndex != -1)
        {
            if((stopIndex - startIndex)%3 == 0)
             {
                
                   if(lowercaseflag == true)
                  {
                   return dna.substring(startIndex, stopIndex + 3).toLowerCase();
                  }
                  else
                 {
                   return dna.substring(startIndex, stopIndex + 3);
                  }
             
              }
              
           
        
        
       }
      return "";
    }
    
     void testSimpleGene()
     {
    
        
        String dna = "aaaaaatggtaaagtagc";
        System.out.println("DNA strand is " + dna);
        String gene = findSimpleGene(dna,"ATG", "TAA");
        System.out.println("Gene is " + gene); 
        
        dna = "TTCGATGGTTGATAAGCCAAAAGCTA";
        System.out.println("DNA strand is " + dna);
        gene = findSimpleGene(dna,"ATG", "TAA");
        System.out.println("Gene is " + gene);
        
      
        dna = "AACGAGTTGATAAGAACCGCC";
        System.out.println("DNA strand is " + dna);
        gene = findSimpleGene(dna,"ATG", "TAA");
        System.out.println("Gene is " + gene);
        
        dna = "AACGATGTTGATAAGCTAACCGCC";
        System.out.println("DNA strand is " + dna);
        gene = findSimpleGene(dna,"ATG", "TAA");
        System.out.println("Gene is " + gene);
        
        dna = "AACGAGTTGATAAGAACCGCC";
        System.out.println("DNA strand is " + dna);
        gene = findSimpleGene(dna,"ATG", "TAA");
        System.out.println("Gene is " + gene); 
    }

}
