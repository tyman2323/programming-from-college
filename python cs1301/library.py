"""library.py
Author: Ayman Tawaalai
Version: 2-17-2023
This work complies with the GSU Honor Code
"""
books = ["Project Hail Mary","The Hobbit","Sherlock Holmes","The Hobbit","Dune"]
count = len(books)
print("Little Free Library\nCount:",count,"book(s)\n"+str(books))
want = input("Enter the title of the book you would like ")
print("We have",books.count(want), "of the book \""+want+"\" available")
want = int(input("Enter the index of the book youd like to take "))
print("You took \""+books[want]+"\"")
del books[want]
print(books)
want = input("What book would you like to leave? ")
books.append(want)
print(books)