public class Bublle<E> extends PrintE<E> {
   public E[] bubbleSort(E[] array) {
      printArray(array);
      int n = array.length;
      for (int i=n-1; i > 0; i--) {
         for(int j=0; j<i; j++){
            if(((Comparable<E>)array[j]).compareTo(array[j+1]) > 0) {
               E temp = array[j];
               array[j] = array[j+1];
               array[j+1] = temp;
            }
         }
         printArray(array);
      }

      return array;
   }
}
