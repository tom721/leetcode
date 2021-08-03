class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        for c in s:
            if c is "(" or c is "[" or c is "{":
                stack.append(c)
            else:
                if not stack:
                    return False
                p = stack.pop()
                if c is ")" and p is not "(":
                    return False
                if c is "]" and p is not "[":
                    return False
                if c is "}" and p is not "{":
                    return False
        return len(stack) == 0