import sys

s = sys.stdin.readline().strip()
t = sys.stdin.readline().strip()
flag = True
for i in range(len(s)-len(t)+1):
    j = i
    while j < len(t)+i:
        if s[j] == t[j-i]:
            j += 1
        else:
            break
    if j == i + len(t):
        print("found")
        flag = False
        break
if flag:
    print("Not Found")