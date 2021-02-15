class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        color[0] = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int adj : graph[node]) {
                if (color[adj] == 0) {
                    color[adj] = -1 * color[node];
                    queue.offer(adj);
                } else if (color[adj] == color[node]) {
                    return false;
                }
            }
            if (queue.isEmpty()) {
                for (int i = 0; i < color.length; i++) {
                    if (color[i] == 0) {
                        color[i] = 1;
                        queue.offer(i);
                        break;
                    }
                }
            }
        }
        return true;
    }
}