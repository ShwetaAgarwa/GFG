//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int[] a = new int[s.length];
            for (int i = 0; i < s.length; i++) a[i] = Integer.parseInt(s[i]);

            Solution obj = new Solution();
            int res = obj.pairWithMaxSum(a);
            System.out.println(res);
        }
    }
}

// } Driver Code Ends


class Solution {
    public int pairWithMaxSum(int[] arr) {
        int n = arr.length;
        if (n < 2) return -1;
        int[] nextSmaller = new int[n];
        int[] prevSmaller = new int[n];

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                nextSmaller[stack.pop()] = i;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            nextSmaller[stack.pop()] = n;
        }
        stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                prevSmaller[stack.pop()] = i;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            prevSmaller[stack.pop()] = -1;
        }

        int maxSum = -1;
        for (int i = 0; i < n; i++) {
            int left = prevSmaller[i] + 1; 
            int right = nextSmaller[i] - 1; 

            
            for (int j = left; j <= right; j++) {
                if (j != i) { 
                    int secondSmallest = arr[j];
                    
                    int currentSum = arr[i] + secondSmallest;
                    maxSum = Math.max(maxSum, currentSum);
                }
            }
        }

        return maxSum;
    }
}

