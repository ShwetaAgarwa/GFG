//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next, prev;

    Node(int key) {
        data = key;
        next = prev = null;
    }
}

class Driverclass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            Node temp = head;

            for (int i = 1; i < n; i++) {
                int a = sc.nextInt();
                Node n1 = new Node(a);
                n1.prev = temp;
                temp.next = n1;
                temp = n1;
            }

            head = new Solution().sortDoubly(head);
            printList(head);
        }
    }

    public static void printList(Node node) {
        Node temp = node;
        while (node != null) {
            System.out.print(node.data + " ");
            temp = node;
            node = node.next;
        }
        System.out.println();
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.prev;
        }
        System.out.println();
    }
}

// } Driver Code Ends


// User function Template for Java

/*
class Node
{
    int data;
    Node next, prev;
    Node(int data)
    {
        this.data = data;
        next = prev = null;
    }
}
*/
class Solution {
    
    static Node sortDoubly(Node head) {
       
        if (head == null || head.next == null) { 
            return head;
        }
     
        Node secondHalf = split(head);
        head = sortDoubly(head);
        secondHalf = sortDoubly(secondHalf);
        
        return merge(head, secondHalf);
        
    }
    
    static Node split(Node head) {
        Node fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next; 
            fast = fast.next.next;
        }
        Node temp = slow.next; 
        slow.next = null;
        return temp;
    }
    
    static Node merge(Node first, Node second) {
        Node dummy = new Node(-1);
        Node curr = dummy;
        while (first != null && second != null) { 
            if (first.data < second.data) {
                curr.next = first;
                first.prev = curr;
                first = first.next;
            } else {
                curr.next = second;
                second.prev = curr;
                second = second.next;
            }
            curr = curr.next;
        }
       
        if (first != null) {
            curr.next = first;
            first.prev = curr;
        }
        if (second != null) {
            curr.next = second;
            second.prev = curr;
        }
        
        Node ans = dummy.next;
        if (ans != null) {
            ans.prev = null;
        }
        return ans;
    }
}
