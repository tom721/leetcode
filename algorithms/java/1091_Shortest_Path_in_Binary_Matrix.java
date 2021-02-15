class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1 || grid[grid.length - 1][grid.length - 1] == 1) {
            return -1;
        }
        int[][] dir = { { -1, -1 }, { 0, -1 }, { 1, -1 }, { -1, 0 }, { 1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 } };
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(0, 0));
        int shortest = 1;
        int parent = 1;
        int child = 0;
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            if (p.x == grid.length - 1 && p.y == grid.length - 1) {
                return shortest;
            }
            parent--;
            grid[p.x][p.y] = 1;

            for (int i = 0; i < 8; i++) {
                int deltaX = p.x + dir[i][0];
                int deltaY = p.y + dir[i][1];
                if (deltaX < 0 || deltaX == grid.length || deltaY < 0 || deltaY == grid.length) {
                    continue;
                }
                if (grid[deltaX][deltaY] == 1) {
                    continue;
                }
                queue.offer(new Point(deltaX, deltaY));
                child++;
            }

            if (parent == 0) {
                parent = child;
                child = 0;
                shortest++;
            }
        }
        return -1;
    }

    class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}