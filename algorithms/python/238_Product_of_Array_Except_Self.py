class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        mul = []
        p = 1
        for i in range(len(nums)):
            mul.append(p)
            p *= nums[i]
            
        p = 1
        for i in range(len(nums)-1,-1,-1):
            mul[i] *= p
            p *= nums[i]
        
        return mul
        