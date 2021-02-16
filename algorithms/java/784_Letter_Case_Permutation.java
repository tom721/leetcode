class Solution {
    public List<String> letterCasePermutation(String S) {
        int charPoint = -1;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) > 64) {
                charPoint = i;
                break;
            }
        }

        List<String> answer = new ArrayList<>();
        if (charPoint == -1) {
            answer.add(S);
            return answer;
        }

        String numString = S.substring(0, charPoint);
        List<String> part = letterCasePermutation(S.substring(charPoint + 1));
        String stringPoint = Character.toString(S.charAt(charPoint));
        String convert = Character.toString(S.charAt(charPoint) - 32);
        if (S.charAt(charPoint) < 91) {
            convert = Character.toString(S.charAt(charPoint) + 32);
        }
        for (String ps : part) {
            answer.add(numString + stringPoint + ps);
            answer.add(numString + convert + ps);
        }
        return answer;
    }
}