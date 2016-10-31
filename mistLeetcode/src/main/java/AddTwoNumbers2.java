
/**
 * Created by lixiaojian on 2016/10/28.
 * @source  https://leetcode.com/problems/add-two-numbers/
 */
public class AddTwoNumbers2 {
//     You are given two linked lists representing two non-negative numbers.
//      The digits are stored in reverse order and each of their nodes contain a single digit.
//       Add the two numbers and return it as a linked list.
//
//    Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
//    Output: 7 -> 0 -> 8

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode head = l1;
        ListNode p = l1;
        ListNode q = l2;
        ListNode pre = new ListNode(-1);
        pre.next = p;
        int exa = 0;
        while (p != null && q != null) {
            int sum = p.val + q.val + exa;
            p.val = sum % 10;
            exa = sum / 10;
            p = p.next;
            q = q.next;
            pre = pre.next;
        }
        if (p == null && q == null) {
            if (exa == 1) {
                ListNode newNode = new ListNode(1);
                pre.next = newNode;
            }
        } else if (p == null) {
            pre.next = q;
            if (exa == 1) {
                if (q.val < 9) {
                    q.val++;
                } else {
                    addOneList(pre,q,1);
                }
            }
        } else {
            if (exa == 1) {
                if (p.val < 9) {
                    p.val = p.val + 1;
                } else {
                    addOneList(pre,p,1);
                }
            }
        }
        return head;
    }

    private void addOneList(ListNode pre, ListNode q, int exa) {
        while (q != null) {
            if (q.val < 9) {
                q.val++;
                return;
            }
            q.val = 0;
            exa = 1;
            q = q.next;
            pre = pre.next;
        }
        if (pre.val == 0) {
            ListNode newNode = new ListNode(1);
            pre.next = newNode;
        }
    }





    public static void main(String[] args) {
        AddTwoNumbers2 add = new AddTwoNumbers2();

        ListNode L1 = new ListNode(9);
        ListNode L1Next = new ListNode(8);
        L1.next = L1Next;

        ListNode L2 = new ListNode(1);

        ListNode h = add.addTwoNumbers(L1, L2);
        while(h != null) {
            System.out.print(h.val);
            h = h.next;
        }
    }
}
