package leetcode.editor.cn;


import java.util.*;

public class Twitter {

    private static int timestamp = 0;

    private HashMap<Integer,User> userMap = new HashMap<>();


    //user 发表一条tweet动态
    public  void postTweet(int userId,int tweetId){
        if(!userMap.containsKey(userId)){
            userMap.put(userId,new User(userId));
        }
        User user = userMap.get(userId);
        user.follow(tweetId);
    }

    public List<Integer> getNewsFeed(int userId){
        List<Integer> res = new ArrayList<>();
        if(!userMap.containsKey(userId)){
            return res;
        }
        Set<Integer> followed = userMap.get(userId).followed;

        PriorityQueue<Tweet> queue = new PriorityQueue<>(followed.size(),(a, b)->(b.time-a.time));

        for (int id: followed){
            Tweet head = userMap.get(id).head;
            if(head == null){
                continue;
            }
            queue.add(head);
        }

        while (!queue.isEmpty()){
            if(res.size() == 10){
                break;
            }
            Tweet poll = queue.poll();
            res.add(poll.id);
            if(poll.next != null){
                queue.add(poll.next);
            }
        }
        return res;
    }

    public void follow(int followerId,int followeeId){
        if(!userMap.containsKey(followerId)){
            User user = new User(followerId);
            userMap.put(followerId,user);
        }
        if(!userMap.containsKey(followeeId)){
            User user = new User(followeeId);
            userMap.put(followeeId,user);
        }
        userMap.get(followerId).follow(followeeId);
    }

    public void unfollow(int followerId,int followeeId){
        if(userMap.containsKey(followerId)){
            User user = userMap.get(followerId);
            user.unfollow(followeeId);
        }
    }


    private static class Tweet{
        private int id;
        private int time;
        private Tweet next;

        public Tweet(int id,int time){
            this.id = id;
            this.time = time;
            this.next = null;
        }
    }
    private static class User{
        private int id;
        private Set<Integer> followed;
        //用户发表的推文链表头节点
        public Tweet head;

        public User(int userId){
            followed = new HashSet<>();
            this.id = userId;
            this.head = null;
            follow(userId);
        }

        public void follow(int userId){
            followed.add(userId);
        }

        public void unfollow(int userId){
            if(this.id != userId){
                followed.remove(userId);
            }
        }

        public void post(int tweetId){
            Tweet tweet = new Tweet(tweetId,timestamp);
            timestamp++;
            tweet.next = head;
            head = tweet;
        }
    }


}
