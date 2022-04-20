package card.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CloseAppListener implements ActionListener {
    public CloseAppListener() {
        super();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
}
