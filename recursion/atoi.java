public class atoi {
    private static int recursiveParse(String s, int index, int current, boolean isNegative){
        if(index>=s.length() || !Character.isDigit(s.charAt(index))){
            return isNegative? -current:current;
        }

        int digit = s.charAt(index)-'0';
        long temp = (long) current*10 + digit;

        if(temp>Integer.MAX_VALUE){
            return isNegative? Integer.MIN_VALUE:Integer.MAX_VALUE;
        }

        return recursiveParse(s, index+1, current*10 + digit, isNegative);
    }

    public int myAtoi(String s) {
        s = s.trim();
        if(s.isEmpty()) return 0;
        
        boolean isNegative = false;
        int startIndex = 0;

        if(s.charAt(0) == '-' || s.charAt(0) == '+'){
            isNegative = (s.charAt(0) == '-');
            startIndex = 1;
        }

        return recursiveParse(s, startIndex, 0, isNegative);

    }
    public static void main(String[] args) {
        atoi converter = new atoi();
        System.out.println(converter.myAtoi("   -42"));
        System.out.println(converter.myAtoi("4193 with words"));
        System.out.println(converter.myAtoi("words and 987"));
        System.out.println(converter.myAtoi("-91283472332"));
        System.out.println(converter.myAtoi("3.14159"));
    }
}