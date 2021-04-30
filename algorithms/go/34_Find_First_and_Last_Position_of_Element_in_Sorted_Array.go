func searchRange(nums []int, target int) []int {
	l := 0
	r := len(nums) - 1
	m := (l + r) / 2
	t := -1

	for l <= r {
		if nums[m] < target {
			l = m + 1
		} else if nums[m] == target {
			t = m
			break
		} else {
			r = m - 1
		}
		m = (l + r) / 2
	}

	if t == -1 {
		return []int{-1, -1}
	}

	ans := []int{t, t}
	for i := 1; ; i++ {
		if t-i < 0 || nums[t-i] != target {
			break
		}
		ans[0]--
	}
	for i := 1; ; i++ {
		if t+i == len(nums) || nums[t+i] != target {
			break
		}
		ans[1]++
	}
	return ans
}