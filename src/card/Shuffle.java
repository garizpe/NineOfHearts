package card;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Shuffle implements ActionListener {

    private card.Aceofspades parent;

    public Shuffle(card.Aceofspades parent) {
        super();
        this.parent = parent;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        parent.shuffle();
    }
}
