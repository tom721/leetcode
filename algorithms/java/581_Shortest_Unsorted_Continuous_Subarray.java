class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int[] sort = nums.clone();
        Arrays.sort(sort);

        int start = -1;
        int end = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == sort[i]) {
                continue;
            }
            if (start == -1) {
                start = i;
            }
            end = i;
        }

        if (start == -1) {
            return 0;
        }
        return end - start + 1;
    }
}