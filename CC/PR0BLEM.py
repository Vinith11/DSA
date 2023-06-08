# for i in range(int(input())):
#     x,y=map(int,input().split())
#     if(x>=y):
#         if(x-1==y+1 or x==y):
#             print('YES')
#     else:
#         if(x+3==y-1):
#             print('YES')
#         else:
#             print('NO')

for i in range(int(input())):
    x,y=map(int,input().split())
    difference = x-y
    
    if difference == 0:
        print('YES')
    elif difference == 1 or difference == 3:
        print('NO')
    elif difference == 2 or difference == 4:
        print('YES')
    else:
        print('NO')