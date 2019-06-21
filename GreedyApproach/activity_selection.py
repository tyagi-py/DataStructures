n = int(input())
activity = []
for i in range(n):
    activity.append([int(i) for i in input().strip().split()])

def keys(n):
    return n[1]
activity = sorted(activity,key= keys)

count = 1
d = 0

for i in range(1,len(activity)):
    if activity[i][0] >= activity[d][1]:
        count+=1
        d = i
print(count)