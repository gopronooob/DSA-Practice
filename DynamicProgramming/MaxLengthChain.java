/*
**************** Problem Description ****************
You are given an array of n pairs pairs where pairs[i] = [lefti, righti] and lefti < righti.
A pair p2 = [c, d] follows a pair p1 = [a, b] if b < c. A chain of pairs can be formed in this fashion.
Return the length longest chain which can be formed.
You do not need to use up all the given intervals. You can select pairs in any order.
    Example : 1

    Input: pairs = [[1,2],[2,3],[3,4]]
    Output: 2
    Explanation: The longest chain is [1,2] -> [3,4].
    Example : 2

    Input: pairs = [[1,2],[7,8],[4,5]]
    Output: 3
    Explanation: The longest chain is [1,2] -> [4,5] -> [7,8].
*/

class Solution {
    public int findLongestChain(int[][] pairs) {

        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);

        int n=pairs.length;

        int dp[] = new int[n];
        dp[0]=1;
        int ans=1;
        for(int i=1;i<n;i++)
        {
            int max=0;
            for(int j=0;j<i;j++)
            {

                if(pairs[j][1]<pairs[i][0])
                {
                    if(max<dp[j])
                    {
                        max=dp[j];
                    }
                }
            }
            max+=1;
            dp[i]=max;
            ans=Math.max(ans,max);
        }

        return ans;
    }
}

/*
**************** Logic ****************
Variation of Longest Increasing Subsequence.
*/