class Twitter {

    // userID → set of users they follow
    HashMap<Integer, HashSet<Integer>> userToFollowings;

    // userID → list of [tweetId, timestamp]
    HashMap<Integer, ArrayList<int[]>> userToPosts;

    int count;

    public Twitter() {
        userToFollowings = new HashMap<>();
        userToPosts = new HashMap<>();
        count = 0;
    }

    public void postTweet(int userId, int tweetId) {
        if (!userToPosts.containsKey(userId)) {
            userToPosts.put(userId, new ArrayList<>());
        }

        userToPosts.get(userId).add(new int[]{tweetId, count});
        count++;
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> ans = new ArrayList<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a[1],b[1]));

        HashSet<Integer> followings = new HashSet<>(userToFollowings.getOrDefault(userId, new HashSet<>()));

        // user own tweets should also appear
        followings.add(userId);

        for(int fUserId : followings){
            if (!userToPosts.containsKey(fUserId)) {
                continue;
            }

            ArrayList<int[]> tweetIdAndCount = userToPosts.get(fUserId);
            for(int i = 0; i < tweetIdAndCount.size(); i++){
                int[] post = tweetIdAndCount.get(i);
                if(minHeap.size() < 10){
                    minHeap.offer(post);
                }else if(post[1] > minHeap.peek()[1]){
                    minHeap.poll();
                    minHeap.offer(post);
                }
            }
        }
        //now we have final min heap with all the tweets in reverse order
        while(!minHeap.isEmpty()){
            ans.add(minHeap.poll()[0]);
        }
        //reverse and return
        Collections.reverse(ans);
        return ans;
    }

    public void follow(int followerId, int followeeId) {
        if (!userToFollowings.containsKey(followerId)) {
            userToFollowings.put(followerId, new HashSet<>());
        }

        userToFollowings.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (userToFollowings.containsKey(followerId)) {
            userToFollowings.get(followerId).remove(followeeId);
        }
    }
}