package easy;

/**
 * @author by zhangborui
 * @classname BinaryGap_868
 * @description TODO
 * @date 2022/4/24 10:44
 */
public class BinaryGap_868 {
    public int binaryGap(int n) {
        String s = Integer.toBinaryString(n);
        int start=0;
        int max=0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                max = Math.max(max, i - start);
                start = i;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        BinaryGap_868 binaryGap_868 = new BinaryGap_868();
        System.out.println(binaryGap_868.binaryGap(22));
        System.out.println(binaryGap_868.binaryGap(8));
        System.out.println(binaryGap_868.binaryGap(5));
        System.out.println(binaryGap_868.binaryGap(1041));
    }
}
