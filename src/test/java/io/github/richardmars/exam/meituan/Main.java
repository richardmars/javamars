package io.github.richardmars.exam.meituan;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		int[] coins = {1, 5, 10, 20, 50, 100};
		Scanner scanner = new Scanner(System.in);
		int sum = scanner.nextInt();
		scanner.close();
		int result = combinate(coins, 6, sum);
		System.out.println(result);
	}
	
	public static int combinate(int coins[], int coinKinds, int sum) {
		int x = coinKinds + 1;
		int y = sum + 1;
		int[][]dp = new int[x][y];
		
		for(int i = 0; i <= coinKinds; i++) {
			for (int j = 0; j < sum; j++) {
				dp[i][j] = 0;
			}
		}
		
		for(int i = 0; i <= coinKinds; ++i) {
			dp[i][0] = 1;
		}
		
		for (int i = 1; i <= coinKinds; i++) {
			for (int j = 1; j <= sum; j++) {
				dp[i][j] = 0;
				for (int k = 0; k <= j / coins[i-1]; k++) {
					dp[i][j] += dp[i-1][j - k * coins[i-1]];
				}
			}
		}
		
		return dp[coinKinds][sum];
	}
}
