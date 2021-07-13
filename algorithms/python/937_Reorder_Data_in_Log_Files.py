class Solution:
    def reorderLogFiles(self, logs: List[str]) -> List[str]:
        alnum = []
        num = []
        for s in logs :
            s_list = s.split()
            if ''.join(s_list[1:]).isdigit() == False: 
                alnum.append((s_list[0],' '.join(s_list[1:])))
            else:
                num.append(s)
        alnum.sort(key=lambda x:(x[1],x[0]))
        
        answer = []
        for i,l in alnum:
            answer.append(i + " " + l)
        answer += num
        return answer
        