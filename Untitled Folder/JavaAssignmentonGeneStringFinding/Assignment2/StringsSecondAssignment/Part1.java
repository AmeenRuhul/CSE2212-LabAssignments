public class Part1
{
    int findStopCodon(String dna, int startIndex, String stopCodon)
    {
        int endIndex = startIndex;
        
        while(endIndex != -1)
        {
            endIndex = dna.indexOf(stopCodon, endIndex + 1);
           
            if(endIndex != -1 && (endIndex - startIndex) % 3 == 0)
            {
           
                return endIndex;
            }
        }
     
        return dna.length();
        
    }
    
     String findGene(String dna )
    {
        int startIndex = dna.indexOf("ATG");
        
        if(startIndex == -1)
            return "";
            
        int index = findStopCodon(dna, startIndex, "TAA");
        
        if(index == dna.length())
        {
            index = findStopCodon(dna, startIndex, "TAG");
        }
        
        if(index == dna.length())
            return "";
        else
            return dna.substring(startIndex, index + 3);
    }
    
  
    String testFindGene()
    {
        String dna = "ATAATAAAATAATAAATAAATAGATTAGAATGTAG";
        String gene;
        
        
        gene = findGene(dna);
        
        dna= "GATCGATAGACTGATAGGGGATGCAGTATATCCCTGGATACAATAGACGCACAGGTTGGAATCCTAAGTGAAGTCGCGCGTCCGAACCCAGCTCTATTTTAGAGGTCATGGGTTCTGGTGCCCGCGAGCCGCGGAACCGATTAGGGGCATGTACAACAATATTTATTAGTCATCTTTCAGACACAATCTCCCAGCTCACTGGTATATAGTTCCTGCTATAATTAGCCTCCCTCATAAGTTGCACTACTTCAGCGTCCCAAATGCACCCTTACCACGAAGACAGGATTGTCCGATCCCATATTACGACCTTGGCAGGGGGTTCGCAAGTCCCACCCCAAACGATGCTGAAGGCTCAGGTTTCACAGGGACAAAAGCTTTAAACGCGAGTTCCCGCTCATAACCTGGACCGAATGCAGAATCATGCATCGTTCCACTGTGTTCGTGTCATCTAGGACGGGCGCAAAGGATATATAATTCAATTTTGAATACCTTATATTATTGTACACCTACCGGTCACCAGCCAACAATGTGCGGATGGCGTTACAACTTTCTGGGCCTAATCTGACCGTTCTAGATACCGCACTCTGGGCAATACGAGGTAAAGCCAGTCACCCAGTGTCGATCAACACCTAACCTAACGGTAAGAGGCTCACATAATGGCACTGTCGGCGTCCCCAGGGTATTTTACGTTAGCATCAGGTGGACTAACATGAATCTTTACTCCCAAGCGAAAACGGGTGCGTGGACTAGCGAGGAGCAAACGAAAATTCTTGGCCTGCTTGGTGTCTCGTATTCCTCTTAGAGATCGACGAAATGTTTCACGACCAAGGGAAAGGTCGCCCTACAAAATAGATTTGCGTTACTCTCTCCATAAGGAGTCCGGTGTAGCGAAGGATCAAGGCGACCCTAGGTAGCAACCGCCGGCTTCGGCGGTAAGGTATCACTCAAGAAGCAGACACAGTAAGACACGGTCTAGCTGACTGTCTATCGGCTAGGTCAA";
      
        gene = findGene(dna);
        
        return gene;
        
    }  
    
    void testFindStopCodon()
    {
       
        String dna = "ATACGATATTATACCCGAGAT";
        System.out.println("DNA: " + dna);
        System.out.println("Gene: " +findStopCodon(dna ,1,"ATG")); 
        
    }
    
    void printAllGenes()
    {
        String dna = testFindGene();
         
       
        System.out.println("Gene: " +dna); 
    
    }
    
    
}


