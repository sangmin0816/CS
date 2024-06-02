import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        // CLinkedList cLinkedList = new CLinkedList<>();
        // cLinkedList.addFirst(2);
        // cLinkedList.addLast(1);
        // cLinkedList.addFirst(3);
        // cLinkedList.addFirst(4);
        // cLinkedList.addFirst(5);
        // cLinkedList.printList();
        // System.out.println(cLinkedList.removeLast());
        // System.out.println(cLinkedList.removeFirst());
        // cLinkedList.printList();
        // System.out.println(cLinkedList.peekFirst());
        // System.out.println(cLinkedList.peekLast());

        CLinkedListTail cLinkedListTail = new CLinkedListTail<>();
        cLinkedListTail.addFirst(2);
        cLinkedListTail.addLast(1);
        cLinkedListTail.addFirst(3);
        cLinkedListTail.addFirst(4);
        cLinkedListTail.addFirst(5);
        cLinkedListTail.printList();
        System.out.println(cLinkedListTail.removeLast());
        System.out.println(cLinkedListTail.removeFirst());
        cLinkedListTail.printList();
        System.out.println(cLinkedListTail.peekFirst());
        System.out.println(cLinkedListTail.peekLast());

        // Stack s =  new Stack();
        // s.empty();
        // s.peek();
        // s.pop();
        // s.push("element");
        // s.search("element");

        // Queue q = new LinkedList<>();
        // q.isEmpty();
        // q.size();
        // q.peek();
        // q.add("element");
        // q.remove("element");

        Deque d = new ArrayDeque<>();
        d.isEmpty();
        d.addFirst("element1"); // push()
        d.addLast("element2"); // add()
        d.pollFirst(); // pop(), poll(), remove()
        d.pollLast(); //
        d.getFirst(); // peek(), peekFirst()
        d.getLast(); // peekLast()

        PriorityQueue p = new PriorityQueue<>();
        p.add("element");
        p.peek();
        p.poll();
        p.contains("element");
    }
}
