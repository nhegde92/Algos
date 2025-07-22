/*Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.



Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]


Constraints:

1 <= nums.length <= 105
-104 <= nums[i] <= 104
k is in the range [1, the number of unique elements in the array].
It is guaranteed that the answer is unique.


Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.

 */
package priorityqueues;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TokKFrequentlyUsedElements {

    public static int[] getTokKElements(int[] nums, int k) {
        int[] res = new int[k];
        if (nums.length == k || nums.length == 0)
            return res;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));
        for (Integer key : map.keySet()) {
            pq.add(key);
            if (pq.size() > k)
                pq.poll();
        }
        for (int i = k-1; i >= 0; i--)
            res[i] = pq.poll();
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int[] nums2 = {1,1,1,2,2,3,3,3,3,3,4,4,4,4,4,4};
        int k = 2;
        int res[] = getTokKElements(nums, k);
        for (int re : res) {
            System.out.print(re + " ");
        }
        System.out.println();
        int[] res2 = getTokKElements(nums2, k);
        for (int j : res2) {
            System.out.print(j + " ");
        }

    }

}

/*
O(NLogK) Time complexity.
O(N+K) space complexity
Idea is to make hashMap of digits and their frequency. Create a min heap of size k.
Remove the elements with the lowest frequency when the size exceeds k. For loop will
run n times. Insertion to the heap will add logk complexity so bringing the total to
O(NLogK) Time complexity.

 */
