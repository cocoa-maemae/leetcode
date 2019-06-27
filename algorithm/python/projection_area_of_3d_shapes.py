import json


class Solution(object):
    def projectionArea(self, grid):
        return (
            sum(map(max, grid))
            + sum(map(max, zip(*grid)))
            + sum(v > 0 for row in grid for v in row)
        )


def stringToInt2dArray(input):
    return json.loads(input)


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
            grid = stringToInt2dArray(line)
            ret = Solution().projectionArea(grid)
            out = intToString(ret)
            print(out)
            break
        except StopIteration:
            break


if __name__ == "__main__":
    main()
