
    public class Part3
{
    boolean twoOccurences(String stringa, String stringb)
    {
        int count = 0;
        
        int index = 0 - stringa.length();
        do
        {
            index = stringb.indexOf(stringa, index + stringa.length());
            if(index != -1)
                count++;
        }while(index != -1);
       
        if(count < 2)
            return false;
        else
            return true;
    }
    
    String lastPart(String stringa, String stringb)
    {
        int index = stringb.indexOf(stringa);
        if(index == -1)
            return stringb;
        else 
            return stringb.substring(index + stringa.length());
    }
    
    void test()
    {
        String stringa = "by";
        String stringb = "A story by Abby Long";
        System.out.println("First string: " + stringa + "\nSecond string: " + stringb + "\nThey match?: " + twoOccurences(stringa, stringb));
        stringa = "a";
        stringb = "banana";
        System.out.println("First string: " + stringa + "\nSecond string: " + stringb + "\nThey match?: " + twoOccurences(stringa, stringb));
        stringa = "atg";
        stringb = "ctgtatgta";
        System.out.println("First string: " + stringa + "\nSecond string: " + stringb + "\nThey match?: " + twoOccurences(stringa, stringb));
        stringa = "an";
        stringb = "banana";
        System.out.println("The part of the string after " + stringa + " in " + stringb + " is " + lastPart(stringa, stringb));
        stringa = "zoo";
        stringb = "forest";
        System.out.println("The part of the string after " + stringa + " in " + stringb + " is " + lastPart(stringa, stringb));        
      
    }
}

