public class Part2
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
        
        ratio =(double)count/dna.length();
        return ratio;
        
    }
    
    void testcgRatio()
    {
        String dna = "ATGCCATAG";
        System.out.println(cgRatio(dna));
    }
    
    int countCTG(String dna)
    {
        int count = 0;
        int index = -1;
        
        do
        {
            index = dna.indexOf("CTG", index + 1);
            
            if(index != -1)
                ++count;
                
        }while(index != -1);
        
        return count;
    }
    
    void testCountCTG()
    {
        String dna = "CTGCTGCTGAATCGTCTG";
        System.out.println(countCTG(dna));
        
        dna = "AATAATAATTAAGATCTATCGA";
        System.out.println(countCTG(dna));
        
    }
}