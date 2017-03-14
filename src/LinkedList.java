/**
 * Created by Pranith on 12/13/16.
 */
public class LinkedList {
Node head;

class Node{
    int data;
    Node next;

    Node(int d){
        data=d;
        next=null;
    }
}

public void add(int data){
    Node newnode= new Node(data);
    newnode.next=head;
    head=newnode;
}

public void printList(){
    Node temp=head;

    while (temp!=null){
        System.out.println(temp.data+" ");
        temp=temp.next;
    }
    System.out.println();
}
    

public static void main(String[] args){
    LinkedList list=new LinkedList();

    list.add(10);
    list.add(20);
    list.add(30);

    list.printList();


}

    public ListNode reverseBetween(ListNode head, int m, int n) {

        if(head==null) return null;

        ListNode dummy=new ListNode(0);
        dummy.next=head;
        head=dummy;

        for(int i=1;i<m;i++){
            if(head==null) return head;

            head=head.next;
        }

        ListNode premNode=head;
        ListNode mnode=head.next;
        ListNode nnode=mnode;
        ListNode postnnode=mnode.next;

        for(int i=m;i<n;i++){

            if(postnnode==null) return null;

            ListNode temp=postnnode.next;
            postnnode.next=nnode;
            nnode=postnnode;
            postnnode=temp;
        }

        mnode.next=postnnode;
        premNode.next=nnode;


        return dummy.next;
    }


}
