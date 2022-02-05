class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> combinations = new ArrayList();
        dfs(combinations,"",n,0,0);
        return combinations;
    }
    
    private void dfs(List<String> combinations,String current,int n,int open,int close) {
        if(open == n && close == n) {
            combinations.add(current);
            return;
        }
        if(open < n) {
            dfs(combinations,current+"(",n,open+1,close);
        }
        if(close < open) {
            dfs(combinations,current+")",n,open,close+1);
        }
    }
}