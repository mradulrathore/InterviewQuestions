class Solution {
    public int kthFactor(int n, int k) {
        
        ArrayList<Integer> a1 = new ArrayList<>();
        ArrayList<Integer> a2 = new ArrayList<>();
        for(int i = 1; i*i <= n; i++)   // sqrt factorization
        {
            if(n%i == 0)
            {
                a1.add(i);
                if(i != n/i)
                    a2.add(n/i);                       
            }
        }
        for(int j = 0; j < a2.size(); j++)
            a1.add( a2.get( a2.size() - j -1)); // Merging both list in sorted order
        if(a1.size()<k)
            return -1; // if kth factor is not available
        else
            return a1.get(k-1);   // return kth factor       
    }
}
