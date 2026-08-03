class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int ans[] = new int[nums1.length];
        //brute force
        for(int i = 0; i < nums1.length; i++){
            ans[i] = findNextGreater(nums1[i], nums2);
        }
        return ans;
    }
    // ..function which will first find the key and then find the next greater element after key
    private int findNextGreater(int key, int[] nums2){
        int ans = -1;
        boolean gotKey = false;
        for(int i = 0; i < nums2.length && ans == -1; i++){
            if(!gotKey){
                if(nums2[i] == key){
                    gotKey = true;
                }
            }else{
                if(nums2[i] > key){
                    ans = nums2[i];
                    break;
                }
            }
        }
        return ans;
    }
}