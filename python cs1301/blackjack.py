card1 = input("Enter the first card ")
card2 = input("Enter the second card ")
card_tuple = ('0','A','2','3','4','5','6','7','8','9','10')
royal_card = ('J','Q','K')
if((card1 in card_tuple) and (card2 in card_tuple)):
    x = card_tuple.index(card1)
    y = card_tuple.index(card2)
    summ = x + y
elif((card1 in card_tuple) and (card2 in royal_card)):
    x = card_tuple.index(card1)
    y = royal_card.index(card2)* 10
    summ = x + y
elif((card1 in royal_card) and (card2 in card_tuple)):
    x = royal_card.index(card1)* 10
    y = card_tuple.index(card2)
    summ = x + y
elif((card1 in royal_card) and (card2 in royal_card)):
    x = royal_card.index(card1) * 10
    y = royal_card.index(card2)* 10
    summ = x + y
if(summ==21):
    print("Blackjack!")
elif(summ<21):
    print("Hit")
else:
    print("Stand")