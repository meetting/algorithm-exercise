package lc;

import java.util.LinkedList;
/**
 * @Author: 余新洁
 * @Date: 2021/5/29
 * @Description: 20. 有效的括号
 */
public class T20 {
    /**
     * go
     * 栈，将左括号入栈，然后遇到有括号就与栈顶比较，不为互补就说明是错的
     * 细节：先压入任意一个字符，让栈不为空，减少栈空判断
     *
     */
    public boolean isValid(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        stack.push('x');
        for (char c : s.toCharArray()) {
            // 此处不可能为空，因为先压入了一个x来保证不为空
            char top = stack.peek();
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                switch (c) {
                    case '}':
                        if (top == '{') {
                            stack.pop();
                        } else {
                            return false;
                        }
                        break;
                    case ')':
                        if (top == '(') {
                            stack.pop();
                        } else {
                            return false;
                        }
                        break;
                    case ']':
                        if (top == '[') {
                            stack.pop();
                        } else {
                            return false;
                        }
                        break;
                    default: return false;
                }
            }
        }
        return stack.size() == 1;
    }

    public static void main(String[] args) {
        T20 t20 = new T20();
        System.out.println(t20.isValid("{}{{}}({})"));
        System.out.println(t20.isValid("{"));
    }
}