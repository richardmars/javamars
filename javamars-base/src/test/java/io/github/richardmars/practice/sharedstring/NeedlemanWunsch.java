package io.github.richardmars.practice.sharedstring;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import io.github.richardmars.utils.Math;

/**
 * @category 文本比较算法Ⅱ——NeedlemanWunsch
 * @reference http://www.cnblogs.com/grenet/archive/2010/06/03/1750454.html
 * @lable 动态规划，公共子串，腾讯实习生笔试
 * @author xicod
 *
 */
public class NeedlemanWunsch {
	static String str1 = "GGATCGA";
	static String str2 = "GAATTCAGTTA";
	static String result = "";

	static Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	static int[][] lcs = new int[str1.length() + 1][str2.length() + 1];

	@Before
	public void setup() {
		for (int i = 0; i <= str1.length(); i++) {
			lcs[i][0] = 0;
		}
		for (int j = 0; j <= str2.length(); j++) {
			lcs[0][j] = 0;
		}
	}

	@Test
	public void testLcs() {
		lcs();
		print();
		System.out.println(resultStr());
	}

	/**
	 * 思路：递归 备注：因为递归效率低下，放弃
	 * 
	 * @param str1
	 * @param str2
	 * @param i
	 * @param j
	 * @return
	 */
	public static int lcs(String str1, String str2, int i, int j) {
		if (i == -1 || j == -1) {
			return 0;
		} else {
			if (str1.charAt(i) == str2.charAt(j)) {
				return lcs(str1, str2, i - 1, j - 1) + 1;
			} else {
				return Math.max(new int[] { lcs(str1, str2, i - 1, j - 1), lcs(str1, str2, i, j - 1),
						lcs(str1, str2, i - 1, j) });
			}
		}
	}

	/**
	 * 思路2：采用动态规划，建表
	 */
	public static void lcs() {
		for (int i = 1; i <= str1.length(); i++) {
			for (int j = 1; j <= str2.length(); j++) {
				if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					lcs[i][j] = lcs[i - 1][j - 1] + 1;
				} else {
					lcs[i][j] = Math.max(new int[] { lcs[i][j - 1], lcs[i - 1][j], lcs[i - 1][j - 1] });
				}
			}
		}
	}

	public static void print() {
		for (int i = 1; i <= str1.length(); i++) {
			for (int j = 1; j <= str2.length(); j++) {
				System.out.print(lcs[i][j]);
			}
			System.out.println("");
		}
	}

	public static String resultStr() {

		for (int i = str1.length(), j = str2.length(); i > 0 && j > 0;) {
			if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
				result = str1.charAt(i - 1) + result;
				i--;
				j--;
			} else {
				Map<Integer, Integer> maxMap = Math
						.maxMap(new int[] { lcs[i - 1][j - 1], lcs[i - 1][j], lcs[i][j - 1] });
				if (maxMap.containsKey(0)) {
					i--;
					j--;
				} else if (maxMap.containsKey(1)) {
					i--;
				} else {
					j--;
				}
			}
		}
		return result;
	}
}
