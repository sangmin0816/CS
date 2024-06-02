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
}
