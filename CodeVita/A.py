n = int(input())
i = int(input())

x = (n/360)*i

a = int(x)
f = x-a

mi = 0.6*f
mi = mi*100

a = a%12

def calAngle(h,m):
    if h == 12:
        h = 0
    if m == 60:
        m = 0
    hr_a = 0.5 * (h*60 + m)
    mi_a = 6 * m

    ang = abs(hr_a - mi_a)
    ang = min (360- ang, ang)

    return ang
ans = calAngle(a, mi)
print('{:.2f}'.format(ans), end='')