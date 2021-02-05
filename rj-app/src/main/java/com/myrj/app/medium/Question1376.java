package com.myrj.app.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Question1376 {

  public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
    Map<Integer, List<Integer>> managerToEmployeesMap = new HashMap<>();
    for(int i = 0; i < manager.length; i++) {
      List<Integer> employees = managerToEmployeesMap.getOrDefault(manager[i], new ArrayList<>());
      employees.add(i);
      managerToEmployeesMap.put(manager[i], employees);
    }

    return dfs(managerToEmployeesMap, informTime, headID);
  }

  public int dfs(Map<Integer, List<Integer>> managerToEmployeesMap, int[] informTime, int cur) {
    int max = 0;
    if(!managerToEmployeesMap.containsKey(cur)) {
      return max;
    }
    for(int i = 0; i < managerToEmployeesMap.get(cur).size(); i++) {
      max = Math.max(max, dfs(managerToEmployeesMap, informTime, managerToEmployeesMap.get(cur).get(i)));
    }
    return max + informTime[cur];
  }
}
