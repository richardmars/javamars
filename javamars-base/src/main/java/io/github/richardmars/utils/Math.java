package io.github.richardmars.utils;

import java.util.HashMap;
import java.util.Map;

public class Math {
	
	/**
	 * 获取最大值
	 * @param values
	 * @return
	 */
	public static int max(int[] values) {
		if (values == null) {
			return Integer.MIN_VALUE;
		}
		int max = values[0];
		for (int i = 1; i < values.length; i++) {
			if (max < values[i]) {
				max = values[i];
			}
		}
		return max;
	}
	
	/**
	 * 以key-value的形式存放最大值，可能存在几个相同的最大值
	 * @param values
	 * @return
	 */
	public static Map<Integer, Integer> maxMap(int[] values) {
		if (values == null) {
			return null;
		}
		Map<Integer, Integer> maxMap = new HashMap<>();
		maxMap.put(0, values[0]);
		int lastIndex = 0;
		for (int i = 1; i < values.length; i++) {
			if ((Integer)(maxMap.get(lastIndex)) <= values[i]) {
				if ((Integer)(maxMap.get(lastIndex)) < values[i]) {
					maxMap.clear();
				}
				maxMap.put(i, values[i]);
				lastIndex = i;
			}
		}
		return maxMap;
	}
}
