import java.util.Random;

public class MaxHeap<E extends Comparable<E>> {

    private Array<E> data;

    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }

    public MaxHeap() {
        data = new Array<>();
    }

    // 将一个数组构造为最大堆
    public MaxHeap(E[] arr) {

        data = new Array<>(arr);
        for (int i = parent(arr.length - 1); i >= 0; i--) {
            siftDown(i);
        }
    }


    // 返回堆中的元素个数
    public int size() {
        return data.getSize();
    }

    // 返回一个布尔值, 表示堆中是否为空
    public boolean isEmpty() {
        return data.isEmpty();
    }

    // 返回完全二叉树的数组表示中, 一个索引所表示的元素的父亲节点的索引
    private int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("index-0 does NOT have parent.");
        }
        return (index - 1) / 2;
    }

    // 返回完全二叉树的数组表示中, 一个索引所表示的元素的左孩子节点的索引
    private int leftChild(int index) {
        return index * 2 + 1;
    }

    // 返回完全二叉树的数组表示中, 一个索引所表示的元素的右孩子节点的索引
    private int rightChild(int index) {
        return index * 2 + 2;
    }

    // 向堆中添加元素
    public void add(E e) {
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    // 看堆中的最大元素
    public E findMax() {

        if (size() == 0) {
            throw new IllegalArgumentException("Can NOT find max when heap is EMPTY!");
        }

        return data.get(0);
    }

    // 取出堆中的最大元素
    public E extractMax() {

        E ret = findMax();

        // 第一个元素和最后一个元素交换位置
        data.swap(0, size() - 1);
        // 只是在数组中删除最大元素
        data.removeLast();

        // 维护最大堆的性质
        siftDown(0);

        return ret;
    }


    // 取出堆中的最大元素, 并且替换成元素 e
    public E replace(E e) {

        E ret = findMax();
        data.set(0, e);
        siftDown(0);
        return ret;
    }

    private void siftUp(int k) {

        while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0) {
            data.swap(k, parent(k));
            k = parent(k);
        }
    }

    private void siftDown(int k) {

        // k 所在位置是叶子节点, 循环结束
        while (leftChild(k) < size()) {

            /*
             * data[j] 是 leftChild 和 rightChild 中的最大值
             */
            int j = leftChild(k);
            // 判断是否有右孩子
            if (j + 1 < data.getSize() && data.get(j + 1).compareTo(data.get(j)) > 0) {
                j = rightChild(k);
            }

            if (data.get(k).compareTo(data.get(j)) >= 0) {
                break;
            }

            data.swap(k, j);
            k = j;
        }
    }


    public static void main(String[] args) {

        int n = 1000000;

        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            maxHeap.add(random.nextInt(Integer.MAX_VALUE));
        }

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = maxHeap.extractMax();
        }

        for (int i = 0; i < n - 1; i++) {
            if (arr[i] < arr[i + 1]) {
                throw new IllegalArgumentException("ERROR!");
            }
        }

        System.out.println("Test MaxHeap completed.");
        for (int i = 0; i < n; i++) {
            System.out.print(String.format("%d ", arr[i]));
        }
    }
}
