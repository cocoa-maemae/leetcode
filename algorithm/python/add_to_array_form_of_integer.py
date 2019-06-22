import json
from pprint import pprint

class Solution(object):
    def addToArrayForm(self, A, K):
        """
        :type A: List[int]
        :type K: int
        :rtype: List[int]
        """
        for i in range(len(A))[::-1]:
            A[i], K = (A[i] + K) % 10, (A[i] + K) / 10
        pprint(A)
        return [int(i) for i in str(K)] + A if K else A

def stringToIntegerList(input):
    return json.loads(input)

def stringToInt(input):
    return int(input)

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
            line = lines.next()
            A = stringToIntegerList(line)
            line = lines.next()
            K = stringToInt(line)
            ret = Solution().addToArrayForm(A, K)
            out = integerListToString(ret)
            print out
            break
        except StopIteration:
            break

if __name__ == '__main__':
    main()
