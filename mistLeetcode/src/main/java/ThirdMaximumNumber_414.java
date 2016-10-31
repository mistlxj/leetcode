import java.util.HashSet;
import java.util.Set;

/**
 * Created by lixiaojian on 2016/10/25.
 *
 * @source https://leetcode.com/problems/third-maximum-number/
 */
public class ThirdMaximumNumber_414 {
    /*
    Given a non-empty array of integers, return the third maximum number in this array. If it does not exist, return the maximum number. The time complexity must be in O(n).

    Example 1:
    Input: [3, 2, 1]

    Output: 1

    Explanation: The third maximum is 1.
    Example 2:
    Input: [1, 2]

    Output: 2

    Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
    Example 3:
    Input: [2, 2, 3, 1]

    Output: 1

    Explanation: Note that the third maximum here means the third maximum distinct number.
    Both numbers with value 2 are both considered as second maximum.
    */

    public static int thirdMax(int[] nums) {
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0],nums[1]);
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i <nums.length ; i++) {
            set.add(nums[i]);
            if (set.size() == 3) {
                break;
            }
        }
       int[] arr = new int[3];
        int cnt = 0;
        for (Integer e : set) {
            arr[cnt++] = e;
        }
        if (cnt==1) {
            return arr[0];
        }
        if (cnt == 2) {
            return Math.max(arr[0],arr[1]);
        }

        int max = Math.max(arr[2],Math.max(arr[0], arr[1]));
        int thirdMax = Math.min(arr[2], Math.min(arr[0], arr[1]));
        int secMax = arr[0] + arr[1] + arr[2] - max - thirdMax;

        for(int i = 0;i<nums.length;i++) {
            if(nums[i] == max || nums[i] == secMax || nums[i] == thirdMax) {
                continue;
            }else if(nums[i] > max) {
                thirdMax = secMax;
                secMax = max;
                max = nums[i];
            } else if(nums[i] > secMax) {
                thirdMax = secMax;
                secMax = nums[i];
            } else if(nums[i] > thirdMax) {
                thirdMax = nums[i];
            }else {
                continue;
            }
        }
        return thirdMax;
    }

    public static void main(String[] args) {
        int[] arr = {2,2,3,1};
        System.out.println(thirdMax(arr));
    }

}
