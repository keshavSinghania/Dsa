class Solution {
    public int totalFruit(int[] fruits) {
        int typeOfFruits = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        int count = 0;
        int maxFruitCount = 0;
        int ptr1 = 0;
        for(int ptr2 = 0; ptr2 < fruits.length; ptr2++){
            //if we get new fruit , and we already having 2 different types of fruits in baskets
            while(typeOfFruits == 2 && !map.containsKey(fruits[ptr2])){
                //delete last element untill typeOfFruits becomes less than 2
                map.put(fruits[ptr1], map.get(fruits[ptr1]) - 1);
                if(map.get(fruits[ptr1]) == 0){
                    typeOfFruits--;
                    map.remove(fruits[ptr1]);
                }
                ptr1++;
                count--;
            }
            if(!map.containsKey(fruits[ptr2])){
                typeOfFruits++;
                map.put(fruits[ptr2], 1);
            }else{
                map.put(fruits[ptr2], map.get(fruits[ptr2]) + 1);
            }
            count++;
            maxFruitCount = Math.max(count, maxFruitCount);
        }
        return maxFruitCount;
    }
}