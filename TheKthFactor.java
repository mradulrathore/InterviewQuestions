class Solution {
    public int kthFactor(int n, int k) {
        
        ArrayList<Integer> al= new ArrayList<>();
        for(int i=1;i<=n;i++)
        {
            if(n%i==0)
                al.add(i);
        }
        
        if(al.size()<k)
            return -1;
        else
        {
            Integer[] arr = new Integer[al.size()]; 
            arr = al.toArray(arr); 
            Arrays.sort(arr);
            
            
        return arr[k-1];     
        }
       

        
    }
}