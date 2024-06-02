public class PrintE <E>{
   protected void printArray(E[] array){
      for(int i=0; i<array.length; i++){
         System.out.print(array[i]+" ");
      }
      System.out.println();
   }
}
