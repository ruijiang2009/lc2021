package com.myrj.app.hard;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Question715 {

  public static class RangeModule {
    TreeMap<Integer, Integer> treeMap = new TreeMap<>();
    public RangeModule() {

    }

    public void addRange(int left, int right) {
      if (left >= right) {
        return;
      }
      Integer start = treeMap.floorKey(left);
      Integer end = treeMap.floorKey(right);
      if (start == null && end == null) {
        // no over lap to both left and right
        treeMap.put(left, right);
      } else if (start != null && treeMap.get(start) >= left) {
          // start has overlap
          treeMap.put(start, Math.max(treeMap.get(start), Math.max(right, treeMap.get(end))));
      } else {
        // no over lap to start
        // 1. overlap with end
        treeMap.put(left, Math.max(right, treeMap.get(end)));
      }
      // clean up intermediate intervals
      Map<Integer, Integer> subMap = treeMap.subMap(left, false, right, false);
      Set<Integer> set = new HashSet(subMap.keySet());
      treeMap.keySet().removeAll(set);
    }

    public boolean queryRange(int left, int right) {
      Integer start = treeMap.floorKey(left);
      if (start == null) {
        return false;
      }
      return treeMap.get(start) >= right;
    }

    public void removeRange(int left, int right) {
      if (right <= left) {
        return;
      }
      Integer start = treeMap.floorKey(left);
      Integer end = treeMap.floorKey(right);
      if (end != null && treeMap.get(end) > right) {
        treeMap.put(right, treeMap.get(end));
      }
      if (start != null && treeMap.get(start) > left) {
        treeMap.put(start, left);
      }
      // clean up intermediate intervals
      Map<Integer, Integer> subMap = treeMap.subMap(left, true, right, false);
      Set<Integer> set = new HashSet(subMap.keySet());
      treeMap.keySet().removeAll(set);
    }
  }

/**
 * Your RangeModule object will be instantiated and called as such:
 * RangeModule obj = new RangeModule();
 * obj.addRange(left,right);
 * boolean param_2 = obj.queryRange(left,right);
 * obj.removeRange(left,right);
 */
}
