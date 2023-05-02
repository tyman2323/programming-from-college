
x = [int(input("put in a number: ")),int(input("put in a number: ")),int(input("put in a number: ")),int(input("put in a number: "))]
for y in x:
    if (y%2) == 0:
        print(y)

print("_________________________________________________________________________")

x = input("What is the string?")
z = 0;
for y in x:
    if y.isalpha():
        z = z+ 1
print(z)

print("_________________________________________________________________________")

leapyear = False
x = int(input("What is the leap year: "))
if (x % 400 == 0) and (x % 100 == 0):
    print(x, "is a leap year")
    leapyear = True
elif (x % 4 ==0) and (x % 100 != 0):
    print(x, "is a leap year")
    leapyear = True
else:
    print(x,"is not a leap year")

print("_________________________________________________________________________")
x = int(input("Par: "))
stroke = int(input("Stroke: "))
if (x != 3) and (x != 4) and (x != 5):
    print("Error")
else:
    if stroke<=(x-2):
        print("Eagle")
    elif stroke <= (x-1):
        print("Birdie")
    elif stroke == x:
        print ("Par")
    else:
        print("Bogey")

