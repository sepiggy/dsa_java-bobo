public class UnionFind1 implements UF {

    private int[] id;

    public UnionFind1(int size) {

        id = new int[size];

        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
    }

    /**
     * 查看元素 p 和元素 q 是否所属同一个集合 <br>
     * O(1)
     */
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * 合并元素 p 和元素 q 所属的集合 <br>
     * O(n)
     *
     * @param p
     * @param q
     */
    @Override
    public void unionElements(int p, int q) {

        int pID = find(p);
        int qID = find(q);

        if (pID == qID) {
            return;
        }

        for (int i = 0; i < id.length; i++) {
            if (id[i] == pID) {
                id[i] = qID;
            }
        }
    }

    @Override
    public int getSize() {
        return id.length;
    }

    /**
     * 查找元素 p 所对应的集合编号
     * O(1)
     */
    private int find(int p) {

        if (p < 0 || p >= id.length) {
            throw new IllegalArgumentException("p is out of bound.");
        }

        return id[p];
    }
}
