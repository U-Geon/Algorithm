class Solution {
    
    // 오른쪽, 아래쪽으로만 이동 가능
    // working backward
    // 도착지 왼쪽, 위 + 1
    public int solution(int m, int n, int[][] puddles) {
        int[][] map = new int[n+1][m+1];
        boolean[][] water = new boolean[n+1][m+1];
        
        for(int[] puddle : puddles) {
            water[puddle[1]][puddle[0]] = true;
        }

        map[1][1] = 1;
         
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(water[i][j] || (i == 1 && j == 1)) continue;
                map[i][j] = (map[i-1][j] + map[i][j-1]) % 1000000007;
            }
        }

        return map[n][m];
    }
}