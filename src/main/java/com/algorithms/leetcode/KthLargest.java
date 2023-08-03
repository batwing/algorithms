package com.algorithms.leetcode;

/*
Design a class to find the kth largest element in a stream. Note that it is the kth largest element in the sorted order, not the kth distinct element.

Implement KthLargest class:

    KthLargest(int k, int[] nums) Initializes the object with the integer k and the stream of integers nums.
    int add(int val) Appends the integer val to the stream and returns the element representing the kth largest element in the stream.



Example 1:

Input
["KthLargest", "add", "add", "add", "add", "add"]
[[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
Output
[null, 4, 5, 5, 8, 8]

Explanation
KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
kthLargest.add(3);   // return 4
kthLargest.add(5);   // return 5
kthLargest.add(10);  // return 5
kthLargest.add(9);   // return 8
kthLargest.add(4);   // return 8



Constraints:

    1 <= k <= 104
    0 <= nums.length <= 104
    -104 <= nums[i] <= 104
    -104 <= val <= 104
    At most 104 calls will be made to add.
    It is guaranteed that there will be at least k elements in the array when you search for the kth element.
 */

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class KthLargest {

    private int k;

    private PriorityQueue<Integer> heap = new PriorityQueue<Integer>(new AscendingIntComparator());
    //private PriorityQueue<Integer> buffer = new PriorityQueue<Integer>(new AscendingIntComparator());
    private List<Integer> tempStack = new LinkedList<>();

    private static class AscendingIntComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2-o1;
        }
    }

    public KthLargest(int k, int[] nums) {
        this.k=k;
        for (int x: nums) {
            heap.add(x);
        }
        //buffer.addAll(heap);
    }

    public int add(int val) {

        heap.add(val);
        if (k < 1 || heap.size() < k) {
            throw new IllegalArgumentException(String.format("Warning: there are less elements in the queue then K=%d or K is less then 0",k));
        }

        //buffer.clear();
        //buffer.addAll(heap);
        int max3Rd = 0;

        for (int i=0; i<k; i++) {
            max3Rd = heap.poll();
            tempStack.add(max3Rd);
            System.out.println(String.format("max3Rd = %d",max3Rd));
        }

        //bufferTempStack.stream().forEach(el -> buffer.add(el));
        heap.addAll(tempStack);
        tempStack.clear();

        return max3Rd;
    }

    public int poll3rdLargest(int val) {
        Integer element = 0;
        heap.add(val);
        for(int i=0; i<2; i++) {
            element = heap.remove();
            System.out.println("Removed from the heap: " + element);
        }
        return heap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */