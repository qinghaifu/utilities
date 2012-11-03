package com.qhfu.algorithm;

import org.junit.Assert;

import org.junit.Test;

public class KMPMatcherTest {
	private final KMPMatcher kmpMatcher = new KMPMatcher();

	@Test
	public void testComputePrefixFunction() {
		String pattStr = "ababababacdab";
		int[] preArray = kmpMatcher
				.computePrefixFunction(pattStr.toCharArray());
		Assert.assertEquals(13, preArray.length);
		int[] expected = { 0, 0, 1, 2, 3, 4, 5, 6, 7, 0, 0, 1, 2 };
		Assert.assertArrayEquals(expected, preArray);
	}

	@Test
	public void testComputePrefixFunction2() {
		String pattStr = "";
		int[] preArray = kmpMatcher
				.computePrefixFunction(pattStr.toCharArray());
		Assert.assertEquals(0, preArray.length);
	}

	@Test
	public void testComputePrefixFunction3() {
		String pattStr = "a";
		int[] preArray = kmpMatcher
				.computePrefixFunction(pattStr.toCharArray());
		Assert.assertEquals(1, preArray.length);
	}

	@Test
	public void testkmpMatch() {
		Assert.assertTrue(kmpMatcher.match("abacdabcd", "abc"));
	}

	@Test
	public void testkmpMatch2() {
		Assert.assertFalse(kmpMatcher.match("abacdabcd", "abd"));
	}

	@Test
	public void testkmpMatch3() {
		Assert.assertTrue(kmpMatcher.match("abacdabcd", "ab"));
	}

	@Test
	public void testkmpMatch4() {
		Assert.assertFalse(kmpMatcher.match("abacdabcd", ""));
	}

}
