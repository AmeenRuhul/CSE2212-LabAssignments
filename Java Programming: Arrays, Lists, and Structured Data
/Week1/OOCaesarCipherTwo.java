

import edu.duke.*;

public class OOCaesarCipherTwo {
    private String alphabet;
    private String shiftedAlphabet1;
    private String shiftedAlphabet2;
    private int mainKey1;
    private int mainKey2;
    
    public OOCaesarCipherTwo(int key1, int key2){
    
    alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
 
    shiftedAlphabet1 = alphabet.substring(key1)+alphabet.substring(0,key1);
    shiftedAlphabet2 = alphabet.substring(key2)+alphabet.substring(0,key2);
    mainKey1 = key1;
    mainKey2 = key2;
    }
    
    
    public String encrypt(String input) {
       
        StringBuilder encrypted = new StringBuilder(input);
       
        for(int i = 0; i < encrypted.length(); i++) {
           
            char currChar = encrypted.charAt(i);
          
            int idx = alphabet.indexOf( Character.toUpperCase(currChar));
       
            if(idx != -1 && i%2 ==0){
               
                if (currChar == Character.toUpperCase(currChar)){
                    char newChar = shiftedAlphabet1.charAt(idx);
                   
                    encrypted.setCharAt(i, newChar);
                }
                else{
                   char newChar = shiftedAlphabet1.charAt(idx);
            
                    encrypted.setCharAt(i, Character.toLowerCase(newChar)); 
                }
            }
            else if (idx != -1 && i%2 ==1){
              
                if (currChar == Character.toUpperCase(currChar)){
                    char newChar = shiftedAlphabet2.charAt(idx);
                   
                    encrypted.setCharAt(i, newChar);
                }
                else{
                   char newChar = shiftedAlphabet2.charAt(idx);
                 
                    encrypted.setCharAt(i, Character.toLowerCase(newChar)); 
                }
            }
           
        }
        
        return encrypted.toString();
    }
    
    public String decrypt(String input) {
        OOCaesarCipherTwo cc = new OOCaesarCipherTwo(26-mainKey1, 26-mainKey2);
        return cc.encrypt(input);
    }
}

