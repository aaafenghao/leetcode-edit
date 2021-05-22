package leetcode.editor.cn;

public class ReverseList {

    ListNode reverse(ListNode root){
        if(root.next == null){
            return root;
        }
        ListNode last = reverse(root.next);
        root.next.next = root;
        root.next = null;
        return last;
    }

    ListNode successor;
    ListNode reverseN(ListNode root,int n){
        if(n==1){
            successor = root.next;
        }
        ListNode last = reverseN(root.next, n - 1);
        root.next.next = root;
        root.next = successor;
        return last;
    }

    ListNode reverseMN(ListNode root,int n,int m){
        if(n==1){
            return reverseN(root,m);
        }
        ListNode listNode = reverseMN(root.next, n - 1, m - 1);
        root.next = listNode;
        return root;
    }

    public class ListNode{
        public int val;

        public ListNode next;
    }
}
