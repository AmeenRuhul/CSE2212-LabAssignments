import edu.duke.*;

public class Part3

{
    double cgRatio(String dna)
    {
        int count = 0;
        double ratio;
        
        for(int i = 0; i != dna.length(); ++i)
        {
            if(dna.charAt(i) == 'G' || dna.charAt(i) == 'C')
                count++;
        }
        
        ratio = (double)count/dna.length();
        return ratio;
        
    }
    
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
    
    void processGenes(StorageResource sr)
    {
        int countGreaterThan9Length = 0;
        int countCGRatio = 0;
        String longest = "";
        boolean printed;
        
        for(String s : sr.data())
        {
            printed = false;
            if(longest.length() < s.length())
                longest = s;
                
            if(cgRatio(s) > .35)
            {
                countCGRatio++;
                System.out.println(s);
                if(s.length() > 9)
                    printed = true;
            }
            
            if(s.length() > 9)
            {
                countGreaterThan9Length++;
                if(!printed)
                    System.out.println(s);
            }
            
        }
        
        System.out.println("Greater than 9 length strings: " + countGreaterThan9Length);
        System.out.println("Greater than .35 cgRatio: " + countCGRatio);
    }
    
    void testProcessGenes()
    {
        String DNA = "CCCGGAATGAAACAT";
        StorageResource sr = getAllGenes(DNA);
        processGenes(sr);
        sr.clear();
        
        DNA = "ATGAGCCCAGATTAGATGAAACTTTTATGATTAA";
        sr = getAllGenes(DNA);
        processGenes(sr);
        sr.clear();
        
        DNA = "ATGAGTTAGATGAAACATGATTAAAAAATGAAAVVVCCCCAAATTAGATAGACATGATTAA";
        sr = getAllGenes(DNA);
        processGenes(sr);
        sr.clear();        

        DNA = "ATGAGTTAGATGAAACATGTAGAGTAGATAGTAGTATTAAAAAATGAAACATGATTAA";
        sr = getAllGenes(DNA);
        processGenes(sr);
        sr.clear();        
        
        
        DNA = "TAGATAGATGAGTTAGATGCCCGCGAAACATGATTAAAAAATGCCCGCGCCCAAACATGATTAA";
        sr = getAllGenes(DNA);
        processGenes(sr);
        sr.clear();        
        
        
        DNA = "TAAAAAATGAGTTAGATGCCCGCGAAACATGATTAAAAAATGAAACATGATTAA";
        sr = getAllGenes(DNA);
        processGenes(sr);
        sr.clear();        
        
        DNA = "AAAATTTAGGAATGAGTTAGATGCCCGCGAAACATGATTAAAAAATGAAACATGATTAA";
        sr = getAllGenes(DNA);
        processGenes(sr);
        sr.clear();
    }
}