package Array;

/**
 * Created by lixiaojian on 2016/10/25.
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
        int max = nums[0];
        int secMax = nums[0];
        int thirdMax = nums[0];
        for (int i = 1; i <nums.length ; i++) {
            if (nums[i] > thirdMax) {
                thirdMax = nums[i];
            }
            if (thirdMax > secMax) {
                swap(thirdMax,secMax);
            }
            if (secMax > max) {
                swap(secMax,max);
            }
        }
        return thirdMax;
    }

    private static void swap(int thirdMax, int secMax) {
        int tmp = thirdMax;
        thirdMax = secMax;
        secMax = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        System.out.println(thirdMax(arr));
    }

}
