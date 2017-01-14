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

 /**Linked list cycle detection*/

    /**https://pranithleetcode.wordpress.com/2016/12/30/linked-list-cycle-detection-ii/*/

    public ListNode detectCycle(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;

            if(slow==fast) break;
        }

        if(fast==null || fast.next==null) return null;

        slow=head;

        while(slow!=fast){
            slow=slow.next;
            fast=fast.next;
        }

        return slow;

    }
    /**You are given the pointer to the head node of a linked list and you need to print all its elements in reverse order from tail to head, one element per line. The head pointer may be null meaning that the list is empty - in that case, do not print anything!

     Input Format
     You have to complete the void ReversePrint(Node* head) method which takes one argument - the head of the linked list. You should NOT read any input from stdin/console.

     Output Format
     Print the elements of the linked list in reverse order to stdout/console (using printf or cout) , one per line.

     Sample Input

     1 --> 2 --> NULL
     2 --> 1 --> 4 --> 5 --> NULL

     Sample Output

     2
     1
     5
     4
     1
     2*/

    void ReversePrint(ListNode head) {
       ListNode current=head;
        ListNode previous=null;
        ListNode nxt=null;

        while(current!=null){
            nxt=current.next;
            current.next=previous;
            previous=current;
            current=nxt;
        }
        while(previous!=null){
            System.out.println(previous.val);
            previous=previous.next;
        }

    }

    public ListNode rotateRight(ListNode head, int n) {

        ListNode slow=head;
        ListNode fast=head;

        while(n>0){
            n--;
            fast=fast.next;

            if(fast==null) fast=head;
        }

        if(fast==null || slow==fast) return head;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next;
        }

        ListNode temp=slow.next;
        slow.next=null;
        fast.next=head;

        return temp;

    }

    public int maxSubArray(int[] nums) {
        int max=nums[0];
        int[] sum=new int[nums.length];
        //int result=0;
        sum[0]=nums[0];

        if(nums.length==1) return nums[0];

        for(int i=1;i<nums.length;i++){
            sum[i]=Math.max(nums[i],sum[i-1]+nums[i]);
            max=Math.max(max,sum[i]);

        }

        return max;

    }
    /**Remove nth element from the end*/

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode fast=head;
        ListNode slow=head;

        while(n>0){
            n--;
            fast=fast.next;
        }

        if(fast == null){
            return head.next;
        }

        if(fast==null || fast==head) return head;

        while(fast.next!=null){
            slow=slow.next;
            fast=fast.next;
        }
        slow.next=slow.next.next;

        return head;
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        ListNode mid = findMiddle(head);
        ListNode tail = reverseList(mid.next);
        mid.next = null;

        merge(head, tail);
    }

    public ListNode findMiddle(ListNode head){
        ListNode slow=head;
        ListNode fast=head;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        return slow;
    }


    private void merge(ListNode head1, ListNode head2) {
        int index = 0;
        ListNode dummy = new ListNode(0);
        while (head1 != null && head2 != null) {
            if (index % 2 == 0) {
                dummy.next = head1;
                head1 = head1.next;
            } else {
                dummy.next = head2;
                head2 = head2.next;
            }
            dummy = dummy.next;
            index++;
        }
        if (head1 != null) {
            dummy.next = head1;
        } else {
            dummy.next = head2;
        }
    }

        public ListNode partition(ListNode head, int x) {

            ListNode leftDummy=new ListNode(0);
            ListNode rightDummy=new ListNode(0);

            ListNode left=leftDummy;
            ListNode right=rightDummy;

            while(head!=null){
                if(head.val<x){
                    left.next=head;
                    left=head;
                }else{
                    right.next=head;
                    right=head;
                }
                head=head.next;
            }
            right.next=null;
            left.next=rightDummy.next;
            return leftDummy.next;

        }
}



