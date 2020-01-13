package com.algorithms.recruitment.grakn.task2;

import java.util.Scanner;


public class CountriesMap {

    private int height = -1;
    private int width = -1;
    private int startRow = -1;
    private int startCol = -1;
    private int distRow = -1;
    private int distCol = -1;

    public CountriesMap(int height, int width, int startRow, int startCol, int distRow, int distCol) {
        this.height = height;
        this.width = width;
        this.startRow = startRow;
        this.startCol = startCol;
        this.distRow = distRow;
        this.distCol = distCol;
    }

    public static void main(String[] args) throws Exception
    {
        Scanner scanner = new Scanner(System.in);
        int width = scanner.nextInt();
        int height = scanner.nextInt();
        int startRow = -1;
        int startCol = -1;
        int distRow = -1;
        int distCol = -1;

        scanner.nextLine();

        int[][] maze = new int[height][width];
        for (int row=0 ; row<height; row++) {
            String lineOfValues = scanner.nextLine();
            for (int col=0;col<width; col++){
                maze[row][col] = lineOfValues.charAt(col);
                if ((char)maze[row][col] == 'S'){
                    startRow = row;
                    startCol = col;
                } else if ((char)maze[row][col] == 'G'){
                    distRow = row;
                    distCol = col;
                }
            }
        }

        int distance = new CountriesMap(height, width, startRow, startCol, distRow, distCol).findShortestPath(maze);

        System.out.println( distance);

    }

    public int findShortestPath(int maze[][])
    {
        int[][] visitted = new int[height][width];
        return findShortestPath(maze, visitted, startRow, startCol, distRow, distCol, Integer.MAX_VALUE, 0);
    }

    // Check if it is possible to go to (x, y) from current position. The
    // function returns false if the cell has value 0 or already visited
    private boolean isSafe(int maze[][], int visited[][], int x, int y)
    {
        return !(maze[x][y] == 1 || visited[x][y] != 0);
    }

    // if not a valid position, return false
    private boolean isValid(int height, int width, int x, int y)
    {
        return (x < height && y < width && x >= 0 && y >= 0);
    }

    // Find Shortest Possible Route in a Matrix mat from source cell (0, 0)
    // to destination cell (x, y)

    // 'min_dist' stores length of longest path from source to destination
    // found so far and 'dist' maintains length of path from source cell to
    // the current cell (i, j)

    private int findShortestPath(int maze[][], int visited[][],
                                       int i, int j, int x, int y, int min_dist, int dist)
    {
        // if destination is found, update min_dist
        if (i == x && j == y)
        {
            return Math.min(dist, min_dist);
        }

        // set (i, j) cell as visited
        visited[i][j] = 1;

        // go to bottom cell
        if (isValid(height, width, i + 1, j) && isSafe(maze, visited, i + 1, j)) {
            min_dist = findShortestPath(maze, visited, i + 1, j, x, y,
                min_dist, dist + 1);
        }

        // go to right cell
        if (isValid(height, width,i, j + 1) && isSafe(maze, visited, i, j + 1)) {
            min_dist = findShortestPath(maze, visited, i, j + 1, x, y,
                min_dist, dist + 1);
        }

        // go to top cell
        if (isValid(height, width,i - 1, j) && isSafe(maze, visited, i - 1, j)) {
            min_dist = findShortestPath(maze, visited, i - 1, j, x, y,
                min_dist, dist + 1);
        }

        // go to left cell
        if (isValid(height, width,i, j - 1) && isSafe(maze, visited, i, j - 1)) {
            min_dist = findShortestPath(maze, visited, i, j - 1, x, y,
                min_dist, dist + 1);
        }

        // Backtrack - Remove (i, j) from visited matrix
        visited[i][j] = 0;

        return min_dist;
    }

}
