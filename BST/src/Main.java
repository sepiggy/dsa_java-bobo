public class Main {

    public static void main(String[] args) {

        BST<Integer> bst = new BST<>();
        int[] nums = {5, 3, 6, 8, 4, 2};
        for (int num : nums) {
            bst.add(num);


//        System.out.println(bst);

//        bst.preOrder();

//        bst.inOrder();

//        bst.postOrder();

//        bst.preOrder();
//        System.out.println();
//        bst.preOrderNR();

        bst.levelQrder();

    }
}
