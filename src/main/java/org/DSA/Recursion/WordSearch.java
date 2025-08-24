package org.DSA.Recursion;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        int n = board.length, m = board[0].length, index = 0;

        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (check(board, i, j, word, m, n, visited, index))
                    return true;
            }
        }

        return false;
    }

    private boolean check(char[][] board, int i, int j, String word, int m, int n, boolean[][] visited, int index) {
        if (i < 0 || i >= n || j < 0 || j >= m)
            return false;

        if (i >= 0 && i < n && j >= 0 && j < m && (visited[i][j] || board[i][j] != word.charAt(index)))
            return false;

        if (i >= 0 && i < n && j >= 0 && j < m && !visited[i][j]) {
            if (board[i][j] == word.charAt(index)) {
                if (index == word.length() - 1)
                    return true;

                visited[i][j] = true;
                index = index + 1;
            }
        }

        boolean flag = false;

        flag = check(board, i - 1, j, word, m, n, visited, index) || check(board, i + 1, j, word, m, n, visited, index)
                || check(board, i, j - 1, word, m, n, visited, index)
                || check(board, i, j + 1, word, m, n, visited, index);

        visited[i][j] = false;

        return flag;
    }
}

class WordSearchMain{
    public static void main(String[] args) {
        char[][] borad = {{'A','B','C','E'}, {'S','F','C','S'},{'A','D','E','E'}};
        String word1 = "ABCCED", word2 = "SEE";

        System.out.println(new WordSearch().exist(borad,word1));
        System.out.println(new WordSearch().exist(borad,word2));
    }
}
