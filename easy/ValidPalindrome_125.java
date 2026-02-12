package easy;

public class ValidPalindrome_125 {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (otherChr(s.charAt(l))) {
                l++;
                continue;
            }
            if (otherChr(s.charAt(r))) {
                r--;
                continue;
            }
            if (s.charAt(l++) != s.charAt(r--)) {
                return false;
            }
        }
        return true;
    }

    private boolean otherChr(char c) {
        return (c < 'a' || c > 'z') && (c < '0' || c > '9');
    }
}
