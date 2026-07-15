class Solution {
    public int gcdOfOddEvenSums(int n) {

        int even = 0;
        int odd = 0;
        for(int i = 1; i <= n*2; i++){
            if(i % 2 != 0) {
                odd += i;
            } else {
                even += 1;
            }
        }
        
        return GCD(odd,even);
    }

    public int GCD(int a, int b) {

        if(a <= 0) {
            return b;
        }

        if(b <= 0) {
            return a;
        }

        if(a > b) {
            return GCD(a % b, b);
        } else {
            return GCD(b % a, a);
        }
    }
}