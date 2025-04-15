class Solution {
    public long goodTriplets(int[] nums1, int[] nums2) {
        int n = nums1.length;

        // Map value to its index in nums2
        int[] pos2 = new int[n];
        for (int i = 0; i < n; i++) {
            pos2[nums2[i]] = i;
        }

        // Transform nums1 into mapped positions from nums2
        int[] mapped = new int[n];
        for (int i = 0; i < n; i++) {
            mapped[i] = pos2[nums1[i]];
        }

        // BIT to count smaller elements to the left
        FenwickTree bitLeft = new FenwickTree(n);
        int[] leftCount = new int[n];
        for (int i = 0; i < n; i++) {
            leftCount[i] = bitLeft.query(mapped[i] - 1); // count of elements < mapped[i]
            bitLeft.update(mapped[i], 1);
        }

        // BIT to count greater elements to the right
        FenwickTree bitRight = new FenwickTree(n);
        int[] rightCount = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            rightCount[i] = bitRight.query(n - 1) - bitRight.query(mapped[i]);
            bitRight.update(mapped[i], 1);
        }

        // Total good triplets
        long res = 0;
        for (int i = 0; i < n; i++) {
            res += (long) leftCount[i] * rightCount[i];
        }

        return res;
    }

    // Fenwick Tree (1-indexed internally)
    class FenwickTree {
        int[] tree;
        int size;

        public FenwickTree(int n) {
            size = n + 2;
            tree = new int[size];
        }

        void update(int index, int delta) {
            index++; // 1-based indexing
            while (index < size) {
                tree[index] += delta;
                index += index & -index;
            }
        }

        int query(int index) {
            index++; // 1-based indexing
            int res = 0;
            while (index > 0) {
                res += tree[index];
                index -= index & -index;
            }
            return res;
        }
    }
}
