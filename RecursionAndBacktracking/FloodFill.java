/*
An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.

You are also given three integers sr, sc, and newColor. You should perform a flood fill on the image starting from the pixel image[sr][sc].

To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color), and so on. Replace the color of all of the aforementioned pixels with newColor.

Return the modified image after performing the flood fill.

Input: image = [[0,0,0],[0,0,0]], sr = 0, sc = 0, newColor = 2
Output: [[2,2,2],[2,2,2]]
*/

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
        int oldColor=image[sr][sc];
        if(oldColor==newColor)
            return image;
        floodFill(image,sr,sc,newColor,oldColor);
        return image;
    }
    
    private void floodFill(int[][] image, int sr,int sc,int newColor,int oldColor)
    {
        if(sr<0 || sc<0 || sr>=image.length || sc >=image[0].length ||image[sr][sc]!=oldColor ||newColor==image[sr][sc])
        {
            return;
        }
        image[sr][sc]=newColor;
        floodFill(image,sr-1,sc,newColor,oldColor);
        floodFill(image,sr,sc-1,newColor,oldColor);
        floodFill(image,sr+1,sc,newColor,oldColor);
        floodFill(image,sr,sc+1,newColor,oldColor);
        
    }
}

/* 
With recursion will all 4 sides if any of side is not outside image, not similar to old color, already painted then return
*/