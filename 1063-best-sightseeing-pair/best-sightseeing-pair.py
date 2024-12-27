class Solution:
    def maxScoreSightseeingPair(self, values: List[int]) -> int:
        ans = 0
        Prev = values[0]

        for j in range(1, len(values)):
            ans = max(ans, Prev + values[j] - j)
            Prev = max(Prev, values[j] + j)

        return ans