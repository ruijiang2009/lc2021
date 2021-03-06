package com.myrj.app.medium;

public class Question322 {
  public int coinChange(int[] coins, int amount) {
    if (amount == 0) {
      return 0;
    }
    int[] records = new int[amount+1];
    for(int i = 0; i <= amount; i++) {
      records[i] = Integer.MAX_VALUE;
    }
    records[0] = 0;

    for(int i = 1; i <= amount; i++) {
      for(int coin : coins) {
        int pre = i - coin;
        if(pre >= 0 && records[pre] != -1) {
          records[i] = Math.min(records[pre] + 1, records[i]);
        }
      }
      if (records[i] == Integer.MAX_VALUE) {
        records[i] = -1;
      }
    }
    return records[amount];
  }
}
