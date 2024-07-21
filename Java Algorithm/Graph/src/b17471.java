import java.util.*;

// https://velog.io/@bobae1998/%EB%B0%B1%EC%A4%80-17471-%EA%B2%8C%EB%A6%AC%EB%A7%A8%EB%8D%94%EB%A7%81-JAVA

// https://www.acmicpc.net/problem/17471

public class b17471 {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);

      int N = sc.nextInt();
      ArrayList<Integer>[] graph = new ArrayList[N];
      for(int i=0; i<N; i++){
         graph[i] = new ArrayList<>();
         String[] strArr = sc.next().split(" ");
         for(String s : strArr){
            graph[i].add(Integer.parseInt(s));
         }
      }

      // 구역 나누기
      // 연결 확인
      // 인구차 확인 해 최소값 구하기
      sc.close();
   }

   
}
