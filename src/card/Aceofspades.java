package card;

import card.event.CloseAppListener;
import card.event.MouseEventLabelListener;
import card.event.MouseEventListener;
import card.event.SkipActionListener;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.Window;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import card.vo.*;

/**
 * Main Class
 */
public class Aceofspades {

    JLabel gif, stopgif;
    JButton shuffleBtn;

    InfoVO infoVO = null;
    JPanel cardGraph = null, cardGraphSkip = null;
    List<CardVO> copyCards = new ArrayList<>();
    List<CardVO> destinyCards = new ArrayList<>();

    /**
     *  Init Graphic Mode
     * @param frame Main Frame
     */
    private void initGraphs(JFrame frame) {
        JPanel menu = new JPanel(new FlowLayout(FlowLayout.LEFT));
        menu.setBackground(Color.darkGray);
        Insets insets = frame.getInsets();
        menu.setBounds(0, 0, frame.getWidth(), 35);

        shuffleBtn = new JButton("Shuffle [startover]");
        JButton b2 = new JButton("Exit");

        //Image Credits to https://dribbble.com/shots/4871359-Cast-Iron-Card-Back-Shuffle
        ImageIcon imageIcon =
            new ImageIcon((new ImageIcon(Aceofspades.this.getClass().getResource("/card/images/shuffle.gif"))).getImage()
                          .getScaledInstance(250, 250, Image.SCALE_DEFAULT));

        gif = new JLabel(imageIcon);
        gif.setVisible(false); // not Shuffled
        stopgif =
            new JLabel(new ImageIcon((new ImageIcon(Aceofspades.this.getClass().getResource("/card/images/stop.png"))).getImage()
                                     .getScaledInstance(250, 250, Image.SCALE_DEFAULT)));

        //Sizes for images
        gif.setSize(305, 300);
        stopgif.setSize(305, 300);
        // Set Hand Cursor
        stopgif.setCursor(new Cursor(Cursor.HAND_CURSOR));

        JLabel deckID = new JLabel("DeckID:: " + infoVO.getDeckID());
        deckID.setSize(150, 30);
        deckID.setLocation(280, 40);
        deckID.setBackground(Color.red);

        JLabel cartTxt = new JLabel("Click on Card to Select one");
        cartTxt.setSize(250, 30);
        cartTxt.setLocation(40, 270);

        // Add Panel for Selected Card
        JScrollPane jscroll = new JScrollPane();
        cardGraph = new JPanel(new GridLayout(48, 1)); // 4 card types, 12 cards per type
        jscroll.setViewportView(cardGraph);
        jscroll.setLocation(590, 40);
        jscroll.setSize(200, 525);
        jscroll.setBackground(Color.black);
        
        // Add Panel for Selected Skip Card
        JScrollPane jscrollskip = new JScrollPane();
        cardGraphSkip = new JPanel(new GridLayout(48, 4)); // 4 card types, 12 cards per type
        jscrollskip.setViewportView(cardGraphSkip);
        jscrollskip.setLocation(10, 300);
        jscrollskip.setSize(500, 250);
        jscrollskip.setBackground(Color.black);
        
        // Add Button to Skip a Card from Original Deck
        JButton btnSkip = new JButton("Skip Card from Deck");
        btnSkip.addActionListener(new SkipActionListener(this));
        btnSkip.setLocation(280, 255);
        btnSkip.setSize(160, 20);

        // Add Listeners to Buttons
        shuffleBtn.addActionListener(new Shuffle(this));
        b2.addActionListener(new CloseAppListener());
        stopgif.addMouseListener(new MouseEventListener(this));

        Dimension size = shuffleBtn.getPreferredSize();

        // Rendering components
        menu.add(shuffleBtn);
        menu.add(b2);
        frame.add(menu);
        frame.add(gif);
        frame.add(stopgif);
        frame.add(deckID);
        frame.add(jscroll);
        frame.add(jscrollskip);
        frame.add(cartTxt);
        frame.add(btnSkip);
    }

    /**
     * Main Constructor
     */
    public Aceofspades() {
        super();
        infoVO = new InfoVO();
        copyCards.addAll(infoVO.getCards());
        JFrame frame = new JFrame("Shuffle Deck Cards");
        // set frame site
        frame.setMinimumSize(new Dimension(800, 600));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // control full layout of graphic components
        frame.setLayout(null);
        frame.setResizable(false);
        // draw basic controls
        initGraphs(frame);
        // display it
        frame.pack();
        frame.setVisible(true);
        centreWindow(frame);
    }

    /**
     * Method to get the Graphic Card selected from main Deck
     * Images from  --> https://es.wikipedia.org/wiki/Baraja_francesa
     * @param cardVO The right data of card
     * @return Graphic Component of Card
     */
    private JLabel getCard(CardVO cardVO) {
        // Set the ICON for
        ImageIcon icon =
            new ImageIcon((new ImageIcon(Aceofspades.this.getClass().getResource(cardVO.getFigure()))).getImage()
                          .getScaledInstance(10, 12, Image.SCALE_DEFAULT));
        JLabel field = new JLabel(cardVO.toString(), icon, JLabel.CENTER);
        field.setOpaque(true);
        field.setBackground(Color.WHITE);
        field.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.darkGray, 1),
                                                           BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        field.addMouseListener(new MouseEventLabelListener(this));
        return field;
    }

    /**
     * Utilitly to center Screen
     * @param frame The Frame
     */
    public static void centreWindow(Window frame) {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y);
    }

    /**
     * Entry Point to Java
     * @param args
     */
    public static void main(String[] args) {
        Aceofspades nine = new Aceofspades();
    }

    /**
     *  Method to initialize CardDeck
     */
    public void shuffle() {
        Timer timer;
        timer = new Timer();
        // Simulation of Web Communications or possible dealys between servers
        TimerTask task = new TimerTask() {
            int tic = 0;

            @Override
            public void run() // Thread just to show a litte of life to the app
            {
                if (tic == 0) {
                    gif.setVisible(true);
                    stopgif.setVisible(!gif.isVisible());
                    shuffleBtn.setEnabled(!gif.isVisible());
                    // Reset all Deck of Cards to restart the process
                    infoVO.reset();
                    // Copy locally the original Card sequence after randomize the maze
                    copyCards.addAll(infoVO.getCards());
                    //This is only to update the GUI
                    cardGraph.removeAll();
                    cardGraphSkip.removeAll();
                    // Swing has to notify the GUI about the memory removal
                    cardGraph.repaint();                    
                    cardGraphSkip.repaint();
                }
                
                if (tic >= 3) {
                    // End Timer and Finish process
                    timer.cancel();
                    timer.purge();
                    //Restore the Card to be Selected
                    gif.setVisible(false);
                    stopgif.setVisible(!gif.isVisible());
                    shuffleBtn.setEnabled(!gif.isVisible());
                    // Reset the whole Data Container
                    return;
                }
                tic++; // Tick Tack the clock
            }
        };
        timer.schedule(task, 10, 1000);
    }
    
    
/**
 * Select the card from Deck
 */
    public void selectCard() {
        if (!copyCards.isEmpty()) {
            CardVO cardVO = copyCards.get(0);
            destinyCards.add(cardVO);
            copyCards.remove(0);
            cardGraph.add(getCard(cardVO));
            cardGraph.repaint();
            cardGraph.updateUI();
        } else {
            JOptionPane.showMessageDialog(null, "No More Cards");
        }
    }

    /**
     *  Skip Card from Deck
     */
     public void skipCard(){
         if (!copyCards.isEmpty()) {
             CardVO cardVO = copyCards.get(0);
             copyCards.remove(0);
             cardGraphSkip.add(getCard(cardVO));
             cardGraphSkip.repaint();
             cardGraphSkip.updateUI();
         } else {
             JOptionPane.showMessageDialog(null, "No More Cards");
         }
     }

    public void selectItemCard(Object source){
        JOptionPane.showMessageDialog(null, source);
    }

}

//Internal Class to control the Mouselistener

