
import edu.duke.*;
public class Part4
{
    public static void main(String[] args)
    {
        URLResource url = new URLResource("http://www.dukelearntoprogram.com/course2/data/manylinks.html");
        for(String s: url.words())
        {
            
            String sAnother = s; 
            s = s.toLowerCase();
            int index = s.indexOf("youtube.com");
            if(index != -1)
            {
                int startIndex = s.lastIndexOf("\"", index - 1);
                index = s.indexOf("\"", index);
                System.out.println(sAnother.substring(startIndex + 1, index));
            }
        }
    }
}