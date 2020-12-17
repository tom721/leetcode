class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int answer = 0;
        Map<Integer, Integer> AB = getSumMap(A, B);
        Map<Integer, Integer> CD = getSumMap(C, D);
        
        for(int ABSum : AB.keySet()){
            if(CD.containsKey(-1*ABSum)){
                answer += (AB.get(ABSum) * CD.get(-1*ABSum));
            }
        }
        return answer;
    }
    
    Map<Integer, Integer> getSumMap(int[] array1, int[] array2){
        Map<Integer, Integer> sumMap = new HashMap<>();
        for(int i=0;i<array1.length;++i){
            for(int j=0;j<array2.length;++j){
                int sum = array1[i] + array2[j];
                if(!sumMap.containsKey(sum)){
                    sumMap.put(sum,1);
                    continue;
                }
                sumMap.replace(sum,sumMap.get(sum)+1);
            }
        }
        return sumMap;
    }
}