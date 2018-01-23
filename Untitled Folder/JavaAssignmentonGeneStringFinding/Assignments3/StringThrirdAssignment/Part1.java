
import edu.duke.*;

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
    
    String findGene(String dna)
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
    
    void findAllGenes(String dna)
    {
        String gene = "";
        int count = 1;
        int startIndex = 0;
        int index = -1;
        
        do
        {
            startIndex = dna.indexOf("ATG", index + 1);
            if(startIndex == -1)
                break;
                
            index = findStopCodon(dna, startIndex, "TAA");
            
            if(index == dna.length())
            {
                index = findStopCodon(dna, startIndex, "TAG");
            }
            
            if(index == dna.length())
                break;
            gene = dna.substring(startIndex, index + 3);
            System.out.println("Gene" + ": " + gene);
            
        }while(gene != "");
    }
    
    StorageResource getAllGenes(String dna)
    {
        StorageResource res = new StorageResource();
        String gene = "";
        int count = 1;
        int startIndex = 0;
        int index = -1;
        
        do
        {
            startIndex = dna.indexOf("ATG", index + 1);
            if(startIndex == -1)
                break;
            index = findStopCodon(dna, startIndex, "TAA");
            
            if(index == dna.length())
            {
                index = findStopCodon(dna, startIndex, "TAG");
            }
            
            if(index == dna.length())
                break;
                
            gene = dna.substring(startIndex, index + 3);
            res.add(gene);
            
        }while(gene != "");
        
        return res;
    }
    
    void testGetAllGenes()
    {
        String dna = "ATAATAAAATAATAAATAAATAGATTAGAATGTAG";
        StorageResource store = new StorageResource(getAllGenes(dna));
        for(String s : store.data())
            System.out.println(s);
            
        dna = "ATGATAAAATAATAAATAAATAGATTAGAATGTAGCTGGACCGAATGCAGAATCATGCATCGTTCCACTGTGTTCGTGTCATCTAGGACGGGCGCAAAGGATATATAATTCAATTTTGAATACCTTATATTATTGTACACCTACCGGTCACCAGCCAACAATGTGCGGATGGCGTTACAACTTTCTGGGCCTAATCTGACCGTTCTAGATACCGCACTCTGGGCAATACGAGGTAAAGCCAGTCACCCAGTGTCGATCAACACCTAACCTAACGGTAAGAGGCTCACATAATGGCACTGTCGGCGTCCCCAGGGTATTTTACGTTAGCATCAGGTGGACTAACATGAATCTTTACTCCCAAGCGAAAACGGGTGCGTGGACTAGCGAGGAGCAAACGAAAATTCTTGGCCTGCTTGGTGTCTCGTATTCCTCTTAGAGATCGACGAAATGTTTCACGACCAAGGGAAAGGTCGCCCTACAAAATAGATTTGCGTTACTCTCTCCATAAGGAGTCCGGTGTAGCGAAGGATCAAGGCGACCCTAGGTAGCAACCGCCGGCTTCGGCGGTAAGGTATCACTCAAGAAGCAGACACAGTAAGACACGGTCTAGCTGACTGTCTATCGGCTAGGTCAA";
        
        store = getAllGenes(dna);
        
        for(String s : store.data())
            System.out.println(s);
            
    }
}

