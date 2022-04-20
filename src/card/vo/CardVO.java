package card;

/**
 * Data Object of each Card of the Deck
 */
public class CardVO {
    private int figure;
    private int value;
    
    /**
     * Constructor 
     * @param figure to Identify if are Diamond, Hearts... etc
     * @param value The value of the Card
     */
    public CardVO(int figure, int value) {
        super();
        setFigure(figure);
        setValue(value);
    }

    /**
     * Setter of Figure (Diamond, Heart, etc)
     * @param figure Id of the Figure
     */
    public void setFigure(int figure) {
        this.figure = figure;
    }
    
    /**
     * Method to get the right image from HDD
     * @return name of the image
     */
    public String getFigure() {
        String text = "";
        switch(figure){
            case 1:text = "/card/images/i1.png";
                break;
            case 2:text = "/card/images/i2.png";
                break;
            case 3:text = "/card/images/i3.png";
                break;
            case 4:text = "/card/images/i4.png";
                break;
        }
        return text;
    }
    /**
     * Setter of Value of Card
     * @param value Value
     */
    public void setValue(int value) {
        this.value = value;
    }

    /**
     * Getter of Value of Card
     * @return Value of Card
     */
    public int getValue() {
        return value;
    }
    
    /**
     * Override the Object Method class toString
     * @return String with name of card
     */
    @Override
    public String toString(){
        String text = "";
        switch(value){
            case 1:text = " Ace";
                break;
            case 10:text = " Jack";
                break;
            case 11:text = " Queen";
                break;
            case 12:text = " King";
                break;
            default:
                text = " "+value;
             break;
        }
        return text;
    }
}
