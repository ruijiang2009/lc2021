package com.myrj.app.medium;

public class Question1055 {

  public int shortestWay(String source, String target) {
    int t = 0;
    int result = 0;
    while(t < target.length()) {
      int pt = t;
      for(int s = 0; s < source.length(); s++) {
        if (t < target.length() && source.charAt(s) == target.charAt(t)) {
          t++;
        } else {
          continue;
        }
      }
      result++;
      if (pt == t) {
        // means went through s and t didn't move, then it's impossible
        return -1;
      }

    }

    return result;
  }
}
