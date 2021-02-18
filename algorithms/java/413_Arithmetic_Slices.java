class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        if (A.length < 3) {
            return 0;
        }
        int n = 2;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < A.length - 2; i++) {
            if (A[i + 1] - A[i] == A[i + 2] - A[i + 1]) {
                n++;
            } else if (n > 2) {
                list.add(n);
                n = 2;
            }

            if (i == A.length - 3 && n > 2) {
                list.add(n);
            }
        }

        int answer = 0;
        for (int l : list) {
            answer += (l - 2) * (l - 1) / 2;
        }
        return answer;
    }
}