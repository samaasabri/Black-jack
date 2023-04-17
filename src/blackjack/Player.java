/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package blackjack;

/**
 *
 * @author computer store
 */
public class Player {
    
     private final String Name;
  private int  Score=0;
  private  Card cards_of_player[]= new Card[11] ;
  private boolean blackJack;
  private boolean lost;  
int  cuurent_card_no=0;
    public Player(String Name) {
        this.Name = Name;
       
    }

    public Card[] getCards_of_player() {
        return cards_of_player;
    }

    public int getCuurent_card_no() {
        return cuurent_card_no;
    }
  
  
public void AddPlayerCards(Card c)
{
    cards_of_player[cuurent_card_no]=c;
    Score+= c.getValue();
    cuurent_card_no++;
 
}

    public void setScore(int Score) {
        this.Score = Score;
    }

    public String getName() {
        return Name;
    }

  

    public int getScore() {
        return Score;
    }


    public boolean isBlackJack() {
        return blackJack;
    }

    public void setBlackJack(boolean blackJack) {
        this.blackJack = blackJack;
    }

    public boolean isLost() {
        return lost;
    }

    public void setLost(boolean lost) {
        this.lost = lost;
    }
  
}
