package com.myrj.app.medium;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Question814Test {

  Question841 solution = new Question841();

  @Test
  public void test1() {
    List<List<Integer>> rooms = new ArrayList<>();
    List<Integer> room = new ArrayList<>();
    room.add(2);
    room.add(3);
    rooms.add(room);
    room = new ArrayList<>();
    rooms.add(room);
    room = new ArrayList<>();
    room.add(2);
    rooms.add(room);
    room = new ArrayList<>();
    room.add(1);
    room.add(3);
    room.add(1);
    rooms.add(room);
    boolean result = solution.canVisitAllRooms(rooms);
    Assert.assertTrue(result);
  }
}
