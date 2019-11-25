import sys




def closest(n, swap, less, greater):
    n = int(n)
    swap = int(swap)
    less = int(less)
    greater = int(greater)

    diff1 = abs(n-swap)
    diff2 = abs(n-less)
    diff3 = abs(n-greater)
    if diff2<= diff1 and diff2 <= diff3:
        return less
    elif diff1<=diff2 and diff1<=diff3:
        return swap
    else:

        return greater



def closest_p(n):

    if n == "10":
        return '9'
    if len(n) == 1:
        return n
    if len(n) == n.count('9'):
        return int(n)+2
    if n == "".join(reversed(n)):
        return n

    less = None
    greater = None
    only_swap = None

    # odd length
    if len(n)%2 != 0:

        odd = n[len(n)//2]

        # only swap
        only_swap = n[:len(n) // 2] + str(int(odd)) + "".join(reversed(n[:len(n) // 2]))

        # if not 0 or 9
        if odd != '0' and odd != '9':
            less = n[:len(n)//2] + str(int(odd)-1) + "".join(reversed(n[:len(n)//2]))
            greater = n[:len(n) // 2] + str(int(odd) + 1) + "".join(reversed(n[:len(n) // 2]))
        else:

            # if 0
            if odd == "0":
                fh = n[:len(n)//2]
                fh = str(int(fh)-1)
                less = fh + '9' + "".join(reversed(fh))
                greater = n[:len(n)//2] + '1' + "".join(reversed(n[:len(n)//2]))
            else:
                fh = n[:len(n)//2]
                fh = str(int(fh)+1)
                greater = fh + '8' + "".join(reversed(fh))
                less = n[:len(n)//2] + '8' + "".join(reversed(n[:len(n)//2]))
    # even length
    else:
        only_swap = n[:len(n)//2] + "".join(reversed(n[:len(n)//2]))
        fh = n[:len(n)//2]

        less = str(int(fh)-1) + "".join(reversed(str(int(fh)-1)))
        greater = str(int(fh)+1) + "".join(reversed(str(int(fh)+1)))

    return closest(n, only_swap, less, greater)




n = sys.stdin.readline().strip()
print(closest_p(n))



