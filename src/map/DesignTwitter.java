package map;

import stack_queue.QueueUsingStacks;

import java.util.*;

public class DesignTwitter {
    private final Map<Integer, User> userMap;

    public DesignTwitter() {
        this.userMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        this.userMap.putIfAbsent(userId, new User(userId));
        this.userMap.get(userId).postTweet(new Tweet(tweetId));
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<>();

        this.userMap.putIfAbsent(userId, new User(userId));

        Set<Integer> following = this.userMap.get(userId).following;

        Tweet[] tweets = new Tweet[following.size()];

        int i = 0;

        for(int id : following)
            if(userMap.get(id).tweets.head() != null)
                tweets[i++] = userMap.get(id).tweets.head();

        int n = 0;
        Tweet added = null;

        do {
            added = null;
            int index = 0;

            for(int j = 0; j < tweets.length; ++j) {
                if(added == null && tweets[j] != null)
                    added = tweets[j];

                if(added != null && tweets[j] != null && added.time < tweets[j].time) {
                    added = tweets[j];
                    index = j;
                }
            }

            if(added != null) {
                result.add(added.id);
                tweets[index] = added.next;
            }

            n++;
        } while(added != null && n < 10);

        return result;
    }

    public void follow(int followerId, int followeeId) {
        this.userMap.putIfAbsent(followerId, new User(followerId));
        this.userMap.putIfAbsent(followeeId, new User(followeeId));

        this.userMap.get(followerId).follow(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        this.userMap.putIfAbsent(followerId, new User(followerId));
        this.userMap.putIfAbsent(followeeId, new User(followeeId));

        this.userMap.get(followerId).unfollow(followeeId);
    }

    private class User {
        public final Set<Integer> following;
        public final TweetList tweets;

        private int n;

        public User(final int id) {
            this.following = new HashSet<>();
            this.tweets = new TweetList();
            this.n = 0;
            this.follow(id);
        }

        public void postTweet(final Tweet tweet) {
            this.tweets.add(tweet);
        }

        public void follow(final int id) {
            this.following.add(id);
        }

        public void unfollow(final int id) {
            this.following.remove(id);
        }
    }

    private class Tweet {
        private static int timeStamp = 0;
        public final int id;
        public final int time;
        public Tweet next;
        public Tweet prev;

        public Tweet(final int id) {
            this.id = id;
            this.prev = null;
            this.next = null;
            time = timeStamp++;
        }
    }

    private class TweetList {
        private Tweet dummyHead;
        private Tweet tail;
        private int size;

        public TweetList() {
            this.size = 0;
            this.dummyHead = new Tweet(-1);
        }

        public void add(Tweet tweet) {
            if(this.size == 0) {
                this.dummyHead.next = tweet;
                tweet.prev = this.dummyHead;
                tail = tweet;
            } else {
                tweet.next = this.dummyHead.next;
                tweet.prev = this.dummyHead;
                this.dummyHead.next.prev = tweet;
                this.dummyHead.next = tweet;
            }

            this.size++;

            if(this.size > 10)
                this.remove();
        }

        public Tweet head() {
            return this.dummyHead.next;
        }

        private Tweet remove() {
            if(this.size == 0)
                return null;

            this.tail.prev.next = null;
            this.tail = this.tail.prev;

            this.size--;

            if(this.size == 0)
                this.tail = null;

            return this.tail;
        }
    }

    public static void main(String[] args) {
        DesignTwitter obj = new DesignTwitter();
        obj.postTweet(1, 5);
        System.out.println(obj.getNewsFeed(1));
    }
}
