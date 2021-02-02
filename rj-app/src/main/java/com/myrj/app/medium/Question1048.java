package com.myrj.app.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/longest-string-chain/
 * */
public class Question1048 {
  public int longestStrChain(String[] words) {
    // scan by length of words
    HashMap<Integer, Set<String>> lenToWords = new HashMap<>();
    Set<String> dictionary = new HashSet<>();

    int maxLen = 0;
    int minLen = Integer.MAX_VALUE;
    for(String w : words) {
      int l = w.length();
      maxLen = Math.max(maxLen, l);
      minLen = Math.min(minLen, l);
      dictionary.add(w);
      Set<String> s = lenToWords.getOrDefault(l, new HashSet<>());
      s.add(w);
      lenToWords.put(l, s);
    }

    // from the longest word find its predecessor
    HashMap<String, Set<String>> wordToPredecessors = new HashMap<>();
    for(int i = maxLen; i > 1; i--) {
      Set<String> set = lenToWords.get(i);
      if (set == null) {
        continue;
      }
      for(String s : set) {
        Set<String> p = getPredecessors(s);
        for(String w : p) {
          if (dictionary.contains(w)) {
            Set<String> saved = wordToPredecessors.getOrDefault(s, new HashSet<>());
            saved.add(w);
            wordToPredecessors.put(s, saved);
          }
        }
      }
    }


    Map<String, Integer> wordToNum = new HashMap<>();
    for(String s : lenToWords.get(minLen)) {
      wordToNum.put(s, 1);
    }

    int result = 1;
    for(int i = minLen+1; i <= maxLen; i++) {
      if (lenToWords.get(i) == null) {
        continue;
      }
      for(String w : lenToWords.get(i)) {
        Set<String> predecessors = wordToPredecessors.getOrDefault(w, new HashSet<>());
        int maxPre = 1;
        for(String p : predecessors) {
          int chainLength = wordToNum.get(p);
          maxPre = Math.max(maxPre, chainLength+1);
        }
        wordToNum.put(w, maxPre);
        result = Math.max(result, maxPre);
      }
    }

    return result;
  }

  public Set<String> getPredecessors(String s) {
    if (s.length() < 2) {
      return new HashSet<>();
    }
    Set<String> result = new HashSet<>();
    for(int i = 0; i < s.length(); i++) {
      if (i == 0) {
        result.add(s.substring(i+1));
      } else if (i == s.length()-1) {
        result.add(s.substring(0, s.length()-1));
      } else {
        result.add(s.substring(0, i) + s.substring(i+1));
      }
    }
    return result;
  }
}
