package com.myrj.app.medium;

import java.util.*;

public class Question399 {

  private double findAnswer(Map<String, Map<String, Double>> graph, List<String> query) {
    String start = query.get(0);
    if (!graph.containsKey(start)) {
      return -1.0;
    }
    String end = query.get(1);
    if (end.equals(start)) {
      return 1.0;
    }
    Map<String, Double> next = graph.get(start);
    Queue<Map<String, Double>> queue = new LinkedList<>();
    Queue<Double> calQueue = new LinkedList<>();
    queue.add(next);
    calQueue.add(1.0);
    HashSet<String> visited = new HashSet<>();
    visited.add(start);

    while(!queue.isEmpty()) {
      Map<String, Double> n = queue.poll();
      Double c = calQueue.poll();
      for(String key : n.keySet()) {
        if (key.equals(end)) {
          return c * n.get(key);
        } else {
          if (!visited.contains(key)) {
            Map<String, Double> m = graph.get(key);
            if (m != null) {
              queue.add(m);
              calQueue.add(c * n.get(key));
            }
            visited.add(key);
          }
        }
      }
    }

    return -1.0;
  }

  public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
    if (equations == null || equations.isEmpty() || queries == null || queries.isEmpty()) {
      return null;
    }
    Map<String, Map<String, Double>> graph = new HashMap<>();
    int length = equations.size();
    for(int i = 0; i < length; i++) {
      List<String> edge = equations.get(i);
      double value = values[i];
      String start = edge.get(0);
      String end = edge.get(1);
      Map<String, Double> startChildren = graph.getOrDefault(start, new HashMap<>());
      startChildren.put(end, value);
      graph.put(start, startChildren);
      Map<String, Double> endChildren = graph.getOrDefault(end, new HashMap<>());
      if (value != 0.0) {
        endChildren.put(start, 1.0 / value);
      }
      graph.put(end, endChildren);
    }
    double[] result = new double[queries.size()];
    for(int i = 0; i < queries.size(); i++) {
      result[i] = findAnswer(graph, queries.get(i));
    }
    return result;
  }
}
