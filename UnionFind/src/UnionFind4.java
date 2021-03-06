/**
 * 第四版 UnionFind4
 * 考虑 Size
 */
public class UnionFind4 implements UF {

    private int[] parent;
    private int[] rank; // rank[i] 表示以 i 为根的集合所表示的树的层数

    public UnionFind4(int size) {

        parent = new int[size];
        rank = new int[size];

        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    @Override
    public int getSize() {
        return parent.length;
    }

    /**
     * O(h)
     *
     * @param p
     * @param q
     * @return
     */
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public void unionElements(int p, int q) {

        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot) {
            return;
        }

        if (rank[pRoot] < rank[qRoot]) {
            parent[pRoot] = qRoot;
        } else if (rank[qRoot] < rank[pRoot]) {
            parent[qRoot] = pRoot;
        } else {
            parent[qRoot] = pRoot;
            rank[pRoot] += 1;
        }
    }

    /**
     * 查找过程, 查找元素 p 所对应的集合编号
     * 复杂度为 O(h), h 为树的高度
     *
     * @param p
     * @return
     */
    private int find(int p) {

        if (p < 0 && p >= parent.length) {
            throw new IllegalArgumentException("p is out of bound.");
        }

        while (p != parent[p])
            p = parent[p];
        return p;
    }
}
