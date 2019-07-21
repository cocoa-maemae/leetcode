import json
import collections


class Solution:
    def numEquivDominoPairs(self, dominoes):
        return sum(v * (v - 1) / 2 for v in collections.Counter(tuple(sorted(x)) for x in dominoes).values())

def stringToInt2dArray(input):
    return json.loads(input)

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
            line = next(lines)
            dominoes = stringToInt2dArray(line)
            ret = Solution().numEquivDominoPairs(dominoes)
            out = intToString(ret)
            print(out)
            break
        except StopIteration:
            break

if __name__ == '__main__':
    main()
