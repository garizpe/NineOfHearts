package card.event;

import card.Aceofspades;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SkipActionListener implements ActionListener {
    private Aceofspades parent;
    public SkipActionListener(Aceofspades parent) {
        super();
        this.parent = parent;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
       parent.skipCard();
    }
}
