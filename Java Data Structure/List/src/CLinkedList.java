public class CLinkedList<E> {
   private Node<E> head;
   private int currentSize;

   class Node<E> {
      E data;
      Node<E> next;
      public Node(E obj) {
         data = obj;
         next = null;
      }
   }

   public CLinkedList() {
      head = null;
      currentSize = 0;
   }

   public void addFirst(E obj) {
      Node<E> node = new Node<E> (obj);
      node.next = head; // 헤드가 가리키던 첫 번째 노드를 가리킴
      head = node; // 헤드가 새로운 노드를 가리킴
      currentSize ++;
   }

   public void addLast(E obj) {
      Node<E> node = new Node<E>(obj);
   
      if (head == null){ // 1. 자료 구조가 비어있는 경우
         head = node;
         currentSize++;
         return;
      }
   
      Node<E> tmp = head;
      while(tmp.next != null) { // next가 null, 즉 마지막 노드까지 반복
         tmp = tmp.next;
      }
      
      tmp.next = node; // 마지막 노드의 next에 새로운 노드 추가
      currentSize++;
   }


   public E removeFirst() {
      if (head == null) { // 1. 자료 구조가 비어있는 경우
         return null;
      }
      
      currentSize --;
      E removedData = head.data;
      if (currentSize == 1) { // 2. 자료 구조에 단 하나의 요소가 들어있을 때
         head = null;
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
      E removedData = head.data;
      if (currentSize == 1) { // 2. 자료 구조에 단 하나의 요소가 들어있을 때
         head = null;
         return removedData;
      }
         
      Node<E> preP = head; // 마지막에서 두 번째 노드
      Node<E> removeP = head.next; // 지우려는 마지막 노드
      while(removeP.next != null){
         preP = removeP;
         removeP = removeP.next;
      }
      removedData = removeP.data;
      preP.next = null; // 이전 노드와 연결 끊음
      
      return removedData;
   }

   public E peekFirst() {
      if (head == null) return null;
      return head.data;
   }

   public E peekLast() {
      if (head == null) return null;
      Node<E> tmp = head;
      while (tmp.next != null) { // 마지막 노드일 때까지
         tmp = tmp.next;
      }
      return tmp.data;
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
