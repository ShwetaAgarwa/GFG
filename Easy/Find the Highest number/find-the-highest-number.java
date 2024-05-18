//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String s = br.readLine().trim();
            int n = Integer.parseInt(s);
            String S = br.readLine();
            String[] s1 = S.split(" ");
            List<Integer> a = new ArrayList<Integer>();
            for (int i = 0; i < n; i++) {
                a.add(Integer.parseInt(s1[i]));
            }
            Solution ob = new Solution();
            int ans = ob.findPeakElement(a);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
   public int findPeakElement(List<Integer> a) {
        // Code here
        int l=0,h=a.size()-1,mid=-1,n=a.size();
        boolean temp1=false,temp2=false,temp3=false;
        while(l<=h)
        {
            mid=(l+h)/2;
            temp1=mid!=n-1?a.get(mid)>a.get(mid+1):true;
            temp2=mid!=0?a.get(mid)>a.get(mid-1):true;
            temp3=mid!=0?a.get(mid)<a.get(mid-1):true;
            if(temp1 && temp2)break;
            else if(temp1 && temp3)h=mid-1;
            else l=mid+1;
        }
        return a.get(mid);
    }
}