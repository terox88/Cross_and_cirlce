import javax.swing.*;
import java.awt.*;

public class GameButton extends JButton {

    public GameButton(String text) {
        super(text);
        Font font = new Font("Arial", Font.PLAIN, 55);
        this.setFont(font);
    }

}
