import json

class Solution(object):
    def numUniqueEmails(self, emails):
        """
        :type emails: List[str]
        :rtype: int
        """
        email_set = set()
        for email in emails:
            local_name,domain_name = email.split("@")
            local_name ="".join(local_name.split('+')[0].split('.'))
            email = local_name +'@' + domain_name
            email_set.add(email)
        return len(email_set)

def stringToStringArray(input):
    return json.loads(input)

def intToString(input):
    if input is None:
        input = 0
    return str(input)

def main():
    import sys
    def readlines():
        for line in sys.stdin:
            yield line.strip('\n')
    lines = readlines()
    while True:
        try:
            line = lines.next()
            emails = stringToStringArray(line)
            ret = Solution().numUniqueEmails(emails)
            out = intToString(ret)
            print out
            break
        except StopIteration:
            break

if __name__ == '__main__':
    main()
