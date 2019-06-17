def indx(n):
    return n[1]

n = int(input())
l = []
for i in range(n):
    name, m1, m2, m3 = input().strip().split()
    l.append((name,int(m1)+int(m2)+int(m3)))

j = 1
for i in sorted(l, key= indx, reverse = True):
    print(j, i[0])
    j +=1
