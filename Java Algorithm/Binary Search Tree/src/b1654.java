import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class b1654 {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int K = sc.nextInt();
      Long N = sc.nextLong();
      ArrayList<Long> arr = new ArrayList<>();
      for(int i=0; i<K; i++){
         arr.add(sc.nextLong());
      }

      System.out.println(binary_search(0L, Collections.max(arr), arr, N));
   }

   static Long binary_search(Long low, Long high, ArrayList<Long> arr, Long key){
      while(low<high){
         Long cut = (low+high)/2;
         Long total = 0L;
         for(int i=0; i<arr.size(); i++){
            total += (arr.get(i)/cut);
         }

         if(total < key){
            high = cut;
         } else {
            low = cut + 1;
         }
      }

      return low-1;
      
   }
}
