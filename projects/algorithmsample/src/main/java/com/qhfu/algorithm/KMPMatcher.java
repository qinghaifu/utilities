package com.qhfu.algorithm;

public class KMPMatcher {

	/**
	 * generate the prefix function of a pattern string
	 * 
	 * @param pattern
	 * @return
	 */
	public int[] computePrefixFunction(char[] pattern) {
		int[] preArr = new int[pattern.length];
		if (pattern.length == 0) {
			return preArr;
		}

		preArr[0] = 0;
		int k = 0;
		for (int i = 1; i < pattern.length; i++) {
			while (k > 0 && pattern[k] != pattern[i]) {
				k = preArr[k - 1];
			}

			if (pattern[k] == pattern[i]) {
				k = k + 1;
			}

			preArr[i] = k;
		}
		return preArr;
	}

	/**
	 * kmp matcher， complexity O(n+m)
	 * 
	 * @param source
	 * @param pattern
	 * @return
	 */
	public boolean match(String source, String pattern) {
		if (source == null || pattern == null || source.isEmpty()
				|| pattern.isEmpty()) {
			return false;
		}
		char[] src = source.toCharArray();
		char[] patt = pattern.toCharArray();
		int[] preArr = this.computePrefixFunction(patt);
		int k = 0;
		for (int i = 0; i < src.length; i++) {
			while (k > 0 && src[i] != patt[k]) {
				k = preArr[k];
			}
			if (src[i] == patt[k]) {
				k++;
			}
			if (k == patt.length) {
				System.out.println("find it, start index: " + (i - k + 1));
				return true;
			}
		}
		return false;
	}
}
