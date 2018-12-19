package learning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KSum {
    public static List<List<Integer>> kSum(int[] nums, int k, int target) {
        if (k > nums.length || k <= 0) {
            return new ArrayList<List<Integer>>();
        }

        Arrays.sort(nums);
        return kSumIter(nums, k, target, 0);
    }

    private static List<List<Integer>> kSumIter(int[] nums, int k, int target, int index) {
        List<List<Integer>> res = new ArrayList<>();

        if (index >= nums.length) {
            return res;
        }
        if (nums[index] > target && target >= 0) {
            return res;
        }

        if (k == 2) {
            for (int i = index, j = nums.length - 1; i < j; ) {
                if (nums[i] > target && target >= 0) {
                    break;
                }
                if (nums[i] + nums[j] == target) {
                    List<Integer> ltemp = new ArrayList<>();
                    ltemp.add(nums[i]);
                    ltemp.add(nums[j]);
                    res.add(ltemp);
                    while (i < j && nums[i] == nums[i + 1]) {
                        i++;
                    }
                    i++;
                    while (i < j && nums[j] == nums[j - 1]) {
                        j--;
                    }
                    j--;
                } else if (nums[i] + nums[j] < target) {
                    while (i < j && nums[i] == nums[i + 1]) {
                        i++;
                    }
                    i++;
                } else {
                    while (i < j && nums[j] == nums[j - 1]) {
                        j--;
                    }
                    j--;
                }
            }
        } else {
            for (int i = index; i < nums.length - k + 1; i++) {
                if (nums[i] > target && target >= 0) {
                    break;
                }
                List<List<Integer>> ltemp = kSumIter(nums, k - 1, target - nums[i], i + 1);
                if (!ltemp.isEmpty()) {
                    for (List<Integer> list : ltemp) {
                        list.add(nums[i]);
                    }
                    res.addAll(ltemp);
                }

                while (i < nums.length - k + 1 && nums[i] == nums[i + 1]) {
                    i++;
                }
            }
        }

        return res;
    }
}
