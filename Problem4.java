import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem4 {

    // Greedy Algorithm for Coin Change
    public static List<Integer> coinChangeGreedy(int[] coins, int amount) {
        Arrays.sort(coins);
        List<Integer> result = new ArrayList<>();

        for (int i = coins.length - 1; i >= 0; i--) {
            while (amount >= coins[i]) {
                amount -= coins[i];
                result.add(coins[i]);
            }
        }

        return result;
    }

    // Dynamic Programming for Coin Change
    public static List<Integer> coinChangeDynamicProgramming(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                if (dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        int remaining = amount;

        while (remaining > 0) {
            for (int coin : coins) {
                if (remaining - coin >= 0 && dp[remaining - coin] + 1 == dp[remaining]) {
                    result.add(coin);
                    remaining -= coin;
                    break;
                }
            }
        }

        return result;
    }

    // Bonus Question: Find the largest possible number by removing one digit
    public static int largestNumberByRemovingDigit(int num) {
        char[] digits = Integer.toString(num).toCharArray();

        for (int i = 0; i < digits.length - 1; i++) {
            if (digits[i] < digits[i + 1]) {
                // Remove the leftmost digit larger than the digit to its right
                return Integer.parseInt(new StringBuilder(Integer.toString(num)).deleteCharAt(i).toString());
            }
        }

        // If no removal is possible, return the original number
        return num;
    }

    public static void main(String[] args) {
        // Coin Change Example
        int[] coins = { 1, 2, 5, 8, 10 };
        int change = 7;

        System.out.println("Greedy Algorithm Result: " + coinChangeGreedy(coins, change));
        System.out.println("Dynamic Programming Result: " + coinChangeDynamicProgramming(coins, change));

        // Bonus Question Example
        int number = 519374;
        System.out.println("Largest Number by Removing Digit: " + largestNumberByRemovingDigit(number));
    }
}
