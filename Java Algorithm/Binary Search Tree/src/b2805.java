import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
// 나무 자르기 https://www.acmicpc.net/problem/2805
public class b2805 {
   public static void main(String[] args) throws Exception {
      Scanner sc = new Scanner(System.in);
      int N = sc.nextInt();
      int M = sc.nextInt();
      ArrayList<Long> arr = new ArrayList<>();
      for(int i=0; i<N; i++){
         arr.add(sc.nextLong());
      }
      

      System.out.println(binary_search(M, arr, 0L, Collections.max(arr)));
  }

  static Long binary_search(int key, ArrayList<Long> arr, Long low, Long high){
   while(low<=high){
      Long mid = (low+high)/2;
      Long temp = 0L;
      for(int i=0; i<arr.size(); i++){
         if(arr.get(i)>mid) temp += arr.get(i) - mid;
      }

      if(temp == key){
         return mid;
      }
      else if(temp > key){
         low = mid + 1;
      }
      else {
         high = mid - 1;
      }
   }
   return high;
  }
}
