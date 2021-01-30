package com.myrj.app.easy;


import java.util.HashMap;

/**
 * https://leetcode.com/problems/logger-rate-limiter/
 * */
public class Question359 {

  public static class Logger {
    HashMap<String, Integer> history;

    /** Initialize your data structure here. */
    public Logger() {
      history = new HashMap<>();
    }

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
     If this method returns false, the message will not be printed.
     The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
      boolean result = false;
      if (history.containsKey(message)) {
        if (history.get(message) <= timestamp - 10) {
          history.put(message, timestamp);
          return true;
        }
      } else {
        history.put(message, timestamp);
        result = true;
      }

      return result;
    }
  }
}
