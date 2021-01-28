package com.myrj.app.easy;

public class Question1736 {
  /**
   * https://leetcode.com/problems/latest-time-by-replacing-hidden-digits/
   * You are given a string time in the form of hh:mm, where some of the digits in the string are hidden (represented by ?).
   *
   * The valid times are those inclusively between 00:00 and 23:59.
   *
   * Return the latest valid time you can get from time by replacing the hidden digits.
   *
   *
   *
   * Example 1:
   *
   * Input: time = "2?:?0"
   * Output: "23:50"
   * Explanation: The latest hour beginning with the digit '2' is 23 and the latest minute ending with the digit '0' is 50.
   * Example 2:
   *
   * Input: time = "0?:3?"
   * Output: "09:39"
   * Example 3:
   *
   * Input: time = "1?:22"
   * Output: "19:22"
   * */
  private String maxHour(String str) {
    char first = str.charAt(0);
    char second = str.charAt(1);
    if (first == '?' && second == '?') {
      return "23";
    } else if (first == '?') {
      if (second <= '3' && second >= '0') {
        return "2" + str.substring(1, 2);
      } else {
        return "1" + str.substring(1, 2);
      }
    } else if (second == '?') {
      if (first == '2') {
        return "23";
      } else {
        return str.substring(0, 1) + "9";
      }
    } else {
      return str;
    }
  }

  private String maxMinute(String str) {
    char first = str.charAt(0);
    char second = str.charAt(1);
    if (first == '?' && second == '?') {
      return "59";
    } else if (first == '?') {
      return "5" + str.substring(1, 2);
    } else if (second == '?') {
      return str.substring(0, 1) + "9";
    } else {
      return str;
    }
  }

  public String maximumTime(String time) {
    if (time == null || time.length() != 5) {
      return "";
    }
    return String.format("%s:%s", maxHour(time.substring(0,2)), maxMinute(time.substring(3, 5)));
  }
}
