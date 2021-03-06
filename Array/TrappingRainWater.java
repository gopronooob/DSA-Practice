/*
**************** Problem Description ****************
Given an array arr[] of N non-negative integers representing the height of blocks.
If width of each block is 1, compute how much water can be trapped between the blocks during the rainy season. 
  Example : 
  Input:
  N = 6
  arr[] = {3,0,0,2,0,4}
  Output: 10
*/
public class TrappingRainWater {
    public int trap(int[] height) {

        int ans = 0;
        int arrLength = height.length;
        if (arrLength <= 1)
            return ans;

        int[] leftMax = new int[arrLength];

        int rightMax = Integer.MIN_VALUE;
        leftMax[0] = 0;
        for (int i = 1; i < arrLength; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i - 1]);
        }

        for (int i = arrLength - 2; i >= 0; i--) {
            rightMax = Math.max(rightMax, height[i + 1]);
            int water = (Math.min(rightMax, leftMax[i])) - height[i];

            if (water > 0)
                ans += water;
        }

        return ans;
    }
}

/*
 **************** Logic **************** Trapped water at any index = min(max height left, max
 * height right) - current height
 */

 /* OR can be done with two pointer approach */


 class Solution {
    public int trap(int[] height) {
        
        int leftMax=height[0];
        int rightMax=0;
        int left=0;
        int right=height.length-1;
        int ans=0;
        
        while(left<right){
            if(height[left]<height[right])
            {
                if(height[left]>=leftMax)
                {
                    leftMax=height[left];
                }
                else
                {
                    ans+=leftMax-height[left];
                }
                left++;
                
            }
            else
            {
                if(height[right]>=rightMax)
                {
                    rightMax=height[right];
                }
                else
                {
                    ans+=rightMax-height[right];
                }
                right--;
            }
        }
        return ans;
    }
}