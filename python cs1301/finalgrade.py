name = input("what is the students name ")
course = input("what is the course id ")
hw = float(input("what is the homework average"))
test = float(input("what is the test average"))
lab = float(input("what is the lab average"))
if(course == "CSC1301"):
    finalgrade = (hw *.2 + lab * .55 +test*.25)
    print(round(finalgrade,2))
elif(course == "CSC2510"):
    finalgrade = (hw *.45 + lab * .15 +test*.4)
    print(round(finalgrade,2))
elif(course == "CSC4520"):
    finalgrade = (hw *.3 + lab * .2 +test*.5)
    print(round(finalgrade,2))
else:
    print("This is not a course")