func checkPossibility(nums []int) bool {
	d := 0
	if len(nums) == 1 {
		return true
	}
	if nums[0] > nums[1] {
		d = 1
	}

	for i := 1; i < len(nums)-1; i++ {
		if nums[i+1] < nums[i] {
			if d == 0 {
				if nums[i+1] < nums[i-1] {
					nums[i+1] = nums[i]
				} else {
					nums[i] = nums[i-1]
				}
			}
			d++
		}
		if d > 1 {
			return false
		}
	}
	return true
}