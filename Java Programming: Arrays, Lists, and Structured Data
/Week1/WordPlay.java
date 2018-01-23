
public class WordPlay
{
	
    public boolean isVowel(char ch)
    {
        if("aeiouAEIOU".indexOf(ch) != -1){
            return true;
        }
        else {
            return false;
        }
    }

   
    public String replaceVowels(String phrase, char ch)
    {
        StringBuilder p = new StringBuilder(phrase);
        String replacedphrase="";
        for (int i=0;i<phrase.length();i++)
        {
            if (!isVowel(p.charAt(i)))
            {
                replacedphrase = replacedphrase + p.charAt(i);
            }
            else 
            {
                replacedphrase =  replacedphrase + ch;
            }    
        }
        return replacedphrase;
    }
    
   
    public String emphasize(String phrase, char ch)
    {
        StringBuilder p = new StringBuilder(phrase);
        String emphasizedphrase="";
        for (int i=0;i<phrase.length();i++)
        {
            if (p.charAt(i) == Character.toUpperCase(ch) || p.charAt(i) == Character.toLowerCase(ch))
            {
                if (i%2==0)
                {
                    emphasizedphrase = emphasizedphrase + '*';
                } 
                else 
                    emphasizedphrase = emphasizedphrase + '+'; 
            }
            else 
            {
                emphasizedphrase =  emphasizedphrase + p.charAt(i);
            }    
        }
        return emphasizedphrase;
    }
}
