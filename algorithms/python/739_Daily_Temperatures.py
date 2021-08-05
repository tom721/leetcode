class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        l = len(temperatures)
        warmer = [0 for i in range(l)]
        
        stack = []
        for i in range(l):
            while stack and temperatures[stack[-1]] < temperatures[i]:
                s = stack.pop()
                warmer[s] = i - s
            stack.append(i)
                    
        return warmer