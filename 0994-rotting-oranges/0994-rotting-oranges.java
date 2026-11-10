class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;

        if(grid == null || m == 0){
            return 0;
        }
        if(m == 1 && n == 1 && grid[0][0] == 0){
            return 0;
        }
        if(m == 1 && n == 1 && grid[0][0] == 1){
            return -1;
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 2){
                    q.add(new int[]{i, j});
                }else if(grid[i][j] == 1){
                    fresh ++;
                }
            }
        }
        if(fresh == 0){
            return 0;
        }

        int minuts = -1;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while(!q.isEmpty() ){
            int currentSizeRotten = q.size();
            minuts++;

            for(int i = 0; i < currentSizeRotten; i++){
                int[] position = q.remove();
                int row = position[0];
                int col = position[1];

                for(int[] dir : directions){
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];
                    if(newRow < 0 || newCol < 0 ||  newRow > m - 1 || newCol > n - 1 || grid[newRow][newCol] != 1 ) {
                        continue;
                    }
                    grid[newRow][newCol] = 2;
                    fresh--;
                    q.add(new int[]{newRow, newCol});
                }
            }
        }
        if(fresh != 0){
            return -1;
        }
        return minuts;

    }
}