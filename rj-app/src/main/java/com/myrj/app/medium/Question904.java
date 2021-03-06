package com.myrj.app.medium;

public class Question904 {
  public int totalFruit(int[] tree) {
    int max = 0;
    int beg = 0;
    int end = 0;
    int first = -1;
    int second = -1;
    int firstRightMostIndex = 0;
    int secondRightMostIndex = 0;

    for(int i = 0; i < tree.length; i++) {
      int cur = tree[i];
      if (first == -1) {
        first = cur;
        firstRightMostIndex = i;
        beg = i;
        end = i;
      } else if (first != -1 && second == -1  && cur != first) {
        second = cur;
        secondRightMostIndex = i;
        end = i;
      } else if (first == cur || second == cur) {
        if (cur == first) {
          firstRightMostIndex = i;
        } else {
          secondRightMostIndex = i;
        }
        end = i;
      } else {
        // med 3rd fruit
        int pre = tree[i-1];
        if (pre == first) { // first is kept, second is updated to 3rd
          beg = secondRightMostIndex + 1;
        } else { // second is kept, first is updated to second, second updated to 3rd
          beg = firstRightMostIndex + 1;
          first = second;
          firstRightMostIndex = secondRightMostIndex;
        }
        second = cur;
        secondRightMostIndex = i;
        end = i;
      }
      max = Math.max(max, end - beg + 1);
    }
    return max;
  }
}
