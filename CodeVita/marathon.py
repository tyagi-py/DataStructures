n = int(input())
t = int(input())

racers = []
for _ in range(n):
    m = [int(i) for i in input().strip().split()]
    racers.append(m)

for i in range(n):
    for j in range(t+1):
        if j == 0:
            racers[i][j] *= racers[i][t]
        else:
            racers[i][j] = racers[i][j]*racers[i][t] + racers[i][j-1]

win = dict()
for i in range(n):
    max = 0
    for j in range(t+1):
        print(racers[i][j],end=" ")
    print()
