package card.event;

import card.Aceofspades;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseEventListener implements MouseListener {

    Aceofspades parent = null;
    //The only event used
    public MouseEventListener(Aceofspades parent) {
        this.parent = parent;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {        
        parent.selectCard();
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        // TODO Implement this method
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        // TODO Implement this method
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {
        // TODO Implement this method
    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {
        // TODO Implement this method
    }
}
