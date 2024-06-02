public class ArrayStack<E> {
   int top = -1;
   int size = 0;
   E[] stack;
   public ArrayStack(int size){
      this.size = size;
      stack = (E[]) new Object[size];
   }
   
   public void push(E item) {
      stack[++top] = item;
      System.out.println(stack[top] + " Push!");
  }

  public void pop() {
     E pop = stack[top];
     System.out.println(pop + " Pop!");
      stack[top--] = null;
  }

  public void peek() {
      System.out.println(stack[top] + " Peek!");
  }
}
