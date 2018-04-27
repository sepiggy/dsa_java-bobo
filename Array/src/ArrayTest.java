public class ArrayTest {

    public static void main(String[] args) {
        // 对于动态数组, 用户在声明的时候不必关心数组开辟的具体空间大小了.
        // 动态扩容的过程对用户来说是不可见的.
        Array<Integer> arr = new Array<>();
        for (int i = 0; i < 10; i++) {
            arr.addLast(i);
        }
        System.out.println(arr);

        arr.add(4, 999);
        System.out.println(arr);

        arr.addFirst(-1);
        System.out.println(arr);

        arr.remove(2);
        System.out.println(arr);

        arr.removeElement(999);
        System.out.println(arr);

        arr.removeFirst();
        System.out.println(arr);
    }
}
