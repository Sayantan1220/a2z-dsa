/*
Given an m x n grid of characters board and a string word, return true if word exists in the grid.
The word can be constructed from letters of sequentially adjacent cells,
where adjacent cells are horizontally or vertically neighboring.
The same letter cell may not be used more than once.
https://leetcode.com/problems/word-search/description/

Approach:
The approach used in the given solution is Depth First Search (DFS) algorithm.
The solution iterates over each cell of the input matrix and calls the dfs function
to check if the given word can be formed starting from that cell.
The dfs function searches for the next character of the word in the neighbouring cells (up, down, left, right) and
marks the current cell as visited by changing the value to '#' to avoid revisiting the same cell.
If the entire word is found in the matrix, the function returns true;
otherwise, it backtracks by restoring the value of the current cell and returns false.

TC: O(mn4^k), where m and n are the number of rows and columns in the input matrix,
and k is the length of the given word. This is because the solution iterates over each cell of the matrix,
and for each cell, it makes at most four recursive calls, one for each neighbouring cell.
The worst-case time complexity occurs when the word is not found, and the DFS algorithm traverses all possible paths,
which can be up to 4^k paths.
SC: O(k), where k is the length of the given word.
This is because the solution uses the call stack to store the state of the recursive calls,
and the maximum depth of the call stack is k.
 */


package Recursion;

public class WordSearch {

    public static boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean result = false;
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(dfs(board,word,i,j,0))
                {
                    result = true;
                }
            }
        }
        return result;
    }
    public static boolean dfs(char[][] board, String word, int i, int j, int k)
    {
        int m = board.length;
        int n = board[0].length;
        if(i<0 || j<0 || i>=m || j>=n)
        {
            return false;
        }
        if(board[i][j] == word.charAt(k))
        {
            char temp = board[i][j];
            board[i][j]='#';
            if(k==word.length()-1)
            {
                return true;
            }
            else if(dfs(board, word, i-1, j, k+1) ||dfs(board, word, i+1, j, k+1) ||dfs(board, word, i, j-1, k+1) ||dfs(board, word, i, j+1, k+1))
            {
                return true;
            }
            board[i][j]=temp;
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        boolean result = exist(board, word);
        System.out.println(result);
    }
}
