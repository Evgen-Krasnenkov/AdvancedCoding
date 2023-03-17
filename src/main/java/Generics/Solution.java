package Generics;

class Solution {
    public int[] searchRange(int[] nums, int target) {
        return new int[]{lowerBoundary(nums, target), upperBoundary(nums, target)};
    }

    private int upperBoundary(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if (target < nums[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left != 0 && target == nums[left] ? left : - 1;
    }

    private int lowerBoundary(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (target <= nums[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return target == nums[right] ? right : - 1;
    }
}