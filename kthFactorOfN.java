class Solution {
    public int kthFactor(int n, int k) {
        LinkedList<Integer> ll1 = new LinkedList<Integer>();
        LinkedList<Integer> ll2 = new LinkedList<Integer>();
        
        for (int i = 1; i*i <= n; i++) {
            if(n % i == 0) {
                ll1.add(i);
                
                if (i*i == n) break;
                ll2.addFirst(n/i);
            }
        }
        
        ll1.addAll(ll2);
      
        if (k > ll1.size()) return -1;
        return ll1.get(k-1);
    }
}