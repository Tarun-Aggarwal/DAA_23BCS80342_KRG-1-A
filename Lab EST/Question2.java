import java.util.*;

public class Question1 {
    public static int subarrSumClosestK(int[] arr, int k) {
        int[] pre = new int[arr.length];
        pre[0] = arr[0];
        
        TreeSet<int[]> set = new TreeSet<>((a, b) -> {
            int cmp = Integer.compare(a[0], b[0]);
            if(cmp != 0) return cmp;
            else return Integer.compare(a[1], b[1]);
        });

        set.add(new int[]{0, -1});

        for(int i=1; i<arr.length; i++) {
            pre[i] = pre[i-1] + arr[i];
        }

        int ans = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++) {
            int target = pre[i]-k;
            int[] entry = set.ceiling(new int[]{target, Integer.MIN_VALUE});
            
            if(entry != null && pre[i]-entry[0] <= k) {
                ans = Math.max(ans, pre[i]-entry[0]);
            }
            
            set.add(new int[]{pre[i], i});
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {-5, 12, -7, 3, -4, 6, 1};
        int k = 2;
        System.out.println(subarrSumClosestK(arr, k));
    }
}
