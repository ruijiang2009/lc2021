package com.myrj.app.medium;

import java.util.HashSet;
import java.util.Set;

public class Question1461 {
  public boolean hasAllCodes(String s, int k) {
    Set<Integer> set = new HashSet<Integer>();
    if (s.length() < k) {
      return false;
    }
    int start = 0;
    int end = k;
    while(end <= s.length()) {
      String sub = s.substring(start, end);
      set.add(Integer.parseInt(sub, 2));
      end++;
      start++;
    }
    int expected = (int)Math.pow(2.0, k);
    return set.size() == expected;
  }
}
