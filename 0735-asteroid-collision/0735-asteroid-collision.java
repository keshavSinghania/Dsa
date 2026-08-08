class Solution {
    public int[] asteroidCollision(int[] asteroids) {

        ArrayList<Integer> list = new ArrayList<>();

        // Convert array to list
        for (int num : asteroids) {
            list.add(num);
        }

        while (true) {
            boolean isCollid = false;
            for (int i = 0; i < list.size() - 1; i++) {

                int curr = list.get(i);
                int next = list.get(i + 1);

                if (curr > 0 && next < 0) {
                    // Collision
                    if (curr == -next) {
                        // Both explode
                        list.remove(i + 1);
                        list.remove(i);
                    } else if (curr > -next) {
                        // next explodes
                        list.remove(i + 1);
                    } else {
                        // curr explodes
                        list.remove(i);
                    }
                    isCollid = true;
                    break;
                }
            }
            if (!isCollid)
                break;
        }

        // Convert list to array manually
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}