package hard;

import java.util.Stack;

/**
 * @author by zhangborui
 * @classname IsValid_591
 * @description TODO
 * @date 2022/5/3 18:57
 */
public class IsValid_591 {
    public boolean isValid(String code) {
        Stack<String> stack = new Stack<>();
        int length = code.length();
        StringBuilder tagName;
        int i = 0;
        boolean isFirst = true;
        while (i < length) {
            char c = code.charAt(i);
            if (c == '<') {
                if (i + 1 >= length) {
                    return false;
                }
                // 处理CDATA
                if (code.charAt(i + 1) == '!') {
                    if (i + 11 >= length || stack.isEmpty() || !"<![CDATA[".equals(code.substring(i, i + 9))) {
                        return false;
                    }
                    //跳转到<![CDATA[后的字符位置
                    i += 9;
                    // CDATA内的内容全跳过
                    while (i + 2 < length && !"]]>".equals(code.substring(i, i + 3))) {
                        i++;
                    }
                    if (i + 2 >= length || !"]]>".equals(code.substring(i, i + 3))) {
                        return false;
                    }
                    i += 3;
                    continue;
                }
                // 非CDATA则为TagName
                tagName = new StringBuilder();
                boolean isOpen = true;
                // 跳过<
                i++;
                if (code.charAt(i) == '/') {
                    // 跳转带</后面的字符
                    if (stack.isEmpty()) {
                        return false;
                    }
                    i += 1;
                    isOpen = false;
                }
                int j = 0;
                while (i < length && code.charAt(i) != '>') {
                    if (!isUpChar(code.charAt(i)) || j >= 9) {
                        return false;
                    }
                    tagName.append(code.charAt(i));
                    j++;
                    i++;
                }
                if (j < 1) {
                    return false;
                }
                if (isOpen) {
                    if (stack.isEmpty() && !isFirst) {
                        return false;
                    }
                    isFirst = false;
                    stack.push(tagName.toString());
                } else {
                    if (!stack.pop().equals(tagName.toString())) {
                        return false;
                    }
                }
            }
            i++;
            if (stack.isEmpty() && i < length) {
                return false;
            }
        }
        return !isFirst && stack.isEmpty();
    }

    public boolean isUpChar(Character c) {
        return c >= 'A' && c <= 'Z';
    }


    public static void main(String[] args) {
        IsValid_591 isValid_591 = new IsValid_591();
        System.out.println(isValid_591.isValid("<A>"));
        System.out.println(isValid_591.isValid("<DIV>This is the first line <![CDATA[<div>]]></DIV>"));
        System.out.println(isValid_591.isValid("<A>  <B> </A>   </B>"));
        System.out.println(isValid_591.isValid("<DIV>  div tag is not closed  <DIV>"));
        System.out.println(isValid_591.isValid("<DIV>  unmatched <  </DIV>"));
        System.out.println(isValid_591.isValid("<DIV> closed tags with invalid tag name  <b>123</b> </DIV>"));
        System.out.println(isValid_591.isValid("<DIV> unmatched tags with invalid tag name  </1234567890> and <CDATA[[]]>  </DIV>"));
        System.out.println(isValid_591.isValid("<DIV>  unmatched start tag <B>  and unmatched end tag </C>  </DIV>"));
    }
}
