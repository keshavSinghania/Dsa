class Solution {
    public int totalFruit(int[] fruits) {
        int maxCount = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;

        for(; right < fruits.length; right++){
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);

            while(map.size() > 2){
                int temp = map.get(fruits[left]);
                if(temp == 1){
                    map.remove(fruits[left]);
                }else{
                    temp--;
                    map.put(fruits[left], temp);
                }
                left++;
            }
            int count = right - left + 1;
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }
}