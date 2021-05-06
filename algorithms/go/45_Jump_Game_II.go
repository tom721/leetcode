type Queue struct {
	items []int
}

func (q *Queue) offer(value int) {
	q.items = append(q.items, value)
}

func (q *Queue) poll() int {
	item, items := q.items[0], q.items[1:]
	q.items = items
	return item
}

func jump(nums []int) int {
	q := Queue{}
	visitied := make([]int, len(nums))
	if len(nums) == 1 {
		return 0
	}

	q.offer(0)
	visitied[0] = 1
	turn := 0
	present := 1
	future := 0
	for {
		idx := q.poll()
		for i := 1; i <= nums[idx]; i++ {
			if idx+i == len(nums)-1 {
				return turn + 1
			}
			if idx+i > len(nums)-1 {
				break
			}
			if visitied[idx+i] == 1 || nums[idx+i] == 0 {
				continue
			}
			q.offer(idx + i)
			visitied[idx+i] = 1
			future++
		}
		if present--; present == 0 {
			turn++
			present = future
			future = 0
		}
	}
}