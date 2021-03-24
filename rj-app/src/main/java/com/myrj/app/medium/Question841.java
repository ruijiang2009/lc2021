package com.myrj.app.medium;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Question841 {

  public boolean canVisitAllRooms(List<List<Integer>> rooms) {
    HashSet<Integer> visited = new HashSet<>();
    HashSet<Integer> hasSeen = new HashSet<>();
    HashSet<Integer> finished = new HashSet<>();
    visited.add(0);
    hasSeen.add(0);
    return dfs(visited, hasSeen, finished, rooms, 0);
  }

  private boolean dfs(Set<Integer> visited, Set<Integer> hasSeen, Set<Integer> finished, List<List<Integer>> rooms, int startIdx) {
    if (hasSeen.size() == rooms.size()) {
      return true;
    }
    List<Integer> nextRooms = rooms.get(startIdx);
    for(Integer room : nextRooms) {
      hasSeen.add(room);
      if (!visited.contains(room) && !finished.contains(room)) {
        visited.add(room);
        if (dfs(visited, hasSeen, finished, rooms, room)) {
          return true;
        }
        visited.remove(room);
      }
    }
    finished.add(startIdx);
    return false;
  }
}
