import java.util.*;

public class GoodNumbersCount {
    static int M = (int)1e9+7; // 1e9+7 is a double value
    public int findPower(long a, long b){
        if(b == 0) {
            return 1;
        }

        long half  = findPower(a, b/2);
        long result = (half*half) % M;

        if(b%2 == 1){
            result = (result * a) % M;
        }

        return (int)result;
    }
    public int countGoodNumbers(long n) {
        long evenCount = (n+1)/2;
        long oddCount = n/2;

        long part1 = findPower(5, evenCount);
        long part2 = findPower(4, oddCount);

        return (int)((part1 * part2)%M);
    }
    public static void main(String[] args) {
        GoodNumbersCount g = new GoodNumbersCount();
        System.out.println(g.countGoodNumbers(1));
        System.out.println(g.countGoodNumbers(4));
        System.out.println(g.countGoodNumbers(50));
        System.out.println(g.countGoodNumbers(1000000000));
    }
}