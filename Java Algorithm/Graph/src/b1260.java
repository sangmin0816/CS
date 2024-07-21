import java.util.*;
// https://www.acmicpc.net/problem/1260

public class b1260 {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);

      int N = sc.nextInt();
      int M = sc.nextInt();
      int V = sc.nextInt();

      
      ArrayList<Integer>[] graph = new ArrayList[N+1];
      for(int i=0; i<N+1; i++){
         graph[i] = new ArrayList<Integer>();
      }
      

      for(int i=0; i<M; i++){
         int S = sc.nextInt();
         int E = sc.nextInt();
         graph[S].add(E);
         graph[E].add(S);
      }

      DFS(V, graph);
      BFS(V, graph);
      sc.close();
   }

   public static void DFS(int V, ArrayList<Integer>[] graph) {
      ArrayList<Integer> visited = new ArrayList<>();
      Stack<Integer> stack = new Stack<>();
      stack.add(V);

      while(!stack.isEmpty()){
         Integer now = stack.pop();
         if(!visited.contains(now)){
            visited.add(now);
            Collections.sort(graph[now], Collections.reverseOrder());
            for (Integer g : graph[now]) {
               stack.push(g);
            }
         }
      }

      for (Integer integer : visited) {
         System.out.print(integer+" ");
      }
      System.out.println();
   }

   public static void BFS(int V, ArrayList<Integer>[] graph){
      ArrayList<Integer> visited = new ArrayList<>();
      LinkedList<Integer> q = new LinkedList<>();
      q.add(V);

      while(!q.isEmpty()) {
         int now = q.pollFirst();
         if(!visited.contains(now)){
            visited.add(now);
            Collections.sort(graph[now]);
            for (Integer i : graph[now]) {
               q.add(i);
            }
         }
      }

      for (Integer integer : visited) {
         System.out.print(integer+" ");
      }
   }
}
