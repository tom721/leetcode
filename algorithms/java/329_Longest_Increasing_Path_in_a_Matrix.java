class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                dp[i][j] = -1;
            }
        }
        
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(dp[i][j] != -1) {
                    continue;
                }
                dp[i][j] = dfs(matrix,dp,new Point(i,j));
            }
        }
            
        int answer = 0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                answer = dp[i][j] > answer ? dp[i][j] : answer;
            }
        }
        
        return answer;
    }
    
    int dfs(int[][] m,int[][] dp,Point p) {
        List<Point> access = new ArrayList<>(); 
        if(p.x-1>=0 && m[p.x][p.y] < m[p.x-1][p.y]) {
            access.add(new Point(p.x-1,p.y));
        }
        if(p.x+1<dp.length && m[p.x][p.y] < m[p.x+1][p.y]) {
            access.add(new Point(p.x+1,p.y));
        }
        if(p.y-1>=0 && m[p.x][p.y] < m[p.x][p.y-1]) {
            access.add(new Point(p.x,p.y-1));
        }
        if(p.y+1<dp[0].length && m[p.x][p.y] < m[p.x][p.y+1]) {
            access.add(new Point(p.x,p.y+1));
        }
        
        if(access.isEmpty()){
            return 1;
        }
        
        int longest = 0;
        for(Point ac : access) {
            dp[ac.x][ac.y] = dp[ac.x][ac.y] != -1 ? dp[ac.x][ac.y] : dfs(m,dp,new Point(ac.x,ac.y));
            longest = longest > dp[ac.x][ac.y] ? longest : dp[ac.x][ac.y];
        }
        return longest + 1;
    }
    
    class Point {
        int x;
        int y;
        Point(int x,int y) {
            this.x = x;
            this.y = y;
        }
    }
}