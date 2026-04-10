/* //Using Binary Exponentiation Method
class Solution {
    public int nthRoot(int n, int m) {
        if (m == 0)
            return 0;
        if (n == 1)
            return m;

        int low = 1, high = m;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int val = power(mid, n, m);

            if (val == 1) {
                return mid; // exact nth root found
            } else if (val == 0) {
                low = mid + 1; // need bigger value
            } else {
                high = mid - 1; // value too large
            }
        }
        return -1; // no integer nth root exists
    }

    // O(log n) power function using binary exponentiation
    public int power(int x, int n, int m) {
        long result = 1;
        long base = x;

        while (n > 0) {
            // if n is odd, multiply result with current base
            if (n % 2 == 1) {
                result *= base;
                if (result > m)
                    return 2; // exceeds limit → no need to continue
            }

            // square the base
            base = base * base;

            // IMPORTANT LINE:
            // If base becomes greater than m, we cap it to (m + 1)
            // Reason:
            // - We only care whether value is > m, == m, or < m
            // - Exact large value is not needed
            // - Prevents overflow (base can grow very fast like x^(2^k))
            // - Setting it to (m + 1) safely marks it as "greater than m"
            if (base > m)
                base = m + 1;

            // divide exponent by 2
            n = n / 2;
        }

        if (result == m)
            return 1; // exact match
        return (result < m) ? 0 : 2; // less or greater
    }
}
//TC - O(logn * logm)




class Solution {
    public int nthRoot(int n, int m) {
        if (m == 0)
            return 0;
        if (n == 1)
            return m;

        int low = 1, high = m;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int val = power(mid, n, m);

            if (val == 1) {
                return mid;
            } else if (val == 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    // Linear exponentiation 
    public int power(int x, int n, int m) {
        long result = 1;

        for (int i = 0; i < n; i++) {
            result *= x;

            if (result > m)
                return 2; // x^n > m
        }

        if (result == m)
            return 1; // x^n == m

        return 0; // x^n < m
    }
}
//TC - O(n * log m)  */