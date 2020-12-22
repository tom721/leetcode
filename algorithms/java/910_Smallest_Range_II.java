class Solution {
    public int smallestRangeII(int[] A, int K) {
        Arrays.sort(A);
        int ans = A[A.length - 1] - A[0];

        for (int i = 0; i < A.length; ++i) {
            A[i] -= K;
        }

        for (int i = 0; i < A.length - 1; ++i) {
            A[i] += 2 * K;
            int min = Math.min(A[0], A[i + 1]);
            int max = Math.max(A[i], A[A.length - 1]);
            ans = Math.min(ans, max - min);
        }
        return ans;
    }
}