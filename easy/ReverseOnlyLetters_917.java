package easy;

public class ReverseOnlyLetters_917 {
    public String reverseOnlyLetters(String s) {
        char[] chars = s.toCharArray();
        int begin = 0;
        int end = chars.length - 1;
        while (begin < end) {
            if (!isChar(chars[begin])) {
                begin++;
                continue;
            }
            if (!isChar(chars[end])) {
                end--;
                continue;
            }
            char temp = chars[begin];
            chars[begin] = chars[end];
            chars[end] = temp;
            begin++;
            end--;
        }
        return new String(chars);
    }

    private boolean isChar(char c) {
        return c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z';
    }

    public static void main(String[] args) {
        ReverseOnlyLetters_917 letters917 = new ReverseOnlyLetters_917();
        System.out.println(letters917.reverseOnlyLetters("ab-cd"));
    }
}
