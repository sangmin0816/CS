import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
//https://www.acmicpc.net/problem/2110
public class b2110 {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int N = sc.nextInt();
      Long C = sc.nextLong();
      ArrayList<Long> x = new ArrayList<>();

      for(int i=0; i<N; i++){
         x.add(sc.nextLong());
      }

      Collections.sort(x);

      System.out.println(bin_search(x, C, 0L, x.get(N-1)));

      sc.close();
   }

   public static Long bin_search(ArrayList<Long> x, Long key, Long low, Long high){
      ArrayList<Long> ans = new ArrayList<>();
      while(low<=high){
         Long mid = (low+high)/2; // 공유기 간 거리
         Long temp = 1L; // 설치한 공유기 개수
         Long coo = Collections.min(x); // 시작점

         for(int i=0; i<x.size(); i++){
            if((coo+mid)<=x.get(i)){
               temp += 1;
               coo = x.get(i);
            }
         }

         if(temp>=key){
            low = mid+1;
            ans.add(mid);
         } else{
            high = mid-1;
         }
      }

      return Collections.max(ans);
   }
}
