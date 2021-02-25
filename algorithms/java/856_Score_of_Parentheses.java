class Solution {
    public int scoreOfParentheses(String S) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') {
                stack.push(0);
            } else {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b + Math.max(1, 2 * a));
            }
        }
        return stack.pop();
    }
}