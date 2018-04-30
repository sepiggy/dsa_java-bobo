public class Solution2 {

    public ListNode removeElements(ListNode head, int val) {

        // 使用虚拟头结点的解法
        // 设置虚拟头结点
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.val == val) {
                ListNode removeNode = prev.next;
                prev.next = prev.next.next;
                removeNode.next = null;
            } else {
                prev = prev.next;
            }
        }

        return dummyHead.next;
    }

}
