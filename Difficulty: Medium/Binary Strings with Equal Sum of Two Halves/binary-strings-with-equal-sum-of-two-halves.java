class Solution{

    final long mod = 1000000007;

    public int  computeValue(int n){
        // code here
        long ans =0;
        long n_fact =1;
        
        for(int i=0; i<=n; i++){
            n_fact = (n_fact%mod*n_fact%mod)%mod;
        }

        long r_fact =1;
        long n_r_fact = n_fact;
        for(int r =0;r<=n;r++){
            long denom = (r_fact %mod * n_r_fact%mod)%mod;
            long nCr= (n_fact%mod *power(denom,mod-2))%mod;
            
            ans= (ans%mod + ((nCr%mod*nCr%mod)%mod)%mod);
            r_fact = (r_fact%mod*(r+1)%mod)%mod;
            
            if(n !=r) n_r_fact = (n_r_fact%mod * power((n-r),mod-2)%mod)%mod;
        }
        return (int)ans;
    }

    long power(long a , long b){
        if(b==0) return 1;
        
        long half = power(a,b/2);
        long full = (half%mod*half%mod)%mod;

        if(b%2==1) full = (full%mod*a%mod)%mod;
        return full;
    }
}