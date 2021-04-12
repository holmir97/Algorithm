// LeetCode_2
// 2020.04.12
// List, case work
// Medium

public class AddTwoNum {
    public static void main(String[] args) {
        new ListNode().printListNode(new AddTwoNum().addTwoNumbers(
                new ListNode(2, new ListNode(4, new ListNode(3))),
                new ListNode(5, new ListNode(6, new ListNode(4)))));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) throws NumberFormatException{
        long num1 = 0, num2 = 0;
        ListNode listNode = new ListNode();
        ListNode head = listNode;

        while (l1 != null) {
            num1 += l1.val;
            if (l1.next != null)
                num1 *= 10;
            l1 = l1.next;
        }
        while (l2 != null) {
            num2 += l2.val;
            if (l2.next != null)
                num2 *= 10;
            l2 = l2.next;
        }
        StringBuffer str1 = new StringBuffer(String.valueOf(num1));
        StringBuffer str2 = new StringBuffer(String.valueOf(num2));
        str1.reverse();
        str2.reverse();
        num1 = Long.valueOf(String.valueOf(str1));
        num2 = Long.valueOf(String.valueOf(str2));
        num1 += num2;


        while (num1 != 0) {
            listNode.val = num1 % 10;
            num1 /= 10;
            if (num1 == 0)
                break;
            listNode.next = new ListNode();
            listNode = listNode.next;
        }

        return head;
    }
}

// Best Solution-O(max(n,m))_출처 leetcode
//
//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        ListNode dummyHead = new ListNode(0);
//        ListNode p = l1, q = l2, curr = dummyHead;
//        int carry = 0;
//        while (p != null || q != null) {
//            int x = (p != null) ? p.val : 0;
//            int y = (q != null) ? q.val : 0;
//            int sum = carry + x + y;
//            carry = sum / 10;
//            curr.next = new ListNode(sum % 10);
//            curr = curr.next;
//            if (p != null) p = p.next;
//            if (q != null) q = q.next;
//        }
//        if (carry > 0) {
//            curr.next = new ListNode(carry);
//        }
//        return dummyHead.next;
//    }
