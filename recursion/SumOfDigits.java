public class SumOfDigits {
    public static void main(String[] args) {
        int number = 12345; // Example number to calculate sum of digits
        int result = sumOfDigits(number);
        System.out.println("Sum of digits of " + number + " is: " + result);
    }

    static int sumOfDigits(int n){
        if(n == 0){
            return 0;
        }

        return n%10 + sumOfDigits(n/10);
    }
}
