# def num_codes(n, size):
#     if size == 1 or size == 0:
#         return 1
    
#     output = num_codes(n, size- 1)
#     if n[size-2] * 10 + n[size-2] <= 26:
#         output += num_codes(n, size-2)
#     return output

# def num_codes(n, size, arr):
#     if size == 1 or size == 0:
#         return 1
#     if arr[size] > 0:
#         return arr[size]
#     output = num_codes(n, size- 1,arr)
#     if n[size-2] * 10 + n[size-2] <= 26:
#         output += num_codes(n, size-2,arr)
    
#     arr[size] = output
#     return output

def num_codes_iter(inp, size):
    output = [0 for i in range(size+1)]
    output[0] = 1
    output[1] = 1
    for i in range(2, size+1):
        output[i]= output[i-1]
        if inp[i-2] *10 + inp[i-1] <=26:
            output[i] += output[i-2]
    return output[size]

numbers = []

while True:
    inp =  [int(i) for i in input().strip()]
    if inp:
        numbers.append(inp)
    if inp == [0]:
        
        for i in numbers[:-1]:
            arr = [ 0 for i in range(len(i)+1)]
            print(num_codes_iter(i, len(i))%1000000007)
        break

