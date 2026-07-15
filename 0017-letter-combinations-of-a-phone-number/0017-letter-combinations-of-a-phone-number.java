class Solution {
    public List<String> letterCombinations(String digits) {

        // CORRECTED: Handle empty input
        if (digits.length() == 0) {
            return new ArrayList<>();
        }

        String letters = mapKey(digits.charAt(0));

        List<String> ans = new ArrayList<>();

        for (int i = 0; i < letters.length(); i++) {
            ans.add(String.valueOf(letters.charAt(i)));
        }

        // CORRECTED: temp is not needed anymore
        generate(ans, digits, 1);

        return ans;
    }

    // CORRECTED: Removed StringBuilder temp parameter
    private void generate(List<String> ans, String digits, int idx) {

        if (idx == digits.length()) {
            return;
        }

        // CORRECTED: Store old combinations before clearing
        List<String> old = new ArrayList<>(ans);

        ans.clear();

        String letters = mapKey(digits.charAt(idx));

        // CORRECTED: Multiply every old string with every new letter
        for (String s : old) {
            for (int j = 0; j < letters.length(); j++) {

                // CORRECTED: Proper String concatenation
                ans.add(s + letters.charAt(j));
            }
        }

        generate(ans, digits, idx + 1);
    }

    private String mapKey(char digit) {
        switch (digit) {
            case '2':
                return "abc";
            case '3':
                return "def";
            case '4':
                return "ghi";
            case '5':
                return "jkl";
            case '6':
                return "mno";
            case '7':
                return "pqrs";
            case '8':
                return "tuv";
            case '9':
                return "wxyz";
            default:
                return "";
        }
    }
}