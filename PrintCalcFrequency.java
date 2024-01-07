import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PrintCalcFrequency {
        public static void main(String[] args) {
        
        String str = "ttthhhhhhgggsdfavbaaaa";
        Map<Character,Integer> result = new HashMap<>();

        Character currentChar = str.charAt(0);
        result.put(currentChar, 1);
        for (int i =1; i < str.length(); i++) {
            Character temp = str.charAt(i);
            if (temp.equals(currentChar)) {
                Integer val = result.get(temp);
                result.put(temp, ++val);

            }else{
                currentChar = temp ;
                result.put(temp, 1);
            }
        }

       
      List<Map.Entry> map =  result.entrySet()
        .stream()
        .sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue())).collect(Collectors.toList());
        

        for (int i = 0; i < 5; i++) {
           System.out.println(map.get(i));
        }

       
    }
}
