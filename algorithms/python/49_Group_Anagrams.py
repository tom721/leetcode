class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        group = collections.defaultdict(list)
        for s in strs:
            alpha = ''.join(sorted(s))
            group[alpha].append(s)
        return group.values()