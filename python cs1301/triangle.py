x = int(input("how long should it go for "))
z = 1
y = x
while (x>0):
    while(y>0):
        print(y,end="")
        y-=1
    print("")
    x-=1
    y=x
print("____________________________________________________________________")
x = int(input("how long should it go for "))
z = 1
y = 0
while (z<=x):
    while(y<=z):
        print(z,end="")
        y+=1
    print("")
    y=0
    z+=1
print("____________________________________________________________________")
x = int(input("how long should it go for "))
z = 1
y = 1
while (z<=x):
    while(y<=z):
        if(z%2==0):
            print("1",end="")
        else:
            print("0",end="")
        y+=1
    print("")
    y=1
    z+=1
print("____________________________________________________________________")
x = int(input("how long should it go for "))
z = 1
y = 1
while (z<=x):
    while(y<=z):
        if(y%2==0):
            print("1",end="")
        else:
            print("0",end="")
        y+=1
    print("")
    y=1
    z+=1
    

    