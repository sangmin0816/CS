import java.util.*;
// https://www.acmicpc.net/problem/1931
public class Main {
    public static class meeting {
        int start;
        int end;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        ArrayList<meeting> marr = new ArrayList<meeting>();
        int ans = 0;

        for(int i=0; i<N; i++){
            meeting temp = new meeting();
            temp.start = sc.nextInt();
            temp.end = sc.nextInt();
            marr.add(temp);
        }

        Comparator<meeting> eComparator = new Comparator<meeting>() {
            public int compare(meeting m1, meeting m2){
                if(m1.end==m2.end)
                    return m1.start-m2.start;
                return m1.end - m2.end;
            }
        };

        Collections.sort(marr, eComparator);

        int i=0;
        while(!marr.isEmpty()){
            meeting temp = marr.remove(0);
            if(temp.start>=i){
                ans++;
                i=temp.end;
            }
        }

        System.out.println(ans);

        sc.close();
    }
}
