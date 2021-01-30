package com.myrj.app.easy;

import java.util.LinkedList;

public class Question346 {

  class MovingAverage {
    LinkedList<Integer> list = new LinkedList<>();
    Double sum = 0.0;
    int size = 0;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
      this.size = size;
    }

    public double next(int val) {
      if (list.size() < size) {
        sum += val;
      } else {
        int remove = list.removeFirst();
        sum -= remove;
        sum += val;
      }
      list.add(val);
      return sum / (double)list.size();
    }
  }

}
