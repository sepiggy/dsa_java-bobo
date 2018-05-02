// 递归本质上是将原来的问题转化为更小的同一问题
// 注意递归算法的宏观语义
public class Sum {

    // 供用户使用
    public static int sum(int[] arr) {
        return sum(arr, 0);
    }

    // 计算 arr[l...n) 这个区间内所有数字的和
    private static int sum(int[] arr, int l) {
        // step1. 求解最基本问题
        if (l == arr.length) {
            return 0;
        }
        // step2. 把原问题转化成更小的问题
        return arr[l] + sum(arr, l + 1);
   }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(sum(nums));
    }

}
