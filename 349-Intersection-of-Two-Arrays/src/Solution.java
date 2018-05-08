import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class Solution {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> num1Set = new TreeSet<>();
        Set<Integer> num2Set = new TreeSet<>();

        for (int i : nums1) {
            num1Set.add(i);
        }

        for (int i : nums2) {
            num2Set.add(i);
        }

        ArrayList<Integer> intersection = new ArrayList<>();

        for (Integer integer : num1Set) {
            if (num2Set.contains(integer)) {
                intersection.add(integer);
            }
        }

        int[] res = new int[intersection.size()];
        for (int i = 0; i < intersection.size(); i++) {
            res[i] = intersection.get(i);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] intersection = (new Solution()).intersection(nums1, nums2);
        for (int i : intersection) {
            System.out.println(i);
        }
    }
}
