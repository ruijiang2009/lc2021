package com.myrj.app.hard;

import org.junit.Test;

import java.util.List;

public class Question1548Test {
  Question1548 solution = new Question1548();

  @Test
  public void test1() {
    String[] names = {"ATL","PEK","LAX","DXB","HND"};
    int[][] roads = {{0,2},{0,3},{1,2},{1,3},{1,4},{2,4}};
    String[] targetPath = {"ATL","DXB","HND","LAX"};

    List<Integer> result = solution.mostSimilar(5, roads, names, targetPath);
    for(int i : result) {
      System.out.print(names[i] + "\t");
    }
  }
}
