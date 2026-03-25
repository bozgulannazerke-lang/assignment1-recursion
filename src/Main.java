import java.util.Scanner;

public class Main {
   //1
    public static void printDigits(int n){
        if(n<10){
            System.out.println(n);
            return;
        }
        printDigits(n/10);
        System.out.println(n%10);
    }
    //2
    public static int sum(int[] arr, int index){
        if(index==arr.length) return 0;
        return arr[index] + sum(arr, index+1);
    }
    //3
    public static boolean isPrime(int n, int i){
        if(n<=2) return n==2;
        if(n%i==0) return false;
        if(i*i>n) return true;
        return isPrime(n, i+1);
    }
    //4
    public static  int factorial(int n){
        if(n==0) return 1;
        return n*factorial(n-1);
    }
    //5
    public static int fibonacci(int n){
        if(n==0) return 0;
        if(n==1) return 1;
        return fibonacci(n-1)+fibonacci(n-2);
    }
    //6
    public static int power(int a, int n){
        if(n==0) return 1;
        return a*power(a, n-1);
    }
    //7
    public static void reverse(Scanner sc, int n){
        if(n==0) return;
        int x=sc.nextInt();
        reverse(sc, n-1);
        System.out.print(x + " ");
    }
    //8
    public static boolean onlyDigits(String s, int index){
        if(index==s.length()) return true;
        if(!Character.isDigit(s.charAt(index))) return false;
        return onlyDigits(s, index + 1);
    }
    //9
    public static int count(String s){
        if(s.equals("")) return 0;
        return 1 + count(s.substring(1));
    }
    //10
    public static int gcd(int a, int b){
        if(b==0) return a;
        return gcd(b, a%b);
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        //1
        int n1=5481;
        printDigits(n1);
        //2
        int[] arr={3,2,4,1};
        double avg=(double) sum(arr, 0) / arr.length;
        System.out.println(avg);
        //3
        int n3=7;
        System.out.println(isPrime(n3, 2) ? "Prime" : "Composite");
        //4
        System.out.println(factorial(5));
        //5
        System.out.println(fibonacci(5));
        //6
        System.out.println(power(2, 10));
        //7
        int n7 = 4;
        System.out.println("Enter numbers:");
        reverse(sc, n7);
        System.out.println();
        //8
        String s8 = "123456";
        System.out.println(onlyDigits(s8, 0) ? "Yes" : "No");
        //9
        System.out.println(count("hello"));
        //10
        System.out.println(gcd(32, 48));
        sc.close();
    }
    }
