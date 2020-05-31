// Given a rectangular cake with height h and width w, and two arrays of integers horizontalCuts and verticalCuts where horizontalCuts[i] is the distance from the top of the rectangular cake to the ith horizontal cut and similarly, verticalCuts[j] is the distance from the left of the rectangular cake to the jth vertical cut.

// Return the maximum area of a piece of cake after you cut at each horizontal and vertical position provided in the arrays horizontalCuts and verticalCuts. Since the answer can be a huge number, return this modulo 10^9 + 7.

// Input: h = 5, w = 4, horizontalCuts = [1,2,4], verticalCuts = [1,3]
// Output: 4 
// Explanation: The figure above represents the given rectangular cake. Red lines are the horizontal and vertical cuts. After you cut the cake, the green piece of cake has the maximum area.

// Input: h = 5, w = 4, horizontalCuts = [3,1], verticalCuts = [1]
// Output: 6
// Explanation: The figure above represents the given rectangular cake. Red lines are the horizontal and vertical cuts. After you cut the cake, the green and yellow pieces of cake have the maximum area.


class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        int i=0;
        int mod=1000000007;
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        long box1=horizontalCuts[i]-0;
        long box2=verticalCuts[i]-0;
        for(i=1;i<horizontalCuts.length;i++){
            if((horizontalCuts[i]-horizontalCuts[i-1])>box1)
                box1 = horizontalCuts[i]-horizontalCuts[i-1];
        }
          if(h-horizontalCuts[horizontalCuts.length-1]>box1)
                box1=h-horizontalCuts[horizontalCuts.length-1];
         for(i=1;i<verticalCuts.length;i++){
            if((verticalCuts[i]-verticalCuts[i-1])>box2)
                box2 = verticalCuts[i]-verticalCuts[i-1];
        }
          if(w-verticalCuts[verticalCuts.length-1]>box2)
                box2=w-verticalCuts[verticalCuts.length-1];
        System.out.println(box2 * box1);
        int res = (int)((box1 * box2)%mod);
        return res;
    }
}