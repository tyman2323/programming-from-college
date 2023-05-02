import math
import re
def removedig(string):
    st = re.sub(r'\d+', '', string)
    return st
def midfix(string):
    tot = len(string);
    half = tot/2
    half-=1
    math.floor(half)
    half = (int(half))
    halfo = half + 3
    i = 1
    string = string[half:halfo]
    return string
def twosmal(listy):
    listy.sort();
    return listy[0], listy[1]
def roster():
    key = [1,2,3,4,5]
    jers = [1,2,3,4,5]
    rost = {}
    for x in range(len(key)):
        key[x] = input(f"enter player{x+1} name:")
        jers[x] = int(input(f"enter player{x+1} jersey:"))
    for x in range(len(key)):
        rost[key[x]] = jers[x]
    rost = dict(sorted(rost.items()))
    for x, y in rost.items():
        print(f"Player number: {y} ,Player name: {x}")
print(removedig("123toy123"))
print(midfix("xxxxoooxxxx"))
print(twosmal([4,21,21,4,2,3,1,5]))
roster()
