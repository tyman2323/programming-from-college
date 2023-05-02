import math
def sumofall(given):
    if given < 1:
        return given
    return given + sumofall(given - 1)
def sumodd(listt):
    for x in listt:
        if (x%2)!= 0:
            print(x,end= ",")
def sumeven(listt):
    for x in listt:
        if (x%2)== 0:
            print(x,end= ",")
def perfect(listt):
    for x in listt:
        if(math.sqrt(x))==int(math.sqrt(x)):
            print(x, end=",")
def main():
    listt = [1,2,3,4,5,6,7,8,9]
    print(sumofall(10))
    sumodd(listt)
    print()
    sumeven(listt)
    print()
    perfect(listt)
main()
