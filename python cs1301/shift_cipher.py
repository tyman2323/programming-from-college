def main():
    word = input("What do you want to encode ")
    shift = int(input("How much do you want to shift by "))
    final = encode(word,shift)
    print("The encoded word is",final)
def encode(word,shift):
    final = ""
    for x in range(len(word)):
        c = word[x]
        final += chr((ord(c) + shift-65) % 26 + 65)
    return final
            
main()