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
public class NeedlemanWunsch2 {
	static String str1 = "12XYYX";
	static String str2 = new StringBuffer(str1).reverse().toString();
	
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
		System.out.println(lcs[str1.length()][str1.length()]);
	}

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
}
