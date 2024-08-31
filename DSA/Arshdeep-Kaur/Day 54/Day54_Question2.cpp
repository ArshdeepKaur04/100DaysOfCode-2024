class Solution {
public:
    int findMin(vector<int>& nums) {
        int low = 0, high = nums.size()-1;
        while(low < high) {
            int mid = (low + high) / 2;
            if(nums[mid] > nums[high]) {
                low = mid + 1;
            }
            else if(nums[low] < nums[mid]) {
                high = mid - 1;
            }
            else {
                high--;
            }
        }
        return nums[low];
    }
};