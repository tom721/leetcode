class Solution:
    def isPalindrome(self, s: str) -> bool:
        processed = []
        for c in s:
            if c.isalnum():
                processed.append(c.lower())
        return processed == processed[::-1]