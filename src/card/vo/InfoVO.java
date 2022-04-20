package card;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.HashMap;

/**
 * Value Object who has all the global information for the Current Session of Deckcard
 */
public class InfoVO {
    
    private String deckID;
    private List<CardVO> cards; // First Value Index, Second Type of Card
    private boolean loaded = false;
    
    /**
     * Data Object Constructor 
     */
    public InfoVO() {
        super();
        reset();
    }
    
    /**
     * To start the deck of cards
     */
    private void initDeckCard(){
        for (int j = 1 ; j<5; j++){
            for (int i = 1; i<13;i++){
                getCards().add(new CardVO(j,i));
            }
        }
        setLoaded(true);
    }
    
    /**
     * Starover the process
     */
    public void reset(){
        deckID = Services.getSingleton().getDeckID();
        if (cards == null)
            cards = new ArrayList<CardVO>();
        initDeckCard();
        randomize();
    }
    
    /**
     * The Deck of Cards
     * @return Array of Cards
     */
    public List<CardVO> getCards() {
        return cards;
    }
   
   /**
     * Method to get the DeckID
     * @return DeckID
     */
    public String getDeckID() {
        return deckID;
    }

    /**
     * Check if the Deck is uploaded
     * @return boolean flag
     */
    public boolean isLoaded() {
        return loaded;
    }
    
    /**
     * To starover the deck of cards, new alignment
     */
    public void randomize(){        
        Collections.shuffle(cards);
    }

    /**
     * Flag to control if the Deck is loaded
     * @param loaded boolean (True is Loaded, False Doesn't)
     */
    public void setLoaded(boolean loaded) {
        this.loaded = loaded;
    }
}
