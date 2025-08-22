// Given an integer N , Print all binary strings of size N which do not contain consecutive 1s.

// A binary string is that string which contains only 0 and 1.


// package Medium;

import java.util.*;
public class BinaryStrings {
    public static List<String> generateBinaryStrings(int n) {
        List<String> res = new ArrayList<>();
        solve(n, "", res, ' '); // Start with empty string and no previous char
        return res;
    }

    public static void solve(int n, String curr, List<String> res, char prev){
        if(curr.length() == n) {
            res.add(curr);
            return;
        }
        // Always add '0'
        solve(n, curr + "0", res, '0');
        // Add '1' only if previous char is not '1'
        if(prev != '1') {
            solve(n, curr + "1", res, '1');
        }
    }

    public static void main(String[] args) {
        int n = 3;
        List<String> result = generateBinaryStrings(n);
        System.out.println(result);
    }
}
