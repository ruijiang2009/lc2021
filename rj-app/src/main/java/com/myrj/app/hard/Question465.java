package com.myrj.app.hard;

import java.util.HashMap;
import java.util.Map;

public class Question465 {

  public int minTransfers(int[][] transactions) {

    // record the final balance for each person
    Map<Integer, Long> balanceMap = new HashMap<>();
    for(int[] transaction : transactions) {
      Long value = balanceMap.getOrDefault(transaction[0], 0L);
      balanceMap.put(transaction[0], value - transaction[2]);
      value = balanceMap.getOrDefault(transaction[1], 0L);
      balanceMap.put(transaction[1], value + transaction[2]);
    }

    balanceMap.entrySet().removeIf(entry -> entry.getValue() == 0);
    if (balanceMap.isEmpty()) {
      return 0;
    }

    long[] balance = new long[balanceMap.keySet().size()];
    int i = 0;
    for(Integer key : balanceMap.keySet()) {
      balance[i] = balanceMap.get(key);
      i++;
    }
    return helper(0, balance, 0);
  }

  private int helper(int startIdx, long[] balance, int curCounter) {
    int len = balance.length;

    while(startIdx < len && balance[startIdx] == 0) {
      startIdx++;
    }
    if (startIdx == len) {
      return curCounter;
    }
    int counter = Integer.MAX_VALUE;
    for(int i = startIdx + 1; i < len; i++) {
      if ((balance[i] < 0 && balance[startIdx] > 0) || (balance[i] > 0 && balance[startIdx] < 0)) {
        balance[i] += balance[startIdx];
        // counter += 1;
        counter = Math.min(counter, helper(startIdx+1, balance, curCounter+1));
        // helper(startIdx+1, balance);
        balance[i] -= balance[startIdx];
      }
    }
    return counter;
  }
}
