func countPrimes(n int) int {
	isPrime := make([]bool, n+1)
	for i := 2; i < n; i++ {
		isPrime[i] = true
	}

	for i := 2; i*i <= n; i++ {
		if isPrime[i] {
			for j := i * i; j <= n; j += i {
				isPrime[j] = false
			}
		}
	}

	ans := 0
	for i := 0; i < n; i++ {
		if isPrime[i] {
			ans++
		}
	}
	return ans
}