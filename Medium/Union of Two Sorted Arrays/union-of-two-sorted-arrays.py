#User function Template for python3
class Solution:
    # Function to return a list containing the union of the two arrays.
    def findUnion(self, arr1, arr2, n, m):
        # Initialize an empty list to store the union.
        union = []
        
        # Initialize pointers for both arrays.
        i = 0
        j = 0
        
        # Traverse both arrays simultaneously.
        while i < n and j < m:
            # If the current elements are equal, add one of them to the union.
            if arr1[i] == arr2[j]:
                union.append(arr1[i])
                # Move both pointers to the next distinct elements.
                while i + 1 < n and arr1[i] == arr1[i + 1]:
                    i += 1
                while j + 1 < m and arr2[j] == arr2[j + 1]:
                    j += 1
                i += 1
                j += 1
            # If the element in arr1 is smaller, add it to the union.
            elif arr1[i] < arr2[j]:
                union.append(arr1[i])
                # Move the pointer to the next element in arr1.
                while i + 1 < n and arr1[i] == arr1[i + 1]:
                    i += 1
                i += 1
            # If the element in arr2 is smaller, add it to the union.
            else:
                union.append(arr2[j])
                # Move the pointer to the next element in arr2.
                while j + 1 < m and arr2[j] == arr2[j + 1]:
                    j += 1
                j += 1
        
        # Add remaining elements of arr1 to the union.
        while i < n:
            union.append(arr1[i])
            while i + 1 < n and arr1[i] == arr1[i + 1]:
                i += 1
            i += 1
        
        # Add remaining elements of arr2 to the union.
        while j < m:
            union.append(arr2[j])
            while j + 1 < m and arr2[j] == arr2[j + 1]:
                j += 1
            j += 1
        
        # Return the union list.
        return union

#{ 
 # Driver Code Starts
#Initial Template for Python 3

# Contributed by : Nagendra Jha
# Modified by : Sagar Gupta


if __name__ == '__main__':
    test_cases = int(input())
    for cases in range(test_cases) :
        n,m = map(int,input().strip().split())
        a = list(map(int,input().strip().split()))
        b = list(map(int,input().strip().split()))
        ob=Solution()
        li = ob.findUnion(a,b,n,m)
        for val in li:
            print(val, end = ' ')
        print()
# } Driver Code Ends