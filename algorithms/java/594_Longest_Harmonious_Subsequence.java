class Solution {
    public int findLHS(int[] nums) {
        int answer = 0;
        int num_len = nums.length;
        for(int i=0;i<num_len-1;i++){
            List<Integer> minus = new ArrayList<>();
            List<Integer> plus = new ArrayList<>();
            
            minus.add(nums[i]);
            plus.add(nums[i]);
            
            for(int j=i+1;j<num_len;j++){
                if(nums[i] - nums[j] == 0){
                    minus.add(nums[j]);
                    plus.add(nums[j]);
                    continue;
                }else if(nums[i] - nums[j] == -1){
                    plus.add(nums[j]);
                }else if(nums[i] - nums[j] == 1){
                    minus.add(nums[j]);
                }
            }
            
            int ps = plus.size() == 1 ? 0 : plus.size();
            int ms = minus.size() == 1 ? 0 : minus.size();
            
            for(int j=0;j<minus.size()-1;j++){
                if(!minus.get(j).equals(minus.get(j+1))){
                    break;
                }
                if(j==minus.size()-2){
                    ms = 0;
                }
            }
            for(int j=0;j<plus.size()-1;j++){
                if(!plus.get(j).equals(plus.get(j+1))){
                    break;
                }
                if(j==plus.size()-2){
                    ps = 0;
                }
            }
             
            int bigger = ps > ms ? ps : ms;
            answer = answer > bigger ? answer : bigger;
        }
        return answer;
    }
}