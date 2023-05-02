amount = float(input("Dollar amount to be taxed "))
category = input("Catergory of goods to be taxed ")
age = int(input("What is your age "))
if(age > 90):
    print("the taxes owed is $0.00")
elif(age >= 65):
    if((category == "food") and (amount<=200) ):
       print(f"the taxes owed is ${amount*.015}")
    elif((category == "food") and (amount>200) ):
       print(f"the taxes owed is ${amount*.02}")
    elif(category == "baby items"):
        print(f"the taxes owed is ${amount*.0175}")
    else:
        print(f"the taxes owed is ${amount*.025}")
else:
    if((category == "food") and (amount<=200) ):
       print(f"the taxes owed is ${amount*.03}")
    elif((category == "food") and (amount>200) ):
       print(f"the taxes owed is ${amount*.04}")
    elif(category == "baby items"):
        print(f"the taxes owed is ${amount*.035}")
    else:
        print(f"the taxes owed is ${amount*.05}")
        