package com.myrj.app.medium;

public class Question1774 {

    int result = -1;
    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
      int toppingNum = toppingCosts.length;
      for(int baseCost : baseCosts) {
        // when there is no topping
        result = Math.abs(baseCost - target) < Math.abs(result - target) ? baseCost : result;
        if (result == target) {
          return result;
        }
        choseTopping(toppingCosts, baseCost, target, 0);
      }

      return result;
    }

    private void updateResult(int newValue, int target) {
      if (result == -1) {
        result = newValue;
      } else {
        if (Math.abs(newValue - target) < Math.abs(result - target)) {
          result = newValue;
        } else if (Math.abs(newValue - target) ==  Math.abs(result - target)) {
          result = Math.min(newValue, result);
        }
      }
    }

    // usedTopping maximum is 2;
    private void choseTopping(int[] toppingCosts, int currentPrice, int target, int toppingIndex) {
      updateResult(currentPrice, target);
      if (toppingIndex >= toppingCosts.length || currentPrice >= target) {
        return;
      }
      choseTopping(toppingCosts, currentPrice, target, toppingIndex+1);
      choseTopping(toppingCosts, currentPrice + toppingCosts[toppingIndex], target, toppingIndex+1);
      choseTopping(toppingCosts, currentPrice + toppingCosts[toppingIndex] * 2, target, toppingIndex+1);
    }
}
