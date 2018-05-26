/**
 * 用来指定线段树中两个元素的融合方式
 *
 * @param <E>
 */
public interface Merger<E> {
    E merge(E a, E b);
}
