slabs = [int(i) for i in input().strip().split()]
tax_applied = [int(i) for i in input().strip().split()]
rebate = int(input())
tax_paid = [int(i) for i in input().strip().split()]

salary_paid = 0

for t_p in tax_paid:
    r_t = t_p
    salary = slabs[0]
    for i in range(1,len(slabs)):
        mx_tx = ((slabs[i]-slabs[i-1])*tax_applied[i-1]) / 100
        if r_t > mx_tx:
            salary += slabs[i]
            r_t -= mx_tx
        else:
            salary += (100*r_t)/tax_applied[i-1]
            break
    salary += (100*r_t)/ tax_applied[-1]
    salary_paid += salary + rebate

print(salary)