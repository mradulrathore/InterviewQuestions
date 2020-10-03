class Solution {
public:
    int kthFactor(int n, int k) {

        // to store the unique factors
        set<int> factors;

        // factors lies in pairs, half lie below sqrt(n), half lie above sqrt(n).
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                factors.insert(i);
                factors.insert(n / i);
            }
        }
        // if k is grater than no.of factors , return -1
        if (k > factors.size()) {
            return -1;
        }

        // getting the kth factor
        auto it = factors.begin();
        advance(it, k - 1);
        return *it;
    }
};
