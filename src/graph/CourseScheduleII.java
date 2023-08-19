/*
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first
if you want to take course ai.
For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return the ordering of courses you should take to finish all courses. If there are many valid answers,
return any of them. If it is impossible to finish all courses, return an empty array.
https://leetcode.com/problems/course-schedule-ii/description/
 */

package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class CourseScheduleII {
    public List<Integer> ans = new ArrayList<>();
    boolean flag = true;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashSet<Integer> s = new HashSet<>();
        HashMap<Integer, List<Integer>> hs = new HashMap<>();
        for (int[] pre : prerequisites) {
            int c = pre[0];
            int prereqCourse = pre[1];
            hs.putIfAbsent(c, new ArrayList<>());
            hs.get(c).add(prereqCourse);
        }
        for (int i = 0; i < numCourses; i++) {
            if (!s.contains(i) && (!dfs(s, i, hs, new HashSet<>()))) {
                    return new int[]{};

            }
        }
        int[] result = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            result[i] = ans.get(i);
        }
        return result;
    }

    public boolean dfs(HashSet<Integer> s, int i, HashMap<Integer, List<Integer>> adj, HashSet<Integer> curr) {
        if (s.contains(i)) {
            return true;
        }
        if (!adj.containsKey(i)) {
            ans.add(i);
            s.add(i);
            return true;
        }
        curr.add(i);
        for (int pre : adj.get(i)) {
            if (curr.contains(pre) || !dfs(s, pre, adj, curr)) {
                return false;
            }
        }
        curr.remove(i);
        ans.add(i);
        s.add(i);
        return true;
    }
}
