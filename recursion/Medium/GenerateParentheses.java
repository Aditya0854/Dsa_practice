package Medium;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        solve(res, "",0, 0, n);
        return res;
    }

    private static void solve(List<String> res,String curr, int open, int close, int n){
        if(curr.length() == 2*n){
            res.add(curr);
            return;
        }

        if(open<n){
            solve(res, curr+"(", open+1, close,n);
        }

        if(close<open){
            solve(res, curr+")", open, close+1,n);
        }

        return;
    }
    public static void main(String[] args) {
        int n = 3;
        System.out.println(generateParenthesis(n));
    }
}
