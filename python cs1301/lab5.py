import math
#length = float(input("How many miles did you race? "))
#print("How much time did that take you")
#hours = int(input("Hours: "))
#minutes = int(input("Minutes: "))
#seconds = int(input("Seconds: "))
#total = minutes/60 + seconds/3600

print("_____________________________________________________________________________")
feet = int(input("Enter the total number of feet: "))
miles = feet//5280
furlongs = (feet%5280)//660
feet = (feet%5280)%660
print("That will be", miles , "miles", furlongs, "furlongs and",feet,"feet.")
print("_____________________________________________________________________________")
x = float(input("What is x? "))
y = float(input("What is y? "))
z = float(input("What is z? "))
firstpow = math.pow(x,z)
secondpow = math.pow(x,math.pow(y,z))
third = abs(x-y)
fourth = math.sqrt(firstpow)

print(f'{firstpow:.2f} {secondpow:.2f} {third:.2f} {fourth:.2f}')
print("____________________________________________________________________________")
key1 = float(input("Enter the key"))
r = math.pow(2,(1/12))
key2 = key1 * r
key3 = key2 * r
key4 = key3 * r
key5 = key4 *r
print(f'{key1:.2f} {key2:.2f} {key3:.2f} {key4:.2f} {key5:.2f}')
print("____________________________________________________________________________")
people = int(input("How many attendees? "))
totalslice = people * 2
pizzas = math.ceil(totalslice/12)
price = pizzas * 14.95
print(f'Cost = ${price:.2f}')



