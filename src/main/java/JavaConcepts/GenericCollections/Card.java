package JavaConcepts.GenericCollections;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Card {
    private final Face face;
    private final Suit suit;

    public static enum Face {Ace, Deuce, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Jack, Queen, King};
    public static enum Suit {Clubs, Diamonds, Hearts, Spades};


    public Card(Face face, Suit suit) {
        this.face = face;
        this.suit = suit;
    }

    public Face getFace() {
        return face;
    }

    public Suit getSuit() {
        return suit;
    }

    @Override
    public String toString() {
        return String.format("%s of %s", face, suit);
    }
}

 class DeckOfCards {
    private List<Card> list;

     public DeckOfCards() {
         Card[] deck = new Card[52];
         int count=0;
         for (Card.Suit suit1 : Card.Suit.values()) {
             for (Card.Face face1 : Card.Face.values()) {
                 deck[count] = new Card(face1, suit1);
             //    System.out.println(deck[count]);
                 ++count;
             }
         }
         list = Arrays.asList(deck);
         Collections.shuffle(list);
     }

     public void printCards () {
         for (int i =0; i<list.size(); i++) {
//             System.out.printf("%-19s%s", list.get(i), (i + 1) % 4 == 0 ? "%n":"");
//             System.out.printf((i + 1) % 4 == 0 ? "%n":"");

             System.out.printf("%-19s", list.get(i));
             System.out.printf((i + 1) % 4 == 0 ? "%n":"");
         }
     }

     public static void main(String[] args) {
         DeckOfCards cards = new DeckOfCards();
         cards.printCards();

     }

 }
