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
}
