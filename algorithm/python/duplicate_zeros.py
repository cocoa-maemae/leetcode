import json


class Solution:
    def duplicateZeros(self, A):
        """
        :type arr: List[int]
        :rtype: None Do not return anything, modify arr in-place instead.
        """
        A[:] = [x for a in A for x in ([a] if a else [0, 0])][:len(A)]

def stringToIntegerList(input):
    return json.loads(input)

def integerListToString(nums, len_of_list=None):
    if not len_of_list:
        len_of_list = len(nums)
    return json.dumps(nums[:len_of_list])

def main():
    import sys
    def readlines():
        for line in sys.stdin:
            yield line.strip('\n')
    lines = readlines()
    while True:
        try:
            line = lines.__next__()
            arr = stringToIntegerList(line)
            ret = Solution().duplicateZeros(arr)
            out = integerListToString(arr)
            if ret is not None:
                print("Do not return anything, modify arr in-place instead.")
            else:
                print(out)
            break
        except StopIteration:
            break

if __name__ == '__main__':
    main()
