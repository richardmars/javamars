package test;

import java.util.Calendar;

import org.junit.Test;

import javassist.tools.framedump;

public class TestAll {
	@Test
	public void calcGrade1() {
		double x = 75*2.4 + 60*2 + 90*2 + 78.1*2 + 91*1 + 90*2 + 89*1 + 89.8*2 + 70*2 + 74*2.6;
		double y = 19;
		System.out.println(x/y);
	}
	
	@Test
	public void calcGrade2() {
		double x = 75*2.4 + 60*2 + 90*2 + 78.1*2 + 91*1 + 90*2 + 89*1 + 89.8*2 + 70*2 + 74*2.6;
		x = x + 84*2 + 85.2*2 + 96*2 + 90*2;
		double y = 19 + 8;
		System.out.println(x/y);
	}
}
