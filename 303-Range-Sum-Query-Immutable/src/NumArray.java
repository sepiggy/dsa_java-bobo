class NumArray {

    private SegmentTree<Integer> segmentTree;

    public interface Merger<E> {
        E merge(E a, E b);
    }

    private class SegmentTree<E> {

        private E[] tree;
        private E[] data;
        private Merger<E> merger;

        // merger 由 SegmentTree 这个类的用户来指定
        public SegmentTree(E[] arr, Merger<E> merger) {

            this.merger = merger;

            data = (E[]) new Object[arr.length];
            for (int i = 0; i < arr.length; i++) {
                data[i] = arr[i];
            }

            tree = (E[]) new Object[4 * arr.length];
            buildSegmentTree(0, 0, arr.length - 1);
        }

        // 在 treeIndex 的位置创建表示区间 [l...r] 的线段树
        private void buildSegmentTree(int treeIndex, int l, int r) {

            // 递归到底的情况
            if (l == r) {
                tree[treeIndex] = data[l];
                return;
            }

            int leftChildIndex = leftChildIndex(treeIndex);
            int rightChildIndex = rightChildIndex(treeIndex);

            // 防止溢出, 使用 r - l
            int mid = l + (r - l) / 2;
            buildSegmentTree(leftChildIndex, l, mid);
            buildSegmentTree(rightChildIndex, mid + 1, r);

            // 综合左右线段的信息组合成更大线段的信息, 组合方式与业务逻辑有关, 通过 merger 字段指定
            tree[treeIndex] = merger.merge(tree[leftChildIndex], tree[rightChildIndex]);
        }

        public int getSize() {
            return data.length;
        }

        public E get(int index) {
            if (index < 0 || index >= data.length) {
                throw new IllegalArgumentException("Index is illegal.");
            }
            return data[index];
        }

        private int leftChildIndex(int index) {
            return 2 * index + 1;
        }

        private int rightChildIndex(int index) {
            return 2 * index + 2;
        }

        // 返回区间 [queryL, queryR] 的值
        public E query(int queryL, int queryR) {

            if (queryL < 0 || queryL >= data.length || queryR < 0 || queryR >= data.length || queryL > queryR) {
                throw new IllegalArgumentException("Index is illegal.");
            }

            return query(0, 0, data.length - 1, queryL, queryR);
        }

        // 在以 treeID 为根的线段树中 [l...r] 的范围里, 搜索区间 [queryL...queryR] 的值
        private E query(int treeIndex, int l, int r, int queryL, int queryR) {

            if (l == queryL && r == queryR) {
                return tree[treeIndex];
            }

            int mid = l + (r - l) / 2;
            int leftTreeIndex = leftChildIndex(treeIndex);
            int rightTreeIndex = rightChildIndex(treeIndex);

            if (queryL >= mid + 1) {
                return query(rightTreeIndex, mid + 1, r, queryL, queryR);
            } else if (queryR <= mid) {
                return query(leftTreeIndex, l, mid, queryL, queryR);
            } else {
                E leftResult = query(leftTreeIndex, l, mid, queryL, mid);
                E rightResult = query(rightTreeIndex, mid + 1, r, mid + 1, queryR);
                return merger.merge(leftResult, rightResult);
            }
        }

        @Override
        public String toString() {
            StringBuilder res = new StringBuilder();
            res.append('[');
            for (int i = 0; i < tree.length; i++) {
                if (tree[i] != null) {
                    res.append(tree[i]);
                } else {
                    res.append("null");
                }

                if (i != tree.length - 1) {
                    res.append(", ");
                }
            }
            res.append(']');
            return res.toString();
        }
    }

    public NumArray(int[] nums) {

        if (nums.length > 0) {
            Integer[] data = new Integer[nums.length];
            for (int i = 0; i < nums.length; i++) {
                data[i] = nums[i];
            }
            segmentTree = new SegmentTree<>(data, (a, b) -> a + b);
        }
    }

    public int sumRange(int i, int j) {

        if (segmentTree == null) {
            throw new IllegalArgumentException("Segment Tree is null");
        }

        return segmentTree.query(i, j);
    }
}
