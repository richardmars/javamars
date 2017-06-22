package io.github.richardmars.basic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class DateTest {
	@Test
	public void testSDF() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = sdf.parse("2016/09/02 22:30:52");
		System.out.println(date);
	}
	
}
