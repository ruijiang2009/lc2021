package com.myrj.app.medium;

public class Question698 {


  public boolean canPartitionKSubsets(int[] nums, int k) {
    int sum = 0;
    for(int num : nums) {
      sum += num;
    }
    if (k <= 0 || sum % k != 0) {
      return false;
    }
    if (k == 1) {
      return true;
    }
    boolean[] visited = new boolean[nums.length];
    return canPatitionSubsets(nums, visited, k, sum/k, 0, 0, 0);
  }

  public boolean canPatitionSubsets(int[] nums, boolean[] visited, int k, int target, int curSum, int startIdx, int countNum) {
    if (k == 1) {
      return true;
    }
    if (curSum == target && countNum > 0) {
      return canPatitionSubsets(nums, visited, k-1, target, 0, 0, 0);
    }
    for(int i = startIdx; i < nums.length; i++) {
      if (!visited[i]) {
        visited[i] = true;
        if (canPatitionSubsets(nums, visited, k, target, curSum + nums[i], startIdx+1, countNum)) {
          return true;
        }
        countNum++;
        visited[i] = false;
      }
    }
    return false;
  }

  ////////////
  public boolean canPartitionKSubsets2(int[] nums, int k) {
    int sum = 0;
    for(int num:nums)sum += num;
    if(k <= 0 || sum%k != 0)return false;
    int[] visited = new int[nums.length];
    return canPartition2(nums, visited, 0, k, 0, 0, sum/k);
  }

  public boolean canPartition2(int[] nums, int[] visited, int start_index, int k, int cur_sum, int cur_num, int target){
    if(k==1) {
      return true;
    }
    if(cur_sum == target && cur_num>0) {
      return canPartition2(nums, visited, 0, k - 1, 0, 0, target);
    }
    for(int i = start_index; i < nums.length; i++){
      if(visited[i] == 0){
        visited[i] = 1;
        if(canPartition2(nums, visited, i+1, k, cur_sum + nums[i], cur_num, target)) {
          return true;
        }
        cur_num++;
        visited[i] = 0;
      }
    }
    return false;
  }
}
