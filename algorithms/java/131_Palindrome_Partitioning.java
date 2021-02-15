class Solution {
    List<List<String>> answer = new ArrayList<>();

    public List<List<String>> partition(String s) {
        dfs(new ArrayList<>(), s);
        return answer;
    }

    void dfs(List<String> pre_s, String s) {
        if (s.isEmpty()) {
            answer.add(new ArrayList<String>(pre_s));
        }
        for (int i = 0; i < s.length(); ++i) {
            if (isPalindrome(s.substring(0, i + 1)) == false) {
                continue;
            }
            pre_s.add(s.substring(0, i + 1));
            dfs(pre_s, s.substring(i + 1, s.length()));
            pre_s.remove(pre_s.size() - 1);
        }
    }

    boolean isPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; ++i) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }
}