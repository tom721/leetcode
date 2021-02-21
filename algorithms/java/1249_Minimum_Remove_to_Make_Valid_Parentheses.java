class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> open = new Stack<>();
        Stack<Integer> close = new Stack<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c == '('){
                open.push(i);
                continue;
            }
            if(c == ')' && !open.empty()){
                open.pop();
                continue;
            }
            if(c == ')' && open.empty()){
                close.push(i);
            }
        }
        int[] removeList = new int[open.size() + close.size()];
        int openSize = open.size();
        int closeSize = close.size(); 
        for(int i=0;i<openSize;i++){
            removeList[i] = open.pop();
        }
         for(int i=openSize;i<openSize+closeSize;i++){
            removeList[i] = close.pop();
        }
        
        char[] charArray = s.toCharArray();
        for(int remove : removeList){
            charArray[remove] = '.';
        }
        String answer = String.valueOf(charArray);
        return answer.replace(".","");
    }
}