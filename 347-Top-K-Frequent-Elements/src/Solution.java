import java.util.*;

public class Solution {

    public List<Integer> topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = getFrequent(nums);

        // Java 中实现的 PriorityQueue 是最小堆
        PriorityQueue<Freq> pq = new PriorityQueue<>();

        for (Integer key : map.keySet()) {

            if (pq.size() < k) {
                pq.add(new Freq(key, map.get(key)));
            } else if (map.get(key) > pq.peek().freq) {
                pq.remove();
                pq.add(new Freq(key, map.get(key)));
            }
        }

        LinkedList<Integer> res = new LinkedList<>();
        while (!pq.isEmpty()) {
            res.add(pq.remove().e);
        }
        return res;
    }

    private Map<Integer, Integer> getFrequent(int[] nums) {

        Map<Integer, Integer> frequentMap = new TreeMap<>();
        for (int num : nums) {
            if (!frequentMap.containsKey(num)) {
                frequentMap.put(num, 1);
            } else {
                frequentMap.put(num, frequentMap.get(num) + 1);
            }
        }
        return frequentMap;
    }

    private class Freq implements Comparable<Freq> {

        int e, freq;

        public Freq(int e, int freq) {
            this.e = e;
            this.freq = freq;
        }

        @Override
        public int compareTo(Freq another) {

            if (this.freq < another.freq) {
                return -1;
            } else if (this.freq > another.freq) {
                return 1;
            } else {
                return 0;
            }
        }
    }
}
