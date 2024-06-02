public class ArrayLinearQueue<E> {
   E[] array;
   int capacity;
   int front = -1;
   int rear = -1;
   

   public ArrayLinearQueue(int capacity) {
      this.array = (E[])new Object[capacity];
      this.capacity = capacity;
   }

   public boolean is_full() {
      if(this.rear == capacity-1) {
         return true;
      }
      return false;
   }

   public boolean is_empty(){
      if(this.front == this.rear){
         return true;
      }
      return false;
   }

   public void enqueue(E element) {
      if(is_full()){
         System.out.println("Queue IS FULL");
         return;
      }

      this.array[++(this.rear)] = element;
   }

   public E dequeue(){
      if(is_empty()){
         System.out.println("Queue IS EMPTY");
      }
      E removed = this.array[++(this.front)];
      return removed;
   }
}
