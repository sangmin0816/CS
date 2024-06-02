import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }

    int func(int n) { // 1~n까지 합 구하기
        if(n==0) // Base Case
            return 0;
        else // Recursive Case
            return n + func(n-1);
    }

    int factorial(int n){
        if(n==0)
            return 1;
        else
            return n*factorial(n-1);
    }

    double power(double x, int n) {
        if(n==0)
            return 1;
        else
            return x*power(x, n-1);
    }

    int fibonacci(int n){
        if(n<2)
            return n;
        else
            return fibonacci(n-1)+fibonacci(n-2);
    }

    double gcd(int m, int n){
        if(m<n) {
            int tmp=m; m=n; n=tmp;
        }
        if(m%n==0)
            return n;
        else
            return gcd(n, m%n);
    }

    int gcd2(int p, int q){
        if(q==0)
            return p;
        else
            return gcd2(q, p%q);
    }
    
    int length(String str){
        if(str.equals(""))
            return 0;
        else
            return 1+length(str.substring(1));
    }

    void printChars(String str){
        if(str.length()==0)
            return;
        else{
            System.out.println(str.charAt(0));
            printChars(str.substring(1));
        }
    }

    void printCharsReverse(String str){
        if(str.length()==0)
            return;
        else {
            printCharsReverse(str.substring(1));
            System.out.println(str.charAt(0));
        }
    }

    void printInBinary(int n){
        if(n<2)
            System.out.println(n);
        else{
            printInBinary(n/2);
            System.out.println(n%2);
        }
    }

    int sum(int n, int[] data){
        if(n<=0)
            return 0;
        else
            return sum(n-1, data)+data[n-1];
    }

    void readFrom(int n, int[] data, Scanner in){
        if(n==0)
            return;
        else {
            readFrom(n-1, data, in);
            data[n-1] = in.nextInt();
        }
    }

    int search(int[] data, int n, int target){
        for(int i=0; i<n; i++)
            if(data[i]==target)
                return i;
        return -1;
    }

    int search(int[] data, int begin, int end, int target){
        if(begin>end)
            return -1;
        if(target==data[begin])
            return begin;
        return search(data, begin+1, end, target);
    }

    int search2(int[] data, int begin, int end, int target){
        if(begin>end)
            return -1;
        else {
            int middle = (begin+end)/2;
            if(data[middle]==target)
                return middle;
            int index = search2(data, begin, middle-1, target);
            if (index!=-1)
                return index;
            return search2(data, middle+1, end, target);
        }
    }

    int findMax(int[] data, int begin, int end)
    {
        if(begin==end)
            return data[begin];
        else
            return Math.max(data[begin], findMax(data, begin+1, end));
    }

    int findMax2(int[] data, int begin, int end){
        if(begin==end)
            return data[begin];
        else{
            int middle = (begin+end)/2;
            int max1 = findMax(data, begin,middle);
            int max2 = findMax(data, middle+1, end);
            return Math.max(max1, max2);
        }
    }

    int binarySearch(String[] items, String target, int begin, int end){
        if(begin>end)
            return -1;
        else {
            int middle = (begin+end)/2;
            int compResult = target.compareTo(items[middle]);
            if(compResult==0)
                return middle;
            if(compResult<0)
                return binarySearch(items, target, begin, middle+1);
            return binarySearch(items, target, middle+1, end);
        }
    }
}
