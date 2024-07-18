class Solution {
public:
    int majorityElement(vector<int>& nums) {
        int i = 0;
        int n = floor(nums.size()/2);
        sort(nums.begin(), nums.end());
        return nums[n];
    }
};
