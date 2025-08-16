public class Nto1 {
    public static void main(String[] args) {
        fun(5);
        System.out.println("Reverse Order:");
        funRev(5);
    }

    static void fun(int n){
        if(n==0){
            return;
        }
        fun(n-1);
        System.out.println(n);
    }

    static void funRev(int n){
        if(n==0){
            return;
        }
        System.out.println(n);
        funRev(n-1);
    }
}
