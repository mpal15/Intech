// Find a way to find the kth to the last element of linked list ( assume length of linked list is not
// known)
class ListNode {
    int data;
    ListNode next;

    ListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    private ListNode head;

    void append(int data) {
        ListNode newNode = new ListNode(data);
        if (head == null) {
            head = newNode;
            return;
        }

        ListNode current = head;
        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
    }

    int findKthToLast(int k) {
        if (head == null || k < 1) {
            return -1; // Invalid input, assuming -1 as a sentinel value
        }

        ListNode slowPointer = head;
        ListNode fastPointer = head;

        // Move the fast pointer k nodes ahead
        for (int i = 0; i < k; i++) {
            if (fastPointer == null) {
                return -1; // List is shorter than k, assuming -1 as a sentinel value
            }
            fastPointer = fastPointer.next;
        }

        // Move both pointers until the fast pointer reaches the end
        while (fastPointer != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next;
        }

        return slowPointer.data;
    }
}

public class Problem1 {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.append(1);
        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(4);
        linkedList.append(5);

        int kthToLast = linkedList.findKthToLast(2);
        System.out.println(kthToLast); // Output: 4
    }
}

