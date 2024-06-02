public class Insertion<E>  extends PrintE<E> {
   // 요소를 선택하여 v에 저장
   public E[] insertionSort(E[] array) {
      printArray(array);
      
      for (int i=1; i < array.length; i++) {
         E v = array[i];
         int j = i-1;
         for (;j >= 0; j--) {
            // v가 바로 전의 요소보다 크거나 같으면 break
            if(((Comparable<E>)array[j]).compareTo(v) <= 0)
               break;
            // v가 바로 전의 요소보다 작으면 위치를 바꿔줌
            array[j+1] = array[j];
         }
         array[j+1] = v;
         printArray(array);
      }

      return array;
   }
}
