import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BreakingArrayIntoSubArray {
    public static void main(String[] args) {
        int [] arr = {1,56,89,98,6523};
        int chunk = 2 ;
        
        List<int[] > chunkList   = new ArrayList<>() ;
        
        for (int i = 0; i < arr.length; i+=  chunk ) {
            int  endIndex = Math.min(i+ chunk, arr.length) ;
            int[] copyOfRange = Arrays.copyOfRange(arr, i, endIndex);
            chunkList.add(copyOfRange);
        }
        for (int[] val : chunkList) {
            System.out.println(Arrays.toString(val));
        }
    }
}
