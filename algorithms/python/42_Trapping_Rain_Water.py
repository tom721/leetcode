class Solution:
    def trap(self, height: List[int]) -> int:
        start = -1
        rain = 0
        
        if len(height) == 0:
            return 0
                
        for i, h in enumerate(height):
            if start == -1 and h != 0:
                start = i
                break
                
        for i in range(start+1,len(height)):
            if start == i-1:
                maxH = max(height[start:])
                if height[start] == maxH:
                    height[start] = max(height[start+1:])
            
            if height[i] < height[start]:
                rain += height[start] - height[i]
            else:
                start = i
                
        return rain     