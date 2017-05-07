package io.github.richardmars.utils;

import org.junit.Test;

public class EncodeUtilTest {

	@Test
	public void testMd5Encode() {
		System.out.println(EncodeUtil.md5Encode("hello"));
	}

	@Test
	public void testBase64Encode() {
		System.out.println(EncodeUtil.base64Encode("hello"));
	}
	
	@Test
	public void testBase64Decode() {
		System.out.println(EncodeUtil.base64Decode("aGVsbG8="));
	}

}
