import java.util.LinkedList;
import java.util.Queue;

public class Radix<Integer> extends PrintE<Integer> {
   Integer[] array;
   public Integer[] radixSort(Integer[] list){
      array = list;
      printArray(array);
      
      Queue<Integer>[] queue = new LinkedList[10];
      for(int b=0; b<10; b++){
            queue[b] = new LinkedList<>();
      }

      boolean flag = true;
      int digit = 10;
      while(flag){
         for(int i=0; i<array.length; i++){
            queue[(((int)array[i]/digit)%10)].add(array[i]);
         }
         if(queue[0].size()==array.length){
            flag = false;
         }
         
         int a = 0;
         for(int q=0; q<10; q++){
            while(!queue[q].isEmpty()){
               array[a++] = queue[q].poll();
            }
         }
         digit *= 10;
         printArray(array);
      }
      return array;
   }
   
}
