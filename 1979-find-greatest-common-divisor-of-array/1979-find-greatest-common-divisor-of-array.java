class Solution {
    public int findGCD(int[] nums) {
        int largestNum = maxElement(nums);
        int smallestNum = minElement(nums);

        return GCD(largestNum,smallestNum);

    }

    int GCD(int a, int b) {

        if(a == 0)  
            return b;
        
        if(b == 0)
            return a;

        if (a >= b) {
            return GCD(a%b,b);
        } else {
            return GCD(b%a,a);
        }
    }

    int maxElement(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    int minElement(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

}