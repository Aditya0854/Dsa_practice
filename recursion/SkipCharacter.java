public class SkipCharacter {
    public static void main(String[] args) {
        String input = "baccad";
        String result = SkipCharacter("", input);
        System.out.println(result);
    }

    static String SkipCharacter(String p, String up){
        if(up.isEmpty()){
            // System.out.println(p);
            return "";
        }

        char ch = up.charAt(0);

        if (ch == 'a') {
            return SkipCharacter(p, up.substring(1));
        } else {
            return SkipCharacter(p + ch, up.substring(1));
        }
    }
}