package io.github.richardmars.exam.jd;

import java.util.Scanner;

import org.junit.Test;
/**
 * 幸运数
 * @author xicod
 *
 */
public class Main1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextShort();
		int[] datas = new int[num];
		for (int i = 0; i < num; i++) {
			datas[i] = scanner.nextInt();
		}
		scanner.close();
		for (int data : datas) {
			System.out.println(numOfLuckyData(data));
		}
	}
	

	
	public static int dataSum(int data, int mod) {
		if (data == 0) {
			return 0;
		}
		else {
			return data % mod + dataSum(data / mod, mod);
		}
	}
	
	public static int numOfLuckyData(int data) {
		if (data == 1) {
			return 1;
		}
		else if(dataSum(data, 10) == dataSum(data, 2)) {
			return numOfLuckyData(data-1)+1;
		}
		else {
			 return numOfLuckyData(data-1);
		}
	}
	
	@Test
	public void test1() {
		System.out.println(dataSum(3, 10));
		System.out.println(dataSum(3, 2));
	}
	
	@Test
	public void test2() {
		System.out.println(numOfLuckyData(5));
	}
	
	public static void print(int[] dat) {
		for (int i = 0; i < dat.length; i++) {
			System.out.println(dat[i]);
		}
	}
}
