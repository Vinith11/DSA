for i in range(int(input())):
    x,y=map(int,input().split())
    if(x>=y):
        if(x-1==y+1 or x==y):
            print('YES')
    else:
        if(x-1==y-1):
            print('YES')
        else:
            print('NO')