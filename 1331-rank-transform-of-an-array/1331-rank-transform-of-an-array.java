class Solution {
    public int[] arrayRankTransform(int[] arr) {
        //making a copy of given array to sort it
        int[] copied = new int[arr.length];
        for(int i = 0; i < arr.length; i++){
            copied[i] = arr[i];
        }

        //now sorting this copied array
        Arrays.sort(copied);

        //now run a loop again and start assigning rank to every one from 1 to n 
        //note if element is same as prev then rank same
        //and same time start pushing it to the hashmap with there corresponding rank
        HashMap<Integer,Integer> map = new HashMap<>();
        int rank = 1;

        for(int i = 0; i < copied.length; i++){
            int curr = copied[i];
            if(!map.containsKey(curr)){
                map.put(curr, rank);
                rank++;
            }
        }
        //now we have rank of element inside the map
        //use map and initialize it
        for(int i = 0; i < arr.length; i++){
            copied[i] = map.get(arr[i]);
        }
        return copied;
    }
}