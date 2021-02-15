class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            Character tmp = s.charAt(i);
            sMap.put(tmp, sMap.getOrDefault(tmp, 0) + 1);

            tmp = t.charAt(i);
            tMap.put(tmp, tMap.getOrDefault(tmp, 0) + 1);
        }

        if (sMap.size() != tMap.size()) {
            return false;
        }

        for (Character key : sMap.keySet()) {
            if (!sMap.get(key).equals(tMap.get(key))) {

                return false;
            }
        }
        return true;
    }
}