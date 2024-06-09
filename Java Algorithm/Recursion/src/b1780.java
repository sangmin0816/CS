import java.util.Scanner;

public class b1780 {
   public static void main(String[] args) throws Exception {
      Scanner sc = new Scanner(System.in);
      int N = sc.nextInt();

      int arr[][] = new int[N][N];
      for(int i=0; i<N; i++){
         for (int j=0; j<N; j++){
            arr[i][j] = sc.nextInt();
         }
      }

      int ans_m1 = 0, ans_0 = 0, ans_1 = 0;


      System.out.println(ans_m1);
      System.out.println(ans_0);
      System.out.println(ans_1);

      sc.close();
  }

  
}
