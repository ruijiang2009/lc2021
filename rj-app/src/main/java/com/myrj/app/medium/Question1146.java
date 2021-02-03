package com.myrj.app.medium;

import java.util.*;

public class Question1146 {
  class SnapshotArray {
    List<TreeMap<Integer, Integer>> arr;
    int currId = 0;

    public SnapshotArray(int length) {
      arr = new ArrayList();

      for (int i = 0; i < length; i++) {
        arr.add(i, new TreeMap<Integer, Integer>());
        arr.get(i).put(0, 0);
      }
    }

    public void set(int index, int val) {
      arr.get(index).put(currId, val);
    }

    public int snap() {
      return currId++;
    }

    public int get(int index, int snap_id) {
      return arr.get(index).floorEntry(snap_id).getValue();
    }
  }
}
