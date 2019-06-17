d = {1:'', 2:'abc',3:'def',4:'ghi',5:'jkl',6:'mno',7:'pqrs',8:'tuv',9:'wxyz',0:''}

def keypad(nos):
    if len(nos) == 0:
        return [""]
    small_res = keypad(nos[1:])
    res = []
    for i in d[nos[0]]:
        for j in small_res:
            res.append(i+j)
    
    return res
def rev(s):
    return s[::-1]
n = 354
nos = [int(i) for i in str(n)]
res  = keypad(nos)
res = sorted(res, key= rev)
for i in res:
    print(i)