package card.event;

import card.Aceofspades;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

public class MouseEventLabelListener  implements MouseListener {
    Aceofspades parent = null;
    
    public MouseEventLabelListener(Aceofspades parent) {
        this.parent = parent;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        parent.selectItemCard(((JLabel)mouseEvent.getSource()).getText());
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
