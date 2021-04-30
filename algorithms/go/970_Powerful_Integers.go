func powerfulIntegers(x int, y int, bound int) []int {
	if bound < 1 {
		return []int{}
	}
	xPow := []int{}
	yPow := []int{}

	xMul := 1
	for xMul < bound {
		xPow = append(xPow, xMul)
		if x == 1 {
			break
		}
		xMul *= x
	}

	yMul := 1
	for yMul < bound {
		yPow = append(yPow, yMul)
		if y == 1 {
			break
		}
		yMul *= y
	}

	proxy := make(map[int]bool)
	for _, xp := range xPow {
		for _, yp := range yPow {
			if xp+yp > bound {
				break
			}
			proxy[xp+yp] = true
		}
	}

	ans := []int{}
	for pi, _ := range proxy {
		ans = append(ans, pi)
	}
	return ans
}