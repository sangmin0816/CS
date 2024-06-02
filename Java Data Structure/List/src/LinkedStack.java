public class LinkedStack<E> {
   class Node<E>{
      E data;
      Node next = null;

      public Node(E data){
         this.data = data;
      }
   }

   Node top = null;
   int size = 0;

   public void push(E data) {
      Node node = new Node(data);
      node.next = top;
      top = node;
      size++;
   }

   public void pop() {
      System.out.println(top.data);
      top = top.next;
      size--;
   }

   public E peek() {
      return (E)top.data;
   }
}
