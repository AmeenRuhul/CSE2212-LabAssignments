
 public class Part1
{
    public String findSimpleGene(String dna)
    {
        int startIndex = dna.indexOf("ATG");
        int stopIndex = dna.indexOf("TAA", startIndex + 3);
        
        while(startIndex != -1 && stopIndex != -1){
            
            if((stopIndex - startIndex) % 3 == 0){
                return dna.substring(startIndex, stopIndex + 3);
            }
            else{
                stopIndex = dna.indexOf("TAA", stopIndex + 1);
            }
        }
        return "";
    }
    
    void testSimpleGene(){
    
        String dna = "AAAAAGAAACGTAATTAATCGAAAT";
        System.out.println("DNA strand is " + dna);
        String gene = findSimpleGene(dna);
        System.out.println("Gene is " + gene);
        
        dna = "TTCGATGGTTGATAAGCCAAAAGCTA";
        System.out.println("DNA strand is " + dna);
        gene = findSimpleGene(dna);
        System.out.println("Gene is " + gene);
        
        dna = "AACGAGTTGATAAGAACCGCC";
        System.out.println("DNA strand is " + dna);
        gene = findSimpleGene(dna);
        System.out.println("Gene is " + gene);
        
        dna = "AACGATGTTGATAAGCTAACCGCC";
        System.out.println("DNA strand is " + dna);
        gene = findSimpleGene(dna);
        System.out.println("Gene is " + gene);
        
        dna = "AACGAGTTGATAAGAACCGCC";
        System.out.println("DNA strand is " + dna);
        gene = findSimpleGene(dna);
        System.out.println("Gene is " + gene); 
    }

}



