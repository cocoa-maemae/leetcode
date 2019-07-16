import json


class Solution(object):
    def lengthOfLongestSubstring(self, s):
        dict = {}
        ans, d = 0, 0
        for i in range(len(s)):
            if s[i] in dict:
                d = max(d, dict[s[i]] + 1)
            dict[s[i]] = i
            ans = max(ans, i - d + 1)
        return ans

def stringToArray(input):
    return list(input)

def intToString(input):
    if input is None:
        input = 0
    return str(input)

def main():
    import sys
    import io
    def readlines():
        for line in io.TextIOWrapper(sys.stdin.buffer, encoding='utf-8'):
            yield line.strip('\n')

    lines = readlines()
    while True:
        try:
            line = lines.__next__()
            s = stringToArray(line)
            ret = Solution().lengthOfLongestSubstring(s)
            out = intToString(ret)
            print(out)
            break
        except StopIteration:
            break

if __name__ == '__main__':
    main()
