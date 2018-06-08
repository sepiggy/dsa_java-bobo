/**
 * 第三版 UnionFind3
 */
public class UnionFind3 implements UF {

    private int[] parent;
    private int[] sz; // sz[i] 表示以 i 为根的集合中元素的个数

    public UnionFind3(int size) {

        parent = new int[size];
        sz = new int[size];

        for (int i = 0; i < size; i++) {
            parent[i] = i;
            sz[i] = 1;
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

        if (sz[pRoot] < sz[qRoot]) {
            parent[pRoot] = qRoot;
            sz[qRoot] += sz[pRoot];
        } else { // sz[qRoot] <= sz[pRoot]
            parent[qRoot] = pRoot;
            sz[pRoot] += sz[qRoot];
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
