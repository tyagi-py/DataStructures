import sys
def generateprime(primearr,n):
    boolprime=[True for i in range(n+1)] 
    p=2
    while(p*p<=n):
        if(boolprime[p]):
            for i in range(p*p,n+1,p):
                boolprime[i]=False
        p+=1
    #primearr=[0]*1000000
    primearr[2]=1
    
    for i in range(3,n+1):
        if(boolprime[i]==True):
            primearr[i]=(primearr[i-1]+1)
        else:
            primearr[i]=primearr[i-1]
    return
   
    
if __name__=='__main__':
    primearr=list()
    primearr=[0]*1000001
    generateprime(primearr,1000000)
    #print(primearr)
    T=int(sys.stdin.readline())
    while T:
        #a,b=list(map(int,input().split()))
        a,b= map(int, sys.stdin.readline().split(' '))

        if(a<=b):
            print(primearr[b]-primearr[a-1])
        else:
            print(primearr[a]-primearr[b-1])
 
        T-=1