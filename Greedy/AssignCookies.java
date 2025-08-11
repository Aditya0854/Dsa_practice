import java.util.*;
// LeetCode Problem: Assign Cookies
// Problem Link: https://leetcode.com/problems/assign-cookies/
public class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {

        if(g.length==0||s.length==0)return 0;
        int i = 0, j = 0, max = 0;

        Arrays.sort(g);
        Arrays.sort(s);
        while(i<g.length && j<s.length){
            if(s[j]>=g[i]) i++;
            j++;
        }
        return i;
    }

    public static void main(String[] args) {
        AssignCookies assignCookies = new AssignCookies();
        int[] g = {1, 2, 3};
        int[] s = {1, 1};
        System.out.println(assignCookies.findContentChildren(g, s)); // Output: 1
    }
}