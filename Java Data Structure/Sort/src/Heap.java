public class Heap<E> extends PrintE<E> {
   private int lastposition; // 어디까지 요소를 넣었는지 기록
   private E[] heapArr;

   public Heap(E[] list){
      this.heapArr = (E[]) new Object[list.length];
      lastposition = -1;
      for(int i=0; i<list.length; i++){
         add(list[i]);
      }
   }

   private void add(E obj){
      heapArr[++lastposition] = obj; // 1. 노드 추가
      trickleup(lastposition); // 2. trickle up
   }
   private void swap(int from, int to){
      E tmp = heapArr[from];
      heapArr[from] = heapArr[to];
      heapArr[to] = tmp;
   }
   private void trickleup(int position){
      if (position == 0)
         return;
      int parent = (int) Math.floor((position-1)/2);
      if (((Comparable<E>)heapArr[position]).compareTo(heapArr[parent])>0) {
         swap(position, parent);
         trickleup(parent);
      }
   }
   public E remove(){
      E tmp = heapArr[0];
      swap(0, lastposition--); // 루트와 마지막 노드를 바꿔주고 lastposition을 줄여 배열에서 제거합니다.
      trickleDown(0);
      return tmp;
   }

   public void trickleDown(int parent){
      int left = 2*parent + 1;
      int right = 2*parent + 2;
      // 마지막에 왼쪽 자식이 클 때
      if (left==lastposition && (((Comparable<E>)heapArr[parent]).compareTo(heapArr[left])<0)){
         swap(parent, left);
         return;
      }
      // 마지막에 오른쪽 자식이 클 때
      if (right==lastposition && (((Comparable<E>)heapArr[parent]).compareTo(heapArr[right])<0)){
         swap(parent, right);
         return;
      }
      // 마지막에 부모가 클 때
      if (left >= lastposition || right >= lastposition)
         return;
      // 왼쪽 자식이 클 때
      
      boolean isLeftBig = (((Comparable<E>)heapArr[left]).compareTo(heapArr[right])>0)&&(((Comparable<E>)heapArr[parent]).compareTo(heapArr[left])<0);
      if (isLeftBig) {
         swap(parent, left);
         trickleDown(left);
      }
      // 오른쪽 자식이 클 때
      else if (((Comparable<E>)heapArr[parent]).compareTo(heapArr[right])<0){
         swap(parent, right);
         trickleDown(right);
      }
   }

   public E[] heapSort(){
      printArray(heapArr);
      for(int i=0; i<heapArr.length; i++){
         remove();
         printArray(heapArr);
      }
      return heapArr;
   }
}
