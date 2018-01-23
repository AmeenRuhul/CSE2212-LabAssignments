
import edu.duke.*;
import java.lang.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class WordLengths
{
	private HashMap hm = new HashMap();
	
	
	public void countWordLengths(FileResource resource, int[] counts){


		for(String word : resource.words()){
			int wordlength=0;
			StringBuilder sb = new StringBuilder(word);
			
			for (int k=0;k<sb.length();k++){
				if (k==0 && !Character.isLetter(sb.charAt(k))){
					sb.deleteCharAt(k);					
				}
				else if (k==sb.length()-1 && !Character.isLetter(sb.charAt(k))){
					sb.deleteCharAt(k);
				}
				else{
					wordlength++;
				}
			}
			String resultString = sb.toString();
			counts[wordlength]++;
			hm.put(resultString, wordlength);
		}

		for(int index=0;index<counts.length;index++) {
			if (counts[index] != 0) {
				System.out.print(counts[index] + " words of length " + index + ": ");
				Set set = hm.entrySet();
				
				Iterator i = set.iterator();
				
				while(i.hasNext()) {
					Map.Entry me = (Map.Entry)i.next();
					if (me.getValue().equals(index))
						System.out.print(me.getKey() + " ");
				}
				System.out.println();
			}
		}
	}

	
	public int indexOfMax(int[] values){
		int max=0;
		for(int i=0; i< values.length;i++){
			if(values[i]>max){
				max = values[i];
			}  
		}    
		return max;
	}

	public void testCountWordLengths(){
		FileResource resource = new FileResource();
		int[] counts = new int[31];
		countWordLengths(resource, counts);
		System.out.println(indexOfMax(counts));
	}
}
