package io.github.richardmars.exam.tencent;

import java.util.Scanner;

import org.junit.Test;

public class Main {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		scanner.close();
		boolean[] prime = judgePrime(N);
		int cnt = 0;
		for (int i=0; i< N; i++) {
			if (prime[i] == true) {
				for (int j=i; j< N; j++)
					if (prime[j] == true && i+j==N) {
						cnt++;
					}
			}
		}
		System.out.printf("%d", cnt);
	}
	@Test
	public void testSum() {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		scanner.close();
		int cnt = 0;
		for(int i=1; i< N/2;i+=1) {
			if (isPrime(i) && isPrime(N-i)) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
	
	public static boolean[] judgePrime(int N) {
		boolean[] prime = new boolean[N];
		for(int i=2; i<N; i++) {
			if (isPrime(i)) prime[i] = true;
			else prime[i] = false;
		}
		
		return prime;
	}
	
	public static boolean isPrime(int a) {    
        boolean flag = true;  
  
        if (a < 2) {
            return false;  
        } else {  
            for (int i = 2; i <= Math.sqrt(a); i++) {  
                if (a % i == 0) {
                    flag = false;  
                    break;
                }  
            }  
        }  
        return flag;  
    } 
	
	@Test
	public void testJudgePrime() {
		boolean[] prime = judgePrime(100);
		for (int i = 0; i < prime.length; i++) {
			if (prime[i]) {
				System.out.println("" + i + " : " + prime[i]);
			}
		}
	}
}
