for i in range(int(input())):
    x,y=map(int,input().split())
    z=x*y
    z=str(z)
    if(z[0]=='0' or len(z)!=5):
        print('NO')
    else:
        print('YES')
