// leetcode 347 ( 使用自己的 PriorityQueue )

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Solution {

    public List<Integer> topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = getFrequent(nums);

        PriorityQueue<Freq> pq = new PriorityQueue<>();
        for (Integer key : map.keySet()) {
            if (pq.getSize() < k) {
                pq.enqueue(new Freq(key, map.get(key)));
            } else {
                if (map.get(key) > pq.getFront().freq) {
                    pq.dequeue();
                    pq.enqueue(new Freq(key, map.get(key)));
                }
            }
        }

        LinkedList<Integer> res = new LinkedList<>();
        while (!pq.isEmpty()) {
            res.add(pq.dequeue().e);
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
                return 1;
            } else if (this.freq > another.freq) {
                return -1;
            } else {
                return 0;
            }
        }
    }
}
