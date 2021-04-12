import javax.swing.*;

public class ListNode {
    long val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public void printListNode(ListNode listNode){
        while(listNode != null){
            System.out.print(listNode.val+ " ");
            listNode = listNode.next;
        }
    }
}