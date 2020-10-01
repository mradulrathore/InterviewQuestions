class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n  = word2.length();
        int memo[][] = new int[m+1][n+1];
        for(int rows[]:memo)
            Arrays.fill(rows,-1);
        return Rec(word1,word2,word1.length(),word2.length(),memo);
    }
    public int Rec(String s1, String s2, int m, int n,int memo[][]){
        if(memo[m][n]!=-1)  return memo[m][n];
        else if(m==0)    memo[m][n]=n;
        else if(n==0)    memo[m][n]=m;
        else if(s1.charAt(m-1)==s2.charAt(n-1))
            memo[m][n]=Rec(s1,s2,m-1, n-1,memo);
        else
            memo[m][n]= 1+ (int)Math.min(Math.min(Rec(s1, s2, m,n-1,memo),Rec(s1,s2,m-1,n,memo)),Rec(s1,s2,m-1,n-1,memo));
        return memo[m][n];
    }
}
