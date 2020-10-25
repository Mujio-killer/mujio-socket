package com.mujio.single;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description: Test
 * @Author: GZY
 * @Date: 2020/8/5
 */

public class Test {


    public boolean ableToBeDividedByK(int[] nums, int k) {
        Arrays.sort(nums);
        List<Integer> list = new ArrayList();
        for (int i = nums.length - 1; i >= 0; i--) {
            list.add(nums[i]);
        }

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
        if (m * k != sum) {
            return false;
        }


        return checkLast(list, 0, k, m);
    }

    public boolean checkLast(List<Integer> list, int sum, int k, int m) {
        // 1.中止条件 k=0
        if (k == 0) {
            return true;
        }

        // 2.
        for (int i = 0; i < list.size(); i++) {
            //3. 如果前i个和为m
            if (sum + list.get(i) == m) {
                // 4. 假设前k-1组和都为m，则第k组成立时返回true
                int remove = list.remove(i);
                if (checkLast(list, 0, k - 1, m)) {
                    return true;
                } else {
                    // 5.复原
                    list.add(i, remove);
                }

            } else {
                // 6. 假设第k组前i-1个元素和不等于m，则加上第i个元素时成立则返回true
                int remove = list.remove(i);
                if (checkLast(list, sum + remove, k, m)) {
                    return true;
                } else {
                    list.add(i, remove);
                }

            }

        }


        return false;
    }
}
