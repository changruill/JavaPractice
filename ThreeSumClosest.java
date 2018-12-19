package learning;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class ThreeSumClosest {
    public static int threeSumClosest(int[] nums, int target) {
        if (nums.length < 3)
            return 0;

        int mindiff = Integer.MAX_VALUE;
        int ans = 0;

        Arrays.sort(nums);
        Set<Integer> set = new TreeSet<>();

        for (int i = 0; i <= nums.length - 3 && mindiff != 0; i++) {
            if (nums[i] >= 0 && nums[i] >= target) {
                // 三数都大于等于target，最接近的值为最小的三数相加
                if (Math.abs(nums[i] + nums[i + 1] + nums[i + 2] - target) < mindiff) {
                    ans = nums[i] + nums[i + 1] + nums[i + 2];
                }
                break;
            }
            if (set.contains(nums[i])) {
                continue;
            }
            set.add(nums[i]);
            int newtarget = target - nums[i];
            int j = i + 1, k = nums.length - 1;
            while (j < k && mindiff != 0) {
                if (Math.abs(nums[j] + nums[k] - newtarget) < mindiff) {
                    ans = nums[i] + nums[j] + nums[k];
                    mindiff = Math.abs(nums[j] + nums[k] - newtarget);
                }
                int pj = j, pk = k;
                if (nums[j] + nums[k] > newtarget) {
                    while (j < k && nums[k] == nums[pk]) {
                        k--;
                    }
                } else {
                    while (j < k && nums[j] == nums[pj]) {
                        j++;
                    }
                }
            }
        }

        return ans;
    }
}
