class Solution {
    public int numberOfSubstrings(String s) {

        int count = 0;

        int indexA = -1;
        int indexB = -1;
        int indexC = -1;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == 'a') {
                indexA = i;
            } else if (s.charAt(i) == 'b') {
                indexB = i;
            } else {
                indexC = i;
            }

            if (indexA != -1 && indexB != -1 && indexC != -1) {
                count += 1 + Math.min(indexA, Math.min(indexB, indexC));
            }
        }

        return count;
    }
}