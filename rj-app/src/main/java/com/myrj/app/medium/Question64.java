package com.myrj.app.medium;

public class Question64 {

  public int minPathSum(int[][] grid) {
    int height = grid.length;
    int width = grid[0].length;
    int[][] opts = new int[height][width];
    opts[0][0] = grid[0][0];
    for(int i = 1; i < width; i++) {
      opts[0][i] = grid[0][i] + opts[0][i-1];
    }
    for(int i = 1; i < height; i++) {
      opts[i][0] = grid[i][0] + opts[i-1][0];
    }

    for(int i = 1; i < height; i++) {
      for (int j = 1; j < width; j++) {
        opts[i][j] = Math.min(opts[i-1][j] + grid[i][j], opts[i][j-1] + grid[i][j]);
      }
    }
    return opts[height-1][width-1];
  }
}
