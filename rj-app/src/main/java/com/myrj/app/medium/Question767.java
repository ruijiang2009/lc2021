package com.myrj.app.medium;

/**
 * https://leetcode.com/problems/reorganize-string/
 * */
public class Question767 {
  /**
   * 1. count letter appearance and store in hash[i]
   * 2. find the letter with largest occurrence.
   * 3. put the letter into even index number (0, 2, 4 ...) char array
   * 4. put the rest into the array
   * */
  public String reorganizeString(String S) {
    // count the frequency
    int[] hash = new int[26];
    for (int i = 0; i < S.length(); i++) {
      hash[S.charAt(i) - 'a']++;
    }

    // Find the letter with the max frequency
    int max = 0, letter = 0;
    for (int i = 0; i < hash.length; i++) {
      if (hash[i] > max) {
        max = hash[i];
        letter = i;
      }
    }

    // Put the letter into even index number (0, 2, 4 ...) char array
    if (max > (S.length() + 1) / 2) {
      // If the maximum frequency is larger than half of the array, it's impossible
      // to rearrange.
      return "";
    }
    char[] res = new char[S.length()];
    int idx = 0;
    while (hash[letter] > 0) {
      res[idx] = (char) (letter + 'a');
      idx += 2;
      hash[letter]--; // frequency - 1
    }

    // Put the rest into the array
    for (int i = 0; i < hash.length; i++) {
      while (hash[i] > 0) {
        if (idx >= res.length) {
          idx = 1;
        }
        res[idx] = (char) (i + 'a');
        idx += 2;
        hash[i]--;
      }
    }

    return String.valueOf(res);
  }
}
