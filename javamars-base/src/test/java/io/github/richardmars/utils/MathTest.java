package io.github.richardmars.utils;

import org.junit.Test;

import io.github.richardmars.utils.Math;

public class MathTest {

	@Test
	public void testMax() {
		System.out.println(Math.max(new int[] {1, 2, 2, -1}));
	}

	@Test
	public void testMaxMap() {
		System.out.println(Math.maxMap(new int[] {1, 2, 2, -1}));
	}
	
	@Test
	public void testMod() {
		System.out.println(-24%5);
		System.out.println(24%-5);
	}
}
