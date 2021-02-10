package com.myrj.app.hard;

import java.util.HashSet;
import java.util.Set;

public class Question489 {

  public static class Robot {
    public void turnLeft() {}
    public void turnRight() {}

    public void clean() {}

    public boolean move() {
      return false;
    }
  }

  final int[][] directions = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};

  public static class OffSet {
    int x;
    int y;

    public OffSet(int x, int y) {
      this.x = x;
      this.y = y;
    }

    @Override
    public boolean equals(Object o) {
      // self check
      if (this == o)
        return true;
      // null check
      if (o == null)
        return false;
      OffSet other = (OffSet)o;
      return this.x == other.x && this.y == other.y;
    }
  }

  // dfs
  private void clean(Robot robot, Set<OffSet> visited, int curDirection, int row, int col) {
    OffSet offset = new OffSet(row, col);
    visited.add(offset);
    robot.clean();
    for(int i=0; i<4;++i){
      int direction = (curDirection+i) % 4;
      int [] next = directions[direction];
      int nextRow = row+next[0];
      int nextCol = col+next[1];
      offset = new OffSet(nextRow, nextCol);
      visited.add(offset);
      if(!visited.contains(offset) && robot.move()){
        clean(robot, visited, direction, nextRow, nextCol);
        // move back to the old position
        robot.turnLeft();
        robot.turnLeft();
        robot.move();
        robot.turnLeft();
        robot.turnLeft();
      }
      // either move left or right
      robot.turnRight();
    }

  }


  public void cleanRoom(Robot robot) {
    Set<OffSet> offset = new HashSet<>();
    clean(robot, offset, 0, 0,0);
  }
}
