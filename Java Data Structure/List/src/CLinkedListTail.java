public class CLinkedListTail<E> {
   private Node<E> head;
   private Node<E> tail;
   private int currentSize;

   class Node<E> {
      E data;
      Node<E> next;
      public Node(E obj) {
         data = obj;
         next = null;
      }
   }

   public CLinkedListTail() {
      head = null;
      tail = null;
      currentSize = 0;
   }

   public void addFirst(E obj) {
      Node<E> node = new Node<E> (obj);

      node.next = head; // 헤드가 가리키던 첫 번째 노드를 가리킴
      head = node; // 헤드가 새로운 노드를 가리킴
      if(head.next==null){
         tail = node;
      }
      currentSize ++;
   }

   public void addLast(E obj) {
      currentSize++;

      Node<E> node = new Node<E>(obj);
      if (head == null){ // 1. 자료 구조가 비어있는 경우
         head = tail = node;
         return;
      }
   
      tail.next = node; // 꼬리가 가리키던 마지막 노드의 다음 노드에 넣음
      tail = node; // 꼬리가 새로운 노드를 가리킴
   }


   public E removeFirst() {
      if (head == null) { // 1. 자료 구조가 비어있는 경우
         return null;
      }
      
      currentSize --;
      E removedData = head.data;
      if (currentSize == 1) { // 2. 자료 구조에 단 하나의 요소가 들어있을 때
         head =  tail = null;
      }
      else {
         head = head.next;
      }
      
      return removedData;
   }

   public E removeLast() {
      if (head==null) {
         return null;
      }

      currentSize --;
      E removedData = tail.data;
      if (currentSize == 1) { // 2. 자료 구조에 단 하나의 요소가 들어있을 때
         head = tail = null;
         return removedData;
      }
      

      Node<E> preP = head; // 마지막에서 두 번째 노드
      while(preP.next != tail){
         preP = preP.next;
      }
      tail = preP;
      preP.next = null; // 이전 노드와 연결 끊음
      
      return removedData;
   }

   public E peekFirst() {
      if (head == null) return null;
      return head.data;
   }

   public E peekLast() {
      if (head == null) return null;
      return tail.data;
   }

   public void printList() {
      if(head == null) return;
      Node<E> point = head;
      while(point!=null){
         System.out.print(point.data+"-");
         point = point.next;
      }
      System.out.println("NULL");
   }
}
