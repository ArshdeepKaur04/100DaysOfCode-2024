#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    int findAnswer(vector<int> &nums, int val) {
        int sum = 0;
        for(int i=0; i<nums.size(); i++) {
            sum += ceil((double)(nums[i]) / (double)(val));
        }
        return sum;
    }

    int smallestDivisor(vector<int>& nums, int threshold) {
        int low = 1, high = *max_element(nums.begin(), nums.end());

        while(low <= high) {
            int mid = (low + high) / 2;
            int ans = findAnswer(nums, mid);
            if (ans <= threshold) {
                high = mid - 1;
            }
            else {
                low = mid+1;
            }
        }

        return low;
    }
};
