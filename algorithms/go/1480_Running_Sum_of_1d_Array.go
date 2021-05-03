func runningSum(nums []int) []int {
	rs := 0
	ans := make([]int, len(nums))
	for i, num := range nums {
		rs += num
		ans[i] = rs
	}
	return ans
}