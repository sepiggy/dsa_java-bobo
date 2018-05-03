import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

//        BST<Integer> bst = new BST<>();
//        int[] nums = {5, 3, 6, 8, 4, 2};
//        for (int num : nums) {
//            bst.add(num);
//        }

//        System.out.println(bst);

//        bst.preOrder();

//        bst.inOrder();

//        bst.postOrder();

//        bst.preOrder();
//        System.out.println();
//        bst.preOrderNR();

//        bst.levelQrder();

//        System.out.println(bst.maximum());
//        System.out.println(bst.minimum());

        BST<Integer> bst = new BST<>();
        Random random = new Random();

        for (int i = 0; i < 1000; i++) {
            bst.add(random.nextInt(9999));
        }

        System.out.println(String.format("the size of BST is %d", bst.size()));
        ArrayList<Integer> nums = new ArrayList<>();
        while (!bst.isEmpty()) {
            nums.add(bst.removeMin());
        }

        System.out.println(nums);
        for (int i = 0; i < nums.size() - 1; i++) {
            if (nums.get(i) > nums.get(i + 1)) {
                throw new IllegalArgumentException("Error");
            }
        }
        System.out.println("removeMin test ok.");
    }
}
