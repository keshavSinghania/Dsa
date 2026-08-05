// class Solution {
//     public int trap(int[] height) {
//         int[] prevSum = new int[height.length];
//         int h1Idx = -1;
//         int maxHeightIdx = -1;
//         int trapedWater = 0;
//         prevSum[0] = 0;

//         //finding the first height index that is first non zero height
//         for (int i = 0; i < height.length; i++) {
//             if (height[i] > 0) {
//                 h1Idx = i;
//                 break;
//             }
//         }
//         //if all are zero 
//         if (h1Idx == -1)
//             return 0;

//         //now we will run loop and try to find next greater element 
//         //we will store sum of all the height in prevSum array indeces wise
//         //we wil also store the index with highest height next
//         for (int i = h1Idx + 1; i < height.length; i++) {
//             int currHeight = height[i];

//             //edge case: if its a last element (find traped water with max height till now)
//             if (i == height.length - 1) {
//                 int h2Idx = (maxHeightIdx != -1) ? maxHeightIdx : i;
//                 trapedWater += findWater(Math.min(height[h1Idx], height[h2Idx]), (prevSum[h2Idx] - prevSum[h1Idx + 1]),
//                         h2Idx - h1Idx - 1);
//                 h1Idx = h2Idx;
//             }
//             if (currHeight >= height[h1Idx]) {
//                 //find area
//                 trapedWater += findWater(height[h1Idx], (prevSum[i] - prevSum[h1Idx + 1]), i - h1Idx - 1);
//                 // make current as new h1Idx
//                 h1Idx = i;
//                 maxHeightIdx = -1;
//             } else {
//                 //keep storing highest height
//                 if (maxHeightIdx == -1 || height[maxHeightIdx] < currHeight) {
//                     maxHeightIdx = i;
//                 }
//             }
//             //continue creating prevsum
//             prevSum[i] = prevSum[i - 1] + currHeight;
//         }
//         return trapedWater;
//     }

//     //function
//     private int findWater(int height, int sum, int dist) {
//         return (height * dist) - sum;
//     }
// }


class Solution {
    public int trap(int[] height) {
        int n = height.length;
        if (n < 3) return 0;

        // Prefix sum
        int[] pre = new int[n];
        pre[0] = height[0];
        for (int i = 1; i < n; i++) {
            pre[i] = pre[i - 1] + height[i];
        }

        // First non-zero bar
        int h1 = 0;
        while (h1 < n && height[h1] == 0) h1++;
        if (h1 == n) return 0;

        int water = 0;

        while (h1 < n - 1) {

            int nextGreater = -1;
            int maxIdx = -1;

            // Search from scratch
            for (int i = h1 + 1; i < n; i++) {

                if (maxIdx == -1 || height[i] > height[maxIdx])
                    maxIdx = i;

                if (height[i] >= height[h1]) {
                    nextGreater = i;
                    break;
                }
            }

            int h2 = (nextGreater != -1) ? nextGreater : maxIdx;

            if (h2 == -1)
                break;

            int insideSum = 0;
            if (h2 - h1 > 1)
                insideSum = pre[h2 - 1] - pre[h1];

            water += Math.min(height[h1], height[h2]) * (h2 - h1 - 1) - insideSum;

            h1 = h2;
        }

        return water;
    }
}