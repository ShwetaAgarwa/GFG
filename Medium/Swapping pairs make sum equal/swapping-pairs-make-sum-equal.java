//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {

    public long findSwapValues(long[] a, int n, long[] b, int m) {
        // Calculate the sum of both arrays
        long suma = 0, sumb = 0;
        for (int i = 0; i < n; i++) suma += a[i];
        for (int i = 0; i < m; i++) sumb += b[i];
        
        // If the difference of sums is not even, return -1
        if ((suma - sumb) % 2 != 0) return -1;
        
        long target = (suma - sumb) / 2;
        int i = 0, j = 0;
        
        // Sort both arrays
        Arrays.sort(a);
        Arrays.sort(b);
        
        // Use two pointers to find the target difference
        while (i < n && j < m) {
            long diff = a[i] - b[j];
            if (diff == target) return 1;
            else if (diff < target) i++;
            else j++;
        }
        return -1;
    }
}


//{ Driver Code Starts.

// Driver class
class Array {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while (testcases-- > 0) {
            String line = br.readLine();
            String[] q = line.trim().split("\\s+");
            int n = Integer.parseInt(q[0]);
            int m = Integer.parseInt(q[1]);
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            long a[] = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(a1[i]);
            }
            String line2 = br.readLine();
            String[] a2 = line2.trim().split("\\s+");
            long b[] = new long[m];
            for (int i = 0; i < m; i++) {
                b[i] = Long.parseLong(a2[i]);
            }
            Solution ob = new Solution();
            long ans = ob.findSwapValues(a, n, b, m);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends