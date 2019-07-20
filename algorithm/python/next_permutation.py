import json

class Solution(object):
    def nextPermutation(self, nums):
        def swap(a, i,j):
            t = a[i]
            a[i] = a[j]
            a[j] = t

        #Find the largest index k such that a[k] < a[k + 1]. If no such index exists, the permutation is the last permutation.
        max_k = -1
        for k in range(len(nums) - 1):
            if nums[k] < nums[k + 1]:
                max_k = k
        # If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
        if max_k < 0:
            nums.sort()

        #Find the largest index l greater than k such that a[k] < a[l].
        max_l = -1
        for l in range(max_k + 1, len(nums)):
            if nums[max_k] < nums[l]:
                max_l = l

        #Swap the value of a[k] with that of a[l].
        swap(nums, max_k, max_l)
                        
        #Reverse the sequence from a[k + 1] up to and including the final element a[n].
        nums[max_k + 1:] = nums[max_k + 1:][::-1]

def stringToIntegerList(input):
    return json.loads(input)

def integerListToString(nums, len_of_list=None):
    if not len_of_list:
        len_of_list = len(nums)
    return json.dumps(nums[:len_of_list])

def main():
    import sys
    import io
    def readlines():
        for line in io.TextIOWrapper(sys.stdin.buffer, encoding='utf-8'):
            yield line.strip('\n')
    lines = readlines()
    while True:
        try:
            line = next(lines)
            nums = stringToIntegerList(line)
            ret = Solution().nextPermutation(nums)
            out = integerListToString(nums)
            if ret is not None:
                print("Do not return anything, modify nums in-place instead.")
            else:
                print(out)
            break
        except StopIteration:
            break

if __name__ == '__main__':
    main()
