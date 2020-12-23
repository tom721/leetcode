class Solution {
    public int nextGreaterElement(int n) {
        List<Integer> digit = new ArrayList<>();
        int tmp = n;
        while (tmp != 0) {
            digit.add(tmp % 10);
            tmp /= 10;
        }
        Collections.reverse(digit);

        int length = digit.size();
        int a = -1, b = -1;
        for (int i = 0; i < length; ++i) {
            for (int j = i + 1; j < length; ++j) {
                if (digit.get(j) > digit.get(i)) {
                    if (a != i) {
                        a = i;
                        b = j;
                        continue;
                    }
                    if (b != -1 && digit.get(b) > digit.get(j)) {
                        b = j;
                    }
                }
            }
        }

        if (a == -1) {
            return -1;
        }

        tmp = digit.get(a);
        digit.set(a, digit.get(b));
        digit.set(b, tmp);

        int[] digitArray = new int[length];
        for (int i = 0; i < length; ++i) {
            digitArray[i] = digit.get(i);
        }
        Arrays.sort(digitArray, a + 1, length);

        long ans = 0;
        int exp = 1;
        for (int i = 0; i < length; ++i) {
            ans += (long) digitArray[length - i - 1] * exp;
            exp *= 10;
        }

        if (ans > Integer.MAX_VALUE) {
            return -1;
        }
        return (int) ans;
    }
}