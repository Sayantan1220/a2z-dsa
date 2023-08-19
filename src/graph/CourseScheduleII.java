/*
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first
if you want to take course ai.
For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return the ordering of courses you should take to finish all courses. If there are many valid answers,
return any of them. If it is impossible to finish all courses, return an empty array.
https://leetcode.com/problems/course-schedule-ii/description/

Approach :
The code declares a public class called Solution that implements a method called findOrder with two parameters:
an integer numCourses and a 2D integer array prerequisites.
The code declares a list called ans as a public class variable. This list will store the order of courses to be taken.
The code declares a boolean flag called flag as a public class variable and initializes it to true.
However, the flag is not used anywhere in the code.
The code creates a hash set called s to keep track of visited courses.
This hash set will be used to prevent revisiting courses that have already been processed.
The code creates a hash map called hs to store the prerequisites for each course.
The prerequisites are given in the prerequisites array as a list of pairs (c, prereqCourse),
where c is the course and prereqCourse is its prerequisite. If a course has no prerequisites,
it will not be added to this hash map.
The code loops through all the courses from 0 to numCourses - 1. For each course,
it checks if it has been visited before by checking if it is in the hash set s.
If the course has not been visited, the code calls the dfs method to perform depth-first search traversal.
The dfs method takes four parameters: a hash set s to keep track of visited courses,
an integer i representing the current course being processed, a hash map adj representing
the adjacency list of the graph (i.e., the list of courses and their prerequisites),
and a hash set curr to keep track of the current path being traversed.
The dfs method first checks if the current course has been visited before by checking
if it is in the hash set s. If it has been visited, it returns true.
This check ensures that the algorithm does not revisit courses that have already been processed.
If the course does not have any prerequisites (i.e., it is not in the hash map adj),
the dfs method adds it to the answer list ans, marks it as visited in the hash set s, and returns true.
This check ensures that courses without prerequisites are processed first.
If the course has prerequisites, the dfs method adds the course to the hash set curr
to keep track of the current path being traversed.
The dfs method loops through all the prerequisites of the current course and checks if any of
them have already been visited (i.e., are in the hash set curr). If any of the prerequisites have already been visited,
it returns false, indicating an invalid order of courses. This check ensures that the
algorithm does not form a cycle in the graph.
If none of the prerequisites have been visited, the dfs method calls itself recursively
with each prerequisite as input. If any of these recursive calls return false, the method also returns false.
If all the prerequisites have been visited, the dfs method removes the current course from the curr hash set,
adds it to the answer list ans, marks it as visited in the hash set s, and returns true.
After all the courses have been visited, the findOrder method creates an integer array result of size numCourses and
copies the order of courses from the ans list to the result array.
Finally, the findOrder method returns the result array as an 'int[]' array by coverting ArrayList into int[].

TC : O(N^2)
SC : O(N^2)
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
