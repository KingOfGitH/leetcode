package easy;

public class LengthOfLastWord_58 {
    public int lengthOfLastWord(String s) {
        int cur=s.length()-1;
        int length=0;
        while (cur>=0&&s.charAt(cur)==' '){
            cur--;
        }
        while (cur>=0&&s.charAt(cur)!=' '){
            cur--;
            length++;
        }
        return length;
    }
}
