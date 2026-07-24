class Solution {
    public int maxArea(int[] height) {
         int start = 0;
         int end = height.length - 1;

         int max = Integer.MIN_VALUE;
         
         while(start <= end) {
            int h = Math.min(height[start], height[end]);
            int w = end - start;

            max = Math.max(max,h*w);

            if(height[start] > height[end]) {
                end--;
            } else {
                start++;
            }

         }

         return max;
    }
}