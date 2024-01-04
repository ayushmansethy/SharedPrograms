package test;
import java.util.LinkedHashMap;
import java.util.Map;

public class CalcFrequency {
    public static void main(String[] args) {
        String str = "gdvrtytgggoood" ;

        Map <Character,Integer> freqencys = new LinkedHashMap<>();

        for (int i = 0; i < str.length(); i++) {
            if (freqencys.containsKey(str.charAt(i))) {
                Integer integer = freqencys.get(str.charAt(i));
                // integer++;
                freqencys.replace(str.charAt(i),++integer);
            }else{
                freqencys.put(str.charAt(i), 1);
            }
            
        }

        for (Map.Entry<Character,Integer> entry : freqencys.entrySet()) {

            if (entry.getValue() == 1 ) {
                Character key = entry.getKey() ;

                System.out.println(str.indexOf(key)+"is the index of " +  key);
                break ;
            }
            
            
        }

        
      

    
        

    }
}
