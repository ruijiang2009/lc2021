package com.myrj.app.medium;

public class Question256 {
  public int minCost(int[][] costs) {
    if (costs == null || costs.length == 0) {
      return 0;
    }
    int numberOfHouses = costs.length;
    int[][] results = new int[numberOfHouses][3];
    for(int i = 0; i < numberOfHouses; i++) {
      if (i == 0) {
        results[i][0] = costs[i][0];
        results[i][1] = costs[i][1];
        results[i][2] = costs[i][2];
      } else {
        results[i][0] = Math.min(costs[i][0] + results[i-1][1],
                                 costs[i][0] + results[i-1][2]);
        results[i][1] = Math.min(costs[i][1] + results[i-1][0],
                                 costs[i][1] + results[i-1][2]);
        results[i][2] = Math.min(costs[i][2] + results[i-1][0],
                                 costs[i][2] + results[i-1][1]);
      }
    }

    return Math.min(Math.min(results[numberOfHouses-1][0],
                             results[numberOfHouses-1][1]),
                    results[numberOfHouses-1][2]);
  }
}
