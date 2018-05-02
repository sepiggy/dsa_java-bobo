// 二分搜索树中存储的元素必须是可比较的!
public class BST<E extends Comparable<E>> {

    private class Node {
        public E e;
        public Node left, right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

//    public void add(E e) {
//        if (isEmpty()) {
//            root = new Node(e);
//        } else {
//            Node prev = root;
//            while (prev != null) {
//                if (e.compareTo(prev.e) < 0) {
//                    prev = prev.left;
//                }
//                if (e.compareTo(prev.e) > 0) {
//                    prev = prev.right;
//                }
//            }
//            if (e.compareTo(prev.e) < 0) {
//                prev = new Node(e);
//            }else{
//                prev = new Node(e);
//            }
//        }
//    }

    public void add(E e) {

        if (root == null) {
            root = new Node(e);
            size++;
        } else {
            add(root, e);
        }
    }

    // 向以 node 为根的二分搜索树中插入元素 E , 递归算法
    private void add(Node node, E e) {

        // step1. 写出最基本问题, 也就是递归终止条件
        if (e.compareTo(node.e) == 0) {
            return;
        } else if (e.compareTo(node.e) < 0 && node.left == null) {
            node.left = new Node(e);
            size++;
            return;
        } else if (e.compareTo(node.e) > 0 && node.right == null) {
            node.right = new Node(e);
            size++;
            return;
        }

        // step2. 把原问题转化为更小的问题
        if (e.compareTo(node.e) < 0) {
            add(node.left, e);
        } else {
            add(node.right, e);
        }
    }

}
