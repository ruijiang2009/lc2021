package com.myrj.app.medium;

public class Question279 {
  public int numSquares(int n) {
    int[] opts = new int[n+1];
    opts[0] = 0;
    for(int i = 1; i <= n; i++) {
      opts[i] = Integer.MAX_VALUE;
    }
    for(int i = 1; i <= n; i++) {
      for(int j = 1; i >= j*j; j++) {
        opts[i] = Math.min(opts[i - j*j] + 1, opts[i]);
      }
    }
    return opts[n];
  }
}
