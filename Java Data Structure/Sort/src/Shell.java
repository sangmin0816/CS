public class Shell<E> extends PrintE<E> {
   private void shell_insert(E[] array, int first, int last, int gap) {
      for(int i = first +gap; i<= last; i=i+gap) {
         E key = array[i];
         int j = i-gap;
         for(; j>= first && (((Comparable<E>)key).compareTo(array[j])<0); j = j - gap) {
            array[j+gap] = array[j];
         }
         array[j+gap] = key;
      }

   }
   
   public E[] shellSort(E[] array) {
      printArray(array);
      int n = array.length;
      for(int gap = n/2; gap>0; gap = gap/2) {
         if(gap%2==0) gap++;
         for(int i=0; i<gap; i++) {
            shell_insert(array, i, n-1, gap);
            printArray(array);
         }
      }

      return array;
   }
}
