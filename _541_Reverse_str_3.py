class Solution(object):
    def reverseWords(self, l):
        s=l.split(" ")

        for i in range(len(s)):
            s[i]=s[i][::-1]

        separator = ' '

        joined_string = separator.join(s)

        return joined_string