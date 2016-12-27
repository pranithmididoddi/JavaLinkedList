import java.util.*;
public class Solution {

    /**code to reverse a list*/
    public ListNode reverseList(ListNode head) {

        ListNode current=head;
        ListNode previous=null;
        ListNode next=null;

        while(current!=null){
            next=current.next;
            current.next=previous;
            previous=current;
            current=next;
        }
        return previous;
    }

    /**Insertion of an element in the first position(beginning of the list)*/

    ListNode Insert(ListNode head,int val) {

        ListNode current=head;

        while(current.next!=null){
            current=current.next;
        }
        current.next=new ListNode();
        current.next.val=val;

        return head;
/*This is a "method-only" submission.
You only need to complete this method. */

    }

    //find the cycle in the list

    public boolean hasCycle(ListNode head) {

        ListNode fast=head;
        ListNode slow=head;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;

            if(slow==fast)
                return true;
        }

        return false;

    }
 /**
  */

 /** LinkedList palindrome check naive approach
  * 14/25 cases passed on leetcode*/

 public boolean isPalindrome(ListNode head) {
     ListNode current=head;
     ListNode check=reverseList(head);

     while(current!=null){
         if(current.val!=check.val)
             return false;

         current=current.next;
         check=check.next;
     }
     return true;
 }

 /** LinkedList palindrome with Stack*/

 public boolean isaPalindrome(ListNode head) {
     ListNode current=head;
     ListNode fast=head;
     Stack<Integer> stack=new Stack<Integer>();

     while(fast!=null && fast.next!=null){
         stack.push(current.val);
         current=current.next;
         fast=fast.next.next;
     }

     if(fast!=null) current=current.next;

     while(current!=null){
         if(stack.pop().intValue() != current.val) return false;
         current=current.next;
     }
     return true;
 }

 /**LinkedList remove duplicates*/
 public ListNode deleteDuplicates(ListNode head) {
     ListNode dummy = new ListNode(0);
     dummy.next = head;
     head = dummy;

     while(head.next!=null && head.next.next!=null){
         if(head.next.val==head.next.next.val){
             int val=head.next.val;
             while(head.next!=null && head.next.val==val){
                 head.next=head.next.next;
             }
         }
         else{
             head=head.next;
         }
     }
     return dummy.next;
 }

 /**Merge two sorted lists*/
 public ListNode mergeTwoLists(ListNode a, ListNode b) {
     ListNode head=new ListNode(0);
     ListNode p=head;

     while(a!=null || b!=null){
         if(a!=null && b!=null){
             if(a.val<b.val){
                 p.next=a;
                 a=a.next;
             }
             else{
                 p.next=b;
                 b=b.next;
             }
             p=p.next;
         }else if(a==null){
             p.next=b;
             break;
         }else if(b==null){
             p.next=a;
             break;
         }

     }
     return head.next;
 }

 /**remove the duplictaes*/
 public ListNode deleteDuplicatesone(ListNode head) {

     ListNode slow=head;
     ListNode fast=head.next;

     while(fast!=null){
         if(slow.val==fast.val){
             slow.next=fast.next;
             fast=fast.next;
         }else{
             slow=fast;
             fast=fast.next;
         }
     }
     return head;
 }
}
