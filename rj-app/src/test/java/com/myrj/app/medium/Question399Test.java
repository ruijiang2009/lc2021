package com.myrj.app.medium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Question399Test {
  Question399 solution = new Question399();

  @Test
  public void test1() {
    List<List<String>> equations = new ArrayList<>();
    List<String> e1 = new ArrayList<>();
    e1.add("a"); e1.add("b");
    equations.add(e1);
    List<String> e2 = new ArrayList<>();
    e2.add("b"); e2.add("c");
    equations.add(e2);

    double[] values = {2.0, 3.0};

    List<List<String>> queries = new ArrayList<>();
    List<String> q1 = new ArrayList<>();
    q1.add("a"); q1.add("c");
    queries.add(q1);
    List<String> q2 = new ArrayList<>();
    q2.add("b"); q2.add("a");
    queries.add(q2);
    List<String> q3 = new ArrayList<>();
    q3.add("a"); q3.add("e");
    queries.add(q3);
    List<String> q4 = new ArrayList<>();
    q4.add("a"); q4.add("a");
    queries.add(q4);
    List<String> q5 = new ArrayList<>();
    q5.add("x"); q5.add("x");
    queries.add(q5);

    double[] result = solution.calcEquation(equations, values, queries);
    System.out.println("");
  }
}
