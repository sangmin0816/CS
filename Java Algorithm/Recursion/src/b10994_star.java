import java.util.Scanner;

public class b10994_star {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);

      int N = sc.nextInt();
      int NN = N*4 -3;

      char[][] arr = new char[NN][NN];
      for(int i=0; i<NN; i++){
         for(int j=0; j<NN; j++){
            arr[i][j] = ' ';
         }
      }


      for(int i=0; i<NN; i+=2){
         for(int j=i; j<NN-i; j++){
            arr[i][j] = '*';
            arr[j][i] = '*';
            arr[NN-i-1][j] = '*';
            arr[j][NN-i-1] = '*';
         }
      }

      for(int i=0; i<NN; i++){
         for(int j=0; j<NN; j++){
            System.out.print(arr[i][j]);
         }
         System.out.println();
      }

      sc.close();
   }

   
}
