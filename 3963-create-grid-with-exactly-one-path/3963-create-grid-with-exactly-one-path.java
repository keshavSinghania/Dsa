class Solution {
    public String[] createGrid(int m, int n) {
        String ans[] = new String[m];
        int idx = 0;
        for(int i = 0; i < m; i++){
            String temp = "";
            for(int j = 0; j < n; j++){
                if(i == 0){
                    temp += '.';
                }else if(j == n-1){
                    temp += '.';
                }else{
                    temp += '#';
                }
            };
            ans[idx++] = temp;
        }
        return ans;
    }
}