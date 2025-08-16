public class factorialNumber {
    public static void main(String[] args) {
        int number = 5; // Example number to calculate factorial
        int result = factorial(number);
        System.out.println("Factorial of " + number + " is: " + result);
    }

    static int factorial(int n){
        if(n == 0 || n == 1){
            return 1;
        }

        return n * factorial(n-1);
    }
}
