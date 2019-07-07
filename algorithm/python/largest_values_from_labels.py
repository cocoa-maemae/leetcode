import json
import collections

class Solution(object):
    def largestValsFromLabels(self, values, labels, num_wanted, use_limit):
        counts = collections.defaultdict(int)
        vl = sorted(zip(values, labels))
        ans = 0
        while num_wanted and vl:
            val, lab = vl.pop()
            if counts[lab] < use_limit:
                ans += val
                counts[lab] += 1
                num_wanted -= 1
        return ans

def stringToIntegerList(input):
    return json.loads(input)

def stringToInt(input):
    return int(input)

def intToString(input):
    if input is None:
        input = 0
    return str(input)

def main():
    import sys

    def readlines():
        for line in sys.stdin:
            yield line.strip("\n")

    lines = readlines()
    while True:
        try:
            line = lines.__next__()
            values = stringToIntegerList(line)
            line = lines.__next__()
            labels = stringToIntegerList(line)
            line = lines.__next__()
            num_wanted = stringToInt(line)
            line = lines.__next__()
            use_limit = stringToInt(line)
            ret = Solution().largestValsFromLabels(
                values, labels, num_wanted, use_limit
            )
            out = intToString(ret)
            print(out)
            break
        except StopIteration:
            break


if __name__ == "__main__":
    main()
