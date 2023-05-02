import re
def main():
    print(count_evens([1,2,1,2,1,3,4]))
    print(big_diff([3]))
    print(double_char("word"))
    print(count_code("coeecode"))
def count_evens(arr):
    even = 0
    for x in range(0,len(arr)):
        if(arr[x]%2==0):
            even+=1
    return even
def big_diff(arr):
    big = arr[0]
    small = arr[0]
    for x in range(0,len(arr)):
        if(big>arr[x]):
            big = arr[x]
        if(small<arr[x]):
            small = arr[0]
    return big - small
def double_char(word):
    new = ""
    word.split()
    for x in range(0,len(word)):
        temp = word[x]
        new = new + word[x] + word[x]
    return new
def count_code(word):
    f = len(re.findall("co.e", word))
    return f
main()    