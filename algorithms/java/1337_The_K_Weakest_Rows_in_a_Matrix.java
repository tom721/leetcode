class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int[] soldiers = new int[mat.length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 0) {
                    break;
                }
                soldiers[i]++;
                ;
            }
        }

        int[] sorted = soldiers.clone();
        Arrays.sort(sorted);

        int[] answer = new int[k];
        int cIdx = 0;
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < soldiers.length; j++) {
                if (soldiers[j] == sorted[cIdx]) {
                    answer[cIdx] = j;
                    soldiers[j] = -1;
                    cIdx++;
                    break;
                }
            }
        }
        return answer;
    }
}