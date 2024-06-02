public class Select<E> extends PrintE<E> {
   public E[] selectSort(E[] array){
      printArray(array);
         
      for(int i=0; i<array.length-1; i++){
         int least = i;
         int j=i+1;
         for(; j<array.length;j++){
            if(((Comparable<E>)array[j]).compareTo(array[least])<0)
               least = j; // 최솟값 탐색
         }
         // 가장 작은 값과 왼쪽에 있는 값과 비교
         E temp = array[i];
         array[i] = array[least];
         array[least] = temp;
         printArray(array);
      }
      return array;
   }
}
