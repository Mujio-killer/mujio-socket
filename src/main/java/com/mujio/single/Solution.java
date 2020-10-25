package com.mujio.single;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个整数数组和一个正整数k，数组长度＜10000，如果能分成k个子集，每个子集的和相同，这时候就返回true，否则false
 */
class Solution {
    public boolean ableToBeDivideByK(int[] nums, int k) {
        int sum = 0;
        int max = 0;
        // 求和，找出最大值
        for (int temp : nums) {
            sum += temp;
            if (max < temp) {
                max = temp;
            }
        }

        //sum = mk ,m为子集和
        if (sum % k != 0) {
            return false;
        }
        int m = sum / k;
        if (m*k != sum){
            return false;
        }

        Arrays.sort(nums);
        List<Integer> list = new ArrayList();
        for (int i = nums.length - 1; i >= 0; i--) {
            list.add(nums[i]);
        }
        return check(list, 0, k, m);
    }

    private boolean check(List<Integer> list, int sum, int count, int target) {
        if (count == 0) {
            return true;
        }
        for (int i = 0; i < list.size(); i++) {
            if (sum + list.get(i) == target) {
                int temp = list.remove(i);
                if (check(list, 0, count - 1, target)) {
                    return true;
                } else {
                    list.add(i, temp);
                }
            } else if (sum + list.get(i) < target) {
                int temp = list.remove(i);
                if (check(list, sum + temp, count, target)) {
                    return true;
                } else {
                    list.add(i, temp);
                }
            }
        }
        return false;
    }
}