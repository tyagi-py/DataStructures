# n = int(input())
# activity = []
# for i in range(n):
#     activity.append([int(i) for i in input().strip().split()])

# def keys(n):
#     return n[1]
# activity = sorted(activity,key= keys)

# count = 1
# d = 0

# for i in range(1,len(activity)):
#     if activity[i][0] >= activity[d][1]:
#         count+=1
#         d = i
# print(count)

n = int(input())
activity = []
for i in range(n):
    activity.append([int(i) for i in input().strip().split()])
"""The following implementation assumes that the activities 
are already sorted according to their finish time"""

"""Prints a maximum set of activities that can be done by a 
single person, one at a time"""
# n --> Total number of activities 
# s[]--> An array that contains start time of all activities 
# f[] --> An array that contains finish time of all activities 
count = 0
def printMaxActivities(s , f ): 
        global count
        n = len(f) 

	# The first activity is always selected 
        i = 0
	count +=1

	# Consider rest of the activities 
	for j in range(n): 

		# If this activity has start time greater than 
		# or equal to the finish time of previously 
		# selected activity, then select it 
		if s[j] >= f[i]: 
			count+=1 
			i = j 

s = [i[0] for i in activity]
f = [i[1] for i in activity]
printMaxActivities(s , f) 
print(count)
