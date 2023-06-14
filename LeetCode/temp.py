movies=[]

def add():
    name=input("Enter Movie name: ")
    print("Enter Year released and rating")
    year,rate=map(int,input().split())
    movies.append([name,year,rate])

def dele():
    name=input("Enter Movie name: ")
    for i in range(len(movies)):
        if(movies[i][0]==name):
            movies.remove(movies[i])

def display():
    for i in movies:
        for j in i:
            print(j,end=" ")
        print()
    print()

def search():
    name=input("Enter Movie name: ")
    for i in range(len(movies)):
        if(movies[i][0]==name):
            for j in movies[i]:
                print(j,end=" ")
            print()
            

if __name__=='__main__':
    while(1):
        print("1 ADD MOVIE\n2 DELETE MOVIE\n3 VIEW LIST\n4 SEARCH MOVIE\n5 EXIT")
        choice=int(input())
        print()
        
        if(choice==1):
            add()
        elif(choice==2):
            dele()
        elif(choice==3):
            display()
        elif(choice==4):
            search()
        else:
            break