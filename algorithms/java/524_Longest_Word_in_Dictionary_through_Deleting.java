class Solution {
    public String findLongestWord(String s, List<String> d) {
        int longest = 0;
        List<String> longestWord = new ArrayList<>();
        for (String word : d) {
            int len = word.length();
            if (len < longest) {
                continue;
            }

            int wIdx = 0;
            for (int i = 0; i < s.length(); i++) {
                if (wIdx == len) {
                    break;
                }
                if (s.charAt(i) == word.charAt(wIdx)) {
                    wIdx++;
                }
            }

            if (len != wIdx) {
                continue;
            }

            if (longest < len) {
                longest = len;
                longestWord = new ArrayList<>();
            }

            longestWord.add(word);
        }

        if (longestWord.size() == 0) {
            return "";
        }

        String answer = longestWord.get(0);
        for (int i = 1; i < longestWord.size(); i++) {
            String tmp = longestWord.get(i);
            if (answer.compareTo(tmp) > 0) {
                answer = tmp;
            }
        }
        return answer;
    }
}