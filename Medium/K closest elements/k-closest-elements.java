//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            inputLine = br.readLine().trim().split(" ");
            int k = Integer.parseInt(inputLine[0]);
            int x = Integer.parseInt(inputLine[1]);

            int[] ans = new Solution().printKClosest(arr, n, k, x);
            for (int xx : ans) {
                System.out.print(xx + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
      int[] printKClosest(int[] arr, int n, int k, int x) {
        // code here
        int vec[] = new int[k];
        int low=0,high=n-1,mid=0,mn=Integer.MAX_VALUE,ans=-1;
        while(low<=high){
            mid=(low+high)/2;
            int diff=Math.abs(arr[mid]-x);
            if(diff<=mn){
                if(ans==-1)ans=mid;
                else{
                    if(diff==mn && arr[ans]<arr[mid]){
                        ans=mid;
                    }
                    if(diff<mn)ans=mid;
                }
                mn=diff;
            }
            if(arr[mid]<x)low=mid+1;
            else high=mid-1;
        }
        int total=0,i=ans-1,j=ans+1;
        if(arr[ans]!=x){
            vec[total]=arr[ans];
            total++;
        }
        while(total<k){
            if(i>=0 && j<n){
                if(Math.abs(arr[i]-x)<Math.abs(arr[j]-x))vec[total]=arr[i--];
                else vec[total]=arr[j++];
            }
            else if(i>=0)vec[total]=arr[i--];
            else vec[total]=arr[j++];
            total++;
        }
        return vec;
    }
}
