package io.github.richardmars.exam.baidu;

import java.util.HashMap;

import org.junit.Test;

/**
 * @category 典型的二维递归和动态规划题目
 * @reference http://www.zhihu.com/question/37350027?sort=created
 * @description 已知，4瓶啤酒瓶可以换1瓶啤酒，那么n瓶啤酒最多能喝多少瓶？
 * @label 递归建模，动态规划，百度内推面试题
 * @author xicod
 *
 */
public class BeerBottle {
	@Test
	public void testTotalBeerNum() {
		for (int i = 0; i <= 9; i++) {
			int totalBeerNum = totalBeerNum(i, 0);
			int remainBottleNum = remainBottleNum(i, 0);
			System.out.println("i: " + i + " " //
					+ "totalBeerNum:" + totalBeerNum + " " //
					+ "remainBottleNum: " + remainBottleNum);
		}
	}

	/**
	 * 思路1
	 * 当g(x-1, y-1)<2时，g(x, y)=g(x-1, y-1)+2; f(x, y)=f(x-1,y-1)+1;
	 * 当g(x-1, y-1)>2时，g(x, y)=(g(x-1,y-1)+2)%4 + 1; f(x, y)=f(x-1,y-1)+1;
	 * 其中，x指手上的啤酒数量，y指手上的瓶子数量
	 * g(x,y)指剩下的瓶子数量，f(x,y)指喝掉的啤酒数量
	 * 
	 * @function 计算最后能喝的啤酒数
	 * @param beerNum 手上的啤酒数量
	 * @param bottleNum 手上的瓶子数量
	 */
	public static int totalBeerNum(int beerNum, int bottleNum) {
		if (beerNum == 0 && bottleNum < 4) {
			return 0;
		} else {
			int lastRemainBottleNum = remainBottleNum(beerNum - 1, bottleNum - 1);
			if (lastRemainBottleNum < 2)
				return totalBeerNum(beerNum - 1, bottleNum - 1) + 1;
			else
				return totalBeerNum(beerNum - 1, bottleNum - 1) + 2; // 本来剩下两个以上的瓶子，所以可以多喝2瓶
		}
	}

	/**
	 * 计算最后剩下的酒瓶数 剩下的数量肯定少于等于3
	 * 
	 * @param beerNum
	 *            手上的啤酒数量
	 * @param bottleNum
	 *            手上的瓶子数量
	 */
	public static int remainBottleNum(int beerNum, int bottleNum) {
		if (beerNum == 0 && bottleNum < 4) {
			return bottleNum;
		} else {
			int lastRemainBottleNum = remainBottleNum(beerNum - 1, bottleNum - 1);
			if (lastRemainBottleNum < 2)
				return lastRemainBottleNum + 2;
			else
				return (lastRemainBottleNum + 2) % 4 + 1;
		}
	}
	
	@Test
	public void testTotalBeerNum2() {
		for (int i = 0; i <= 9; i++) {
			HashMap<String, Integer> map = totalBeerNum2(i);
			int totalBeerNum = map.get("totalBeerNum");
			int remainBottleNum = map.get("remainBottleNum");
			System.out.println("i: " + i + " " //
					+ "totalBeerNum:" + totalBeerNum + " " //
					+ "remainBottleNum: " + remainBottleNum);
		}
	}
	
	/**
	 * 思路2
	 * 采用动态规划方法进行设计，更易理解，效率更高
	 * 与上面不同，这个可以变相为
	 * 当g(x-1)<3时，g(x)=g(x-1)+1; f(x)=f(x-1)+1;
	 * 当g(x-1)=3时，g(x)=1; f(x)=f(x-1)+2; 
	 * 其中g(x)指当有x瓶酒时，喝完后剩下g(x)个瓶子；f(x)为总工喝的酒 
	 */
	public static HashMap<String, Integer> totalBeerNum2(int beerNum) {
		int totalBeerNum = 0;
		int lastTotalBeerNum = totalBeerNum;
		int remainBottleNum = 0;
		int lastRemainBottleNum = totalBeerNum;
		for (int i = 0; i <= beerNum; i++) {
			if (i < 4) {
				remainBottleNum = i;
				totalBeerNum = i;
			}
			else {
				if (lastRemainBottleNum < 3) {
					totalBeerNum = lastTotalBeerNum + 1;
					remainBottleNum = lastRemainBottleNum + 1;
				}
				else {
					totalBeerNum = lastTotalBeerNum + 2;
					remainBottleNum = 1;
				}
			}
			
			lastTotalBeerNum = totalBeerNum;
			lastRemainBottleNum = remainBottleNum;
		}
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("totalBeerNum", totalBeerNum);
		map.put("remainBottleNum", remainBottleNum);
		return map;
	}
	
	@Test
	public void testTotalBeerNum3() {
		for (int i = 0; i <= 9; i++) {
			int totalBeerNum = totalBeerNum(i, 0);
			int remainBottleNum = remainBottleNum(i, 0);
			System.out.println("i: " + i + " " //
					+ "totalBeerNum:" + totalBeerNum + " " //
					+ "remainBottleNum: " + remainBottleNum);
		}
	}
	
	/**
	 * The best way
	 * 思路2的递归实现
	 * @param beerNum
	 * @return
	 */
	public static int totalBeerNum3(int beerNum) {
		if (beerNum < 3) return beerNum;
		
		int lastRemainBottleNum = remainBottleNum3(beerNum - 1);
		if (lastRemainBottleNum < 3) return totalBeerNum3(beerNum) + 1;
		else return totalBeerNum3(beerNum) + 2;
	}
	
	public static int remainBottleNum3(int beerNum) {
		if (beerNum == 0) return 0;
		
		int lastRemainBottleNum = remainBottleNum3(beerNum - 1);
		if (remainBottleNum3(beerNum) < 3) return lastRemainBottleNum + 1;
		else return 1;
	}
}
