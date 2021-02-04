package com.myrj.app.medium;

public class Question562 {
  final int HORIZONTAL = 0;
  final int VERTICAL = 1;
  final int DIAGONAL = 2;
  final int ANTI_DIAGONAL = 3;


  public int longestLine(int[][] M) {
    if (M == null || M.length == 0 || M[0] == null || M[0].length == 0) {
      return 0;
    }
    int max = 0;
    int height = M.length;
    int width = M[0].length;
    int[][][] result = new int[4][M.length][M[0].length];
    for(int row = 0; row < M.length; row++) {
      for(int col = 0; col < M[0].length; col++) {
        if (col == 0 && row == 0) {
          max = Math.max(max, M[row][col]);
          result[HORIZONTAL][row][col] = M[row][col];
          result[VERTICAL][row][col] = M[row][col];
          result[DIAGONAL][row][col] = M[row][col];
          result[ANTI_DIAGONAL][row][col] = M[row][col];
        } else if (col == 0 || row == 0) {
          result[DIAGONAL][row][col] = M[row][col];
          if (row > 0 && col + 1 < width) {
            result[ANTI_DIAGONAL][row][col] = M[row][col] == 0 ? 0 : result[ANTI_DIAGONAL][row - 1][col + 1] + 1;
          } else {
            result[ANTI_DIAGONAL][row][col] = M[row][col];
          }
          if (col == 0) {
            result[VERTICAL][row][col] = M[row][col] == 0 ? 0 : result[VERTICAL][row-1][col]+1;
            result[HORIZONTAL][row][col] = M[row][col];
          }
          if (row == 0) {
            result[HORIZONTAL][row][col] = M[row][col] == 0 ? 0 : result[HORIZONTAL][row][col-1]+1;
            result[VERTICAL][row][col] = M[row][col];
          }
        } else {
          if(M[row][col] == 1) {
            result[HORIZONTAL][row][col] = result[HORIZONTAL][row][col-1] + 1;
            result[VERTICAL][row][col] = result[VERTICAL][row-1][col] + 1;
            result[DIAGONAL][row][col] = result[DIAGONAL][row-1][col-1] + 1;
            if (col + 1 < width ) {
              result[ANTI_DIAGONAL][row][col] = result[ANTI_DIAGONAL][row - 1][col + 1] + 1;
            }
          } else {
            result[HORIZONTAL][row][col] = 0;
            result[VERTICAL][row][col] = 0;
            result[DIAGONAL][row][col] = 0;
            result[ANTI_DIAGONAL][row][col] = 0;
          }
        }
        max = Math.max(max, result[HORIZONTAL][row][col]);
        max = Math.max(max, result[VERTICAL][row][col]);
        max = Math.max(max, result[DIAGONAL][row][col]);
        max = Math.max(max, result[ANTI_DIAGONAL][row][col]);
      }
    }

    return max;
  }

}
