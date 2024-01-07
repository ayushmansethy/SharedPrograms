import java.util.HashSet;

public class GivePairForASum {

    public static void findPairForSum(int[] array, int targetSum) {
        HashSet<Integer> complementSet = new HashSet<>();

        for (int num : array) {
            int complement = targetSum - num;

            if (complementSet.contains(complement)) {
                System.out.println("Pair found: (" + complement + ", " + num + ")");
                return;
            }

            complementSet.add(num);
        }

        System.out.println("No pair found for the given sum.");
    }

    public static void main(String[] args) {
        int[] array = { 1, 3, 5, 7, 9, 11 };
        int targetSum = 16;

        findPairForSum(array, targetSum);
    }
}
