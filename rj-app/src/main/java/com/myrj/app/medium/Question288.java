package com.myrj.app.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Question288 {

  class ValidWordAbbr {
    Map<String, Set<String>> records = new HashMap<>();

    public ValidWordAbbr(String[] dictionary) {
      for(String d : dictionary) {
        String abbr = getAbbr(d);
        Set<String> words = records.getOrDefault(abbr, new HashSet<>());
        words.add(d);
        records.put(abbr, words);
      }
    }

    public boolean isUnique(String word) {
      String abbr = getAbbr(word);
      Set<String> words = records.get(abbr);
      if (words == null) {
        return true;
      }
      if (words.size() == 1 && words.contains(word)) {
        return true;
      }
      return false;
    }

    private String getAbbr(String word) {
      if (word.length() <= 2) {
        return word;
      }
      return word.charAt(0) + Integer.toString(word.length()-2) + word.charAt(word.length() - 1);
    }


  }

/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
 * boolean param_1 = obj.isUnique(word);
 */
}
