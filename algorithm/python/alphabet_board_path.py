class Solution:
    def alphabetBoardPath(self, target):
        """
        Time Complexity: O(N)
        Space Complexity: O(N)
        """
        m = {c: [i // 5, i % 5] for i, c in enumerate("abcdefghijklmnopqrstuvwxyz")}
        x0, y0 = 0, 0
        res = []
        for c in target:
            x, y = m[c]
            if y < y0:
                res.append("L" * (y0 - y))
            if x < x0:
                res.append("U" * (x0 - x))
            if x > x0:
                res.append("D" * (x - x0))
            if y > y0:
                res.append("R" * (y - y0))
            res.append("!")
            x0, y0 = x, y
        return "".join(res)


def stringToString(input):
    import json

    return json.loads(input)


def main():
    import sys
    import io

    def readlines():
        for line in io.TextIOWrapper(sys.stdin.buffer, encoding="utf-8"):
            yield line.strip("\n")

    lines = readlines()
    while True:
        try:
            line = next(lines)
            #target = stringToString(line)
            target = line
            ret = Solution().alphabetBoardPath(target)
            out = ret
            print(out)
            break
        except StopIteration:
            break


if __name__ == "__main__":
    main()
