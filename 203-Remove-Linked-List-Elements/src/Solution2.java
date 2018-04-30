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

    public static void main(String[] args) {

        int[] nums = {1, 2, 6, 3, 4, 5, 6};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode res = (new Solution2()).removeElements(head, 6);
        System.out.println(res);
    }
}
