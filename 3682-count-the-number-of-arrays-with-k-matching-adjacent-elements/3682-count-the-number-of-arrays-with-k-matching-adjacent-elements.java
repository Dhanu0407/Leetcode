class Solution {
    static final int MOD = 1_000_000_007;
    static final int MAX = 100005;
    static long[] fact = new long[MAX];
    static long[] invFact = new long[MAX];
    static boolean initialized = false;

    // Precompute factorials and inverse factorials
    private void init() {
        if (initialized) return;
        initialized = true;
        fact[0] = 1;
        for (int i = 1; i < MAX; i++) {
            fact[i] = (fact[i - 1] * i) % MOD;
        }

        invFact[MAX - 1] = modInverse(fact[MAX - 1]);
        for (int i = MAX - 2; i >= 0; i--) {
            invFact[i] = (invFact[i + 1] * (i + 1)) % MOD;
        }
    }

    // Fermat’s Little Theorem for modular inverse
    private long modInverse(long a) {
        return power(a, MOD - 2);
    }

    private long power(long a, long b) {
        long result = 1;
        a %= MOD;
        while (b > 0) {
            if ((b & 1) == 1)
                result = (result * a) % MOD;
            a = (a * a) % MOD;
            b >>= 1;
        }
        return result;
    }

    // nCr % MOD
    private long nCr(int n, int r) {
        if (r < 0 || r > n) return 0;
        return (((fact[n] * invFact[r]) % MOD) * invFact[n - r]) % MOD;
    }

    public int countGoodArrays(int n, int m, int k) {
        init();
        long combinations = nCr(n - 1, k);
        long ways = (combinations * m) % MOD;
        ways = (ways * power(m - 1, n - k - 1)) % MOD;
        return (int) ways;
    }
}
