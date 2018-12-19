package learning;

import java.util.Stack;

public class IsValid {
    public boolean isValid(String s) {

        boolean ans = true;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length() && ans; i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    ans = false;
                    break;
                }
                char match = stack.pop();
                switch (c) {
                    case ')':
                        if (match != '(') {
                            ans = false;
                        }
                        break;
                    case ']':
                        if (match != '[') {
                            ans = false;
                        }
                        break;
                    case '}':
                        if (match != '{') {
                            ans = false;
                        }
                        break;
                }
            }
        }
        if (!stack.isEmpty()) {
            ans = false;
        }

        return ans;
    }
}
