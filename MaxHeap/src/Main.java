import java.util.Random;

public class Main {

    private static double testHeap(Integer[] testData, boolean isHeapify) {

        long startTime = System.nanoTime();

        MaxHeap<Integer> maxHeap;
        if (isHeapify) {
            maxHeap = new MaxHeap<>(testData);
        } else {
            maxHeap = new MaxHeap<>();
            for (int i = 0; i < testData.length; i++) {
                maxHeap.add(testData[i]);
            }
        }
        long endTime = System.nanoTime();

        // 验证堆的正确性
        int[] arr = new int[testData.length];
        for (int i = 0; i < testData.length; i++) {
            arr[i] = maxHeap.extractMax();
        }

        for (int i = 1; i < testData.length; i++) {
            if (arr[i - 1] < arr[i]) {
                throw new RuntimeException("ERROR!");
            }
        }
        System.out.println("MaxHeap OK.");
        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        final int n = 1000000;

        Random random = new Random();
        Integer[] testData = new Integer[n];
        for (int i = 0; i < n; i++) {
            testData[i] = random.nextInt(Integer.MAX_VALUE);
        }

        double time1 = testHeap(testData, false);
        System.out.println(String.format("DO NOT Heapify: %f s", time1));

        double time2 = testHeap(testData, true);
        System.out.println(String.format("DO Heapify: %f s", time2));
    }
}
