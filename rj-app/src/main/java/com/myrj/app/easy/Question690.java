package com.myrj.app.easy;


import java.util.*;

/**
 * https://leetcode.com/problems/employee-importance/
 * */
public class Question690 {
  class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
  }

  /**
   * Process:
   * 1. create a map from id=> importance & subordinates
   * 2. traverse the map based on id and keep on adding importance
   * */
  public int getImportance(List<Employee> employees, int id) {
    Map<Integer, Employee> map = new HashMap<>();
    for(Employee e : employees) {
      map.put(e.id, e);
    }

    int result = 0;
    Queue<Employee> queue = new LinkedList<>();
    queue.add(map.get(id));
    Employee e = null;
    while (!queue.isEmpty()) {
      e = queue.remove();
      result += e.importance;
      if (e.subordinates == null || e.subordinates.isEmpty()) {
        continue;
      }
      for(int i : e.subordinates) {
        queue.add(map.get(i));
      }
    }

    return result;
  }
}
