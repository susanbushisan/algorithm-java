import struct.ListNode;
import util.ListNodeUtils;

public class Question21 {
    public static void main(String[] args) {
        Question21 q = new Question21();
        ListNode l1 = ListNodeUtils.creatListNode(1, 2, 4);
        ListNode l2 = ListNodeUtils.creatListNode(1, 3, 4);
        long start = System.currentTimeMillis();
        System.out.println(q.mergeTwoLists(l1,l2));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode d = new ListNode(0);
        ListNode t = d;
        while (l1 != null || l2 != null){
            if (l2 == null){
                t.next = l1;
                break;
            }else if (l1 == null){
                t.next = l2;
                break;
            }
            if (l1.val < l2.val){
                t.next = l1;
                l1 = l1.next;
            }else {
                t.next = l2;
                l2 = l2.next;
            }
            t = t.next;
        }
        return d.next;
    }
}
