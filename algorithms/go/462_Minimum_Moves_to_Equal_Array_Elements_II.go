func minMoves2(nums []int) int {
	sort.Ints(nums)
	median := nums[len(nums)/2]

	move := 0
	for _, num := range nums {
		if num > median {
			move += num - median
		} else {
			move += median - num
		}
	}
	return move
}