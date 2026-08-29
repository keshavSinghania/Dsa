class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        int currentChildrenIdx = 0;
        for(int i = 0; i < s.length; i++){
            if(currentChildrenIdx > g.length - 1) return count;
            if(g[currentChildrenIdx] <= s[i]){
                count++;
                currentChildrenIdx++;
            }
        }
        return count;
    }
}