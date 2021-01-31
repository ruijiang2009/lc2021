package com.myrj.app.medium;

/**
 * https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/
 * Solution: https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/discuss/598111/Java-dp-solution(explanation-with-picture)
 *
 * */
public class Question1423 {
  public int maxScore(int[] cardPoints, int k) {
    int n = cardPoints.length;
    int[] leftPrefixSum = new int[n];
    int[] rightPrefixSum = new int[n];
    int leftSum = 0;
    int rightSum = 0;
    for(int i = 0; i < n; i++) {
      leftSum += cardPoints[i];
      leftPrefixSum[i] = leftSum;
      rightSum += cardPoints[n-1-i];
      rightPrefixSum[i] = rightSum;
    }
    int max = 0;
    for(int i = 0; i < k-1; i++) {
      int sum = leftPrefixSum[i] + rightPrefixSum[k-i-2];
      max = Math.max(sum, max);
    }
    max = Math.max(leftPrefixSum[k-1], max);
    max = Math.max(rightPrefixSum[k-1], max);
    return max;
  }

  // solution 1: recursion
  public int maxScoreRecursive(int[] cardPoints, int k) {
    if (cardPoints == null || cardPoints.length == 0 || k == 0) {
      return 0;
    }
    return getMax(cardPoints, 0, cardPoints.length-1, k);
  }

  public int getMax(int[] cardPoints, int left, int right, int stepsLeft) {
    if (stepsLeft == 1) {
      if (right < left) {
        return 0;
      }
      if (left <= right) {
        return Math.max(cardPoints[left], cardPoints[right]);
      }
    }
    int leftMax = cardPoints[left] + getMax(cardPoints, left+1, right, stepsLeft-1);
    int rightMax = cardPoints[right] + getMax(cardPoints, left, right-1, stepsLeft-1);
    return Math.max(leftMax, rightMax);
  }
}
