package com.myrj.app.hard;

public class Question42 {

  public int trap(int[] heights) {
    if (heights == null || heights.length <= 0) {
      return 0;
    }
    int result = 0;
    int left = 0;
    int maxLeft = 0;
    int maxRight = 0;
    int right = heights.length-1;
    while(left < right) {
      if (heights[left] < heights[right]) {
        if (heights[left] > maxLeft) {
          maxLeft = heights[left];
        } else {
          result += maxLeft - heights[left];
        }
        left++;
      } else {
        if (heights[right] > maxRight) {
          maxRight = heights[right];
        } else {
          result += maxRight - heights[right];
        }
        right--;
      }
    }

    return result;
  }
}
