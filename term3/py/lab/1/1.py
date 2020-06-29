def twoSum(nums, target):
    l=len(nums)
    for i in range(0,l):
        for j in range(i+1,l):
            if (nums[i] + nums[j]) == target:
                return [i,j]


print(twoSum([2, 7, 11, 15],9))