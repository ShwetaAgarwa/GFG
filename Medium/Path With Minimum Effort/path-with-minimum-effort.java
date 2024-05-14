//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntMatrix {
    public static int[][] input(BufferedReader br, int n, int m) throws IOException {
        int[][] mat = new int[n][];

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for (int j = 0; j < s.length; j++) mat[i][j] = Integer.parseInt(s[j]);
        }

        return mat;
    }

    public static void print(int[][] m) {
        for (var a : m) {
            for (int e : a) System.out.print(e + " ");
            System.out.println();
        }
    }

    public static void print(ArrayList<ArrayList<Integer>> m) {
        for (var a : m) {
            for (int e : a) System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int rows;
            rows = Integer.parseInt(br.readLine());

            int columns;
            columns = Integer.parseInt(br.readLine());

            int[][] heights = IntMatrix.input(br, rows, columns);

            Solution obj = new Solution();
            int res = obj.MinimumEffort(rows, columns, heights);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends




class Solution {
     static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, 1, 0, -1};
    
    
    public static int MinimumEffort(int rows, int columns, int[][] heights) {
        // code here
       PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]); 
        boolean[][] visited = new boolean[rows][columns];
        
          pq.offer(new int[]{0, 0, 0}); 
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int x = current[0];
            int y = current[1];
            int effort = current[2];
            
             if (x == rows - 1 && y == columns - 1) {
                return effort;
            }
              visited[x][y] = true;
           for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];   
                if (nx >= 0 && nx < rows && ny >= 0 && ny < columns && !visited[nx][ny]) {
                      int diff = Math.abs(heights[x][y] - heights[nx][ny]);
                       int maxDiff = Math.max(diff, effort);
                       
                         pq.offer(new int[]{nx, ny, maxDiff});
                }
           }
        }
          return -1; 
    }
}