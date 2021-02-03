package com.myrj.app.medium;

import java.text.StringCharacterIterator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Question792 {
  public int numMatchingSubseq(String S, String[] words) {
    Map<Character, List<StringCharacterIterator>> scanStatus = new HashMap<>();

    // create scan tree
    for(String word : words) {
      List<StringCharacterIterator> characterIterators = scanStatus.getOrDefault(word.charAt(0), new ArrayList<>());
      characterIterators.add(new StringCharacterIterator(word));
      scanStatus.put(word.charAt(0), characterIterators);
    }

    // start scan
    int result = 0;
    for(Character c : S.toCharArray()) {
      List<StringCharacterIterator> needToCompare = scanStatus.get(c);
      scanStatus.put(c, new ArrayList<>());
      for(StringCharacterIterator iterator : needToCompare) {
        Character next = iterator.next();
        if (next == iterator.DONE) { // reach the end of word
          result ++;
        } else {
          List<StringCharacterIterator> nextList = scanStatus.getOrDefault(next, new ArrayList<>());
          scanStatus.put(next, nextList);
          nextList.add(iterator);
        }
      }
    }

    return result;
  }

  public int numMatchingSubseqList(String S, String[] words) {
    List<List<StringCharacterIterator>> scanStatus = new ArrayList<>(128);
    for(int i = 0; i < 128; i++) {
      scanStatus.add(new ArrayList<>());
    }

    // create scan tree
    for(String word : words) {
      List<StringCharacterIterator> characterIterators = scanStatus.get(word.charAt(0));
      characterIterators.add(new StringCharacterIterator(word));
    }

    // start scan
    int result = 0;
    for(Character c : S.toCharArray()) {
      List<StringCharacterIterator> needToCompare = scanStatus.get(c);
      scanStatus.set(c, new ArrayList<>()); // clear old status
      for(StringCharacterIterator iterator : needToCompare) {
        Character next = iterator.next();
        if (next == iterator.DONE) { // reach the end of word
          result ++;
        } else {
          List<StringCharacterIterator> nextList = scanStatus.get(next);
          nextList.add(iterator);
        }
      }
    }

    return result;
  }


  public int numMatchingSubseqSolution(String S, String[] words) {
    List<StringCharacterIterator>[] waiting = new List[128];
    for (int c = 0; c <= 'z'; c++) {
      waiting[c] = new ArrayList();
    }
    for (String w : words)
      waiting[w.charAt(0)].add(new StringCharacterIterator(w));
    for (char c : S.toCharArray()) {
      List<StringCharacterIterator> advance = waiting[c];
      waiting[c] = new ArrayList();
      for (StringCharacterIterator it : advance) {
        // This means the search read the end. When it's end, the mid will be 0.
        int mid = it.next() % it.DONE;
        waiting[mid].add(it);
      }
    }
    return waiting[0].size();
  }
}
