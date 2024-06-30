import java.util.Scanner;

public class b11729 {
   static StringBuilder sb =  new StringBuilder();
   static int cnt = 0;
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);

      int N = sc.nextInt();
      Hanoi(N, 1, 2, 3);
      System.out.println(cnt);
      System.out.println(sb);
      sc.close();
   }

   public static void Hanoi(int N, int from, int mid, int to){
      if(N==0){   
         return;
      }
      cnt ++;
      int p1 = from;
      int p2 = mid;
      int p3 = to;   
      Hanoi(N-1, p1, p3, p2);
      sb.append(from+" "+to+"\n");
      Hanoi(N-1, p2, p1, p3);
   }
}
