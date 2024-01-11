import java.util.Scanner;

public class MaxMonkeysForEqualBananas {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the total number of bananas: ");
        int totalBananas = scanner.nextInt();

        int maxMonkeys = calculateMaxMonkeys(totalBananas);

        System.out.println("The maximum number of monkeys is: " + maxMonkeys);

        scanner.close();
    }

    private static int calculateMaxMonkeys(int totalBananas) {
        int maxMonkeys = 0;

        // Iterate to find the maximum number of monkeys
        for (int i = 2; i <= totalBananas; i++) {
            int bananasPerMonkey = totalBananas / i;
            int remainingBananas = totalBananas % i;

            // Check if every monkey gets an equal number of bananas and more than one banana
            if (remainingBananas == 0 && bananasPerMonkey > 1) {
                maxMonkeys = i;
            } else {
                // Break the loop when we can no longer have monkeys with equal bananas
                // break;
            }
        }

        return maxMonkeys;
    }
}
