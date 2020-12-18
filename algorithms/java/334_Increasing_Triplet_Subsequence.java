class Solution {
    public boolean increasingTriplet(int[] nums) {
        Map<Integer, ArrayList<Integer>> doublet = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            for (int j = i + 1; j < nums.length; ++j) {
                if (nums[i] < nums[j]) {
                    ArrayList<Integer> tmp = doublet.getOrDefault(i, new ArrayList<>());
                    tmp.add(j);
                    doublet.put(i, tmp);
                }
            }
        }
        for (int key : doublet.keySet()) {
            for (int value : doublet.get(key)) {
                if (doublet.containsKey(value)) {
                    return true;
                }
            }
        }
        return false;
    }
}