import java.util.Stack;


// my solution
public class PalindromeLinkedLIst {
    public static void main(String[] args) {
        ListNode list = new ListNode(1, new ListNode(0,new ListNode(1)));
        System.out.println(new PalindromeLinkedLIst().isPalindrome(list));
    }

    public boolean isPalindrome(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode head2 = head;
        int cnt = isCount(head2);

        if (cnt == 1)
            return true;

        for(int i = 0 ;head != null; i++){
            if(cnt % 2 == 1 && cnt/2 == i){
                head = head.next;
                continue;
            }

            if (stack.isEmpty()) {
                stack.push(head.val);
                head = head.next;
                continue;
            }
            if (stack.peek() != head.val)
                stack.push(head.val);
            else
                stack.pop();

            head = head.next;
        }

        return stack.isEmpty();
    }

    public int isCount(ListNode listNode){
        int cnt =0;
        while(listNode != null){
            cnt++;
            listNode = listNode.next;
        }
        return cnt;
    }
}

/* best solution_USE REVERSE
public boolean isPalindrome(ListNode head) {
    ListNode fast = head, slow = head;
    while (fast != null && fast.next != null) {
        fast = fast.next.next;
        slow = slow.next;
    }
    if (fast != null) { // odd nodes: let right half smaller
        slow = slow.next;
    }
    slow = reverse(slow);
    fast = head;

    while (slow != null) {
        if (fast.val != slow.val) {
            return false;
        }
        fast = fast.next;
        slow = slow.next;
    }
    return true;
}

public ListNode reverse(ListNode head) {
    ListNode prev = null;
    while (head != null) {
        ListNode next = head.next;
        head.next = prev;
        prev = head;
        head = next;
    }
    return prev;
}
 */
