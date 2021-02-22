class Solution {
    public int brokenCalc(int X, int Y) {
        int oper = 0;
        while(Y > X){
            if(Y %  2 == 0){
                Y /= 2;
            }else{
                Y += 1;
            }
            oper++;
        }
        return oper+X-Y;
    }
}