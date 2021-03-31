public class MergeTwoLists {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        System.out.println(new MergeTwoLists().mergeTwoLists(l1, l2));
    }


    //my solution
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode mergeList;

        if (l1 == null && l2 == null)
            return head;
        else if (l1 == null || l2 == null) {
            if (l1 == null)
                return l2;
            else
                return l1;
        } else {
            if (l1.val <= l2.val) {
                mergeList = l1;
                l1 = l1.next;
            } else {
                mergeList = l2;
                l2 = l2.next;
            }
        }head = mergeList;

        while (l1 != null || l2 != null) {
            if (l1 == null) {
                mergeList.next = l2;
                l2 = l2.next;
            } else if (l2 == null) {
                mergeList.next = l1;
                l1 = l1.next;
            } else if (l1.val <= l2.val) {
                mergeList.next = l1;
                l1 = l1.next;
            } else {
                mergeList.next = l2;
                l2 = l2.next;
            }
            mergeList = mergeList.next;
        }
        return head;
    }
}

/* best solution_USE recursive
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
 */
