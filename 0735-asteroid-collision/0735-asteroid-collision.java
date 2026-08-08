class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();

        //covert into list
        ArrayList<Integer> list = new ArrayList<>();
        //Convert array to list
        for (int num : asteroids) {
            list.add(num);
        }
        for(int i = list.size() - 1; i >= 0; i--){
            int current = list.get(i);

            if(current < 0){
                st.push(current);
                list.remove(i);
                continue;
            }
            
            if(!st.isEmpty() && current > 0){
                while(!st.isEmpty() && current > -st.peek()){
                    st.pop();
                }
                if(!st.isEmpty() && current == -st.peek()){
                    st.pop();
                    list.remove(i);
                }else if(!st.isEmpty()){
                    //if stack has element (-ve won) hence destroy this +ve
                    list.remove(i);
                }else if(st.isEmpty()){
                    //if stack is empty +ve won therefore continue
                    continue;
                }
            }
        }

         // in their original left-to-right order
        ArrayList<Integer> negative = new ArrayList<>();

        while (!st.isEmpty()) {
            negative.add(st.pop());
        }

        // Put surviving negatives before surviving positives
        negative.addAll(list);
        list = negative;

        //we have final ans list
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}



// class Solution {
//     public int[] asteroidCollision(int[] asteroids) {

//         ArrayList<Integer> list = new ArrayList<>();

//         // Convert array to list
//         for (int num : asteroids) {
//             list.add(num);
//         }

//         while (true) {
//             boolean isCollid = false;
//             for (int i = 0; i < list.size() - 1; i++) {

//                 int curr = list.get(i);
//                 int next = list.get(i + 1);

//                 if (curr > 0 && next < 0) {
//                     // Collision
//                     if (curr == -next) {
//                         // Both explode
//                         list.remove(i + 1);
//                         list.remove(i);
//                     } else if (curr > -next) {
//                         // next explodes
//                         list.remove(i + 1);
//                     } else {
//                         // curr explodes
//                         list.remove(i);
//                     }
//                     isCollid = true;
//                     break;
//                 }
//             }
//             if (!isCollid)
//                 break;
//         }

//         // Convert list to array manually
//         int[] ans = new int[list.size()];
//         for (int i = 0; i < list.size(); i++) {
//             ans[i] = list.get(i);
//         }
//         return ans;
//     }
// }