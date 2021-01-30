package com.myrj.app.medium;

/**
 * https://leetcode.com/problems/max-area-of-island/
 * */
public class Question695 {

  public int maxAreaOfIsland(int[][] grid) {
    if (grid == null || grid.length == 0) {
      return 0;
    }
    int height = grid.length;
    int width = grid[0].length;
    int max = 0;
    for (int row = 0; row < height; row++) {
      for (int column = 0; column < width; column++ ) {
        if (grid[row][column] == 1) {
          int area = dfs(grid, row, column, height, width, 0);
          max = Math.max(area, max);
        }
      }
    }
    return max;
  }

  public int dfs(int[][] grid, int row, int column, int height, int width, int area) {
    if (row < 0 || column < 0 || column >= width || row >= height || grid[row][column] == 0) {
      return area;
    }
    grid[row][column] = 0; // changed to ocean
    area++;
    area = dfs(grid, row+1, column, height, width, area);
    area = dfs(grid, row, column+1, height, width, area);
    area = dfs(grid, row-1, column, height, width, area);
    area = dfs(grid, row, column-1, height, width, area);
    return area;
  }
}
