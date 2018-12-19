package learning;

import java.util.*;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums, int target) {
        if (nums.length < 3) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);

        List<List<Integer>> list = new ArrayList<>();
        Set<Integer> set = new TreeSet<>();

        for (int i = 0; i <= nums.length - 3; i++) {
            if (nums[i] >= 0 && nums[i] > target)
                break;
            if (set.contains(nums[i]))
                continue;
            set.add(nums[i]);
            int newtarget = target - nums[i];
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                if (nums[j] + nums[k] == newtarget) {
                    List<Integer> group = new ArrayList<>();
                    group.add(nums[i]);
                    group.add(nums[j]);
                    group.add(nums[k]);
                    list.add(group);
                    // nums[j]和nums[k]的值必须都进行变化
                    int pj = j, pk = k;
                    while (j < k && nums[j] == nums[pj]) {
                        j++;
                    }
                    while (j < k && nums[k] == nums[pk]) {
                        k--;
                    }
                } else if (nums[j] + nums[k] < newtarget) {
                    j++;
                } else {
                    k--;
                }
            }

        }

        return list;

    }
}
