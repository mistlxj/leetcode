package Array;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/10/27.
 * @author lixiaojian
 * @source https://leetcode.com/problems/two-sum/
 */
public class TwoSum1 {
//    Given an array of integers, return indices of the two numbers such that they add up to a specific target.
//
//    You may assume that each input would have exactly one solution.
//
//    Example:
//    Given nums = [2, 7, 11, 15], target = 9,
//
//    Because nums[0] + nums[1] = 2 + 7 = 9,
//    return [0, 1].

    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        for (int i=0;i<nums.length;i++) {
            map.put(nums[i],i);
        }
        for (int i=0;i<nums.length;i++) {
            if (null != map.get(target-nums[i]) && i != map.get(target-nums[i])) {
                int[] arr = {i,map.get(target-nums[i])};
                res = arr;
                break;
            }
        }
        return res;
    }
}
