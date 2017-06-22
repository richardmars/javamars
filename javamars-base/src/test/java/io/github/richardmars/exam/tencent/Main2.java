package io.github.richardmars.exam.tencent;

import java.util.ArrayList;
import java.util.Scanner;

public class Main2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.close();
		ArrayList<Integer> list = new ArrayList<Integer>();
		list = encode(n);
		for (int i : list)
			System.out.print(i);
	}

	private static ArrayList<Integer> encode(int n) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		int left = -90;
		int right = 90;
		for (int i = 0; i < 6; i++) {
			list.add(toBit(left, right, n));
			int mid = (left + right) / 2;
			if (n >= mid) {
				left = mid;
			} else
				right = mid;
		}
		return list;
	}

	public static int toBit(int left, int right, int n) {
		int mid = (left + right) / 2;
		if (n >= mid)
			return 1;
		else
			return 0;
	}
}
