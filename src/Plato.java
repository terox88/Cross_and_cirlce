import javax.imageio.ImageIO;
import javax.swing. *;
import java.awt. *;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;




import static javax.imageio.ImageIO.read;


public class Plato  extends JFrame {
    private int movesCounter;
    private boolean player1 = true;
    private boolean win = false;
    JPanel infoPanel;


    public Plato() {
        super("Cross and circle");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setLocation(50, 50);
        JPanel buttonPanel = new ButtonPanel();
        infoPanel = new InfoPanel();
        add(BorderLayout.CENTER, infoPanel);
        add(BorderLayout.NORTH, buttonPanel);
        setVisible(true);
        setResizable(false);


    }


    class ButtonPanel extends JPanel implements ActionListener {
        private JButton A0;
        private JButton B0;
        private JButton C0;
        private JButton A1;
        private JButton B1;
        private JButton C1;
        private JButton A2;
        private JButton B2;
        private JButton C2;


        public ButtonPanel() {

            this.setSize(300, 300);
            this.setLayout(new GridLayout(3, 3));
            A0 = new GameButton("");
            B0 = new GameButton("");
            C0 = new GameButton("");
            A1 = new GameButton("");
            B1 = new GameButton(":)");
            C1 = new GameButton("");
            A2 = new GameButton("");
            B2 = new GameButton("");
            C2 = new GameButton("");

            this.add(A0);
            this.add(B0);
            this.add(C0);
            this.add(A1);
            this.add(B1);
            this.add(C1);
            this.add(A2);
            this.add(B2);
            this.add(C2);
            A0.addActionListener(this);
            B0.addActionListener(this);
            C0.addActionListener(this);
            A1.addActionListener(this);
            B1.addActionListener(this);
            C1.addActionListener(this);
            A2.addActionListener(this);
            B2.addActionListener(this);
            C2.addActionListener(this);

        }


        @Override
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            if (!win) {
                if (player1) {
                    button.setText("X");


                } else {
                    button.setText("O");

                }
                if (button == A0) {
                    if ((button.getText().equals(B0.getText()) && button.getText().equals(C0.getText())) || (button.getText().equals(A1.getText()) && button.getText().equals(A2.getText())) || (button.getText().equals(B1.getText()) && button.getText().equals(C2.getText()))) {
                        win = true;
                    }
                } else if (button == B0) {
                    if ((button.getText().equals(A0.getText()) && button.getText().equals(C0.getText())) || (button.getText().equals(B1.getText()) && button.getText().equals(B2.getText()))) {
                        win = true;

                    }
                } else if (button == C0) {
                    if ((button.getText().equals(A0.getText()) && button.getText().equals(B0.getText())) || (button.getText().equals(C1.getText()) && button.getText().equals(C2.getText()))) {
                        win = true;
                    }
                } else if (button == A1) {
                    if ((button.getText().equals(B1.getText()) && button.getText().equals(C1.getText())) || (button.getText().equals(A0.getText()) && button.getText().equals(A2.getText()))) {
                        win = true;
                    }
                } else if (button == B1) {
                    if ((button.getText().equals(B0.getText()) && button.getText().equals(B2.getText())) || (button.getText().equals(A1.getText()) && button.getText().equals(C1.getText())) || (button.getText().equals(A0.getText()) && button.getText().equals(C2.getText())) || (button.getText().equals(C0.getText()) && button.getText().equals(A2.getText()))) {
                        win = true;
                    }
                } else if (button == C1) {
                    if ((button.getText().equals(C0.getText()) && button.getText().equals(C2.getText())) || (button.getText().equals(A1.getText()) && button.getText().equals(B1.getText()))) {
                        win = true;
                    }
                } else if (button == A2) {
                    if ((button.getText().equals(A0.getText()) && button.getText().equals(A1.getText())) || (button.getText().equals(B2.getText()) && button.getText().equals(C2.getText())) || (button.getText().equals(B1.getText()) && button.getText().equals(C0.getText()))) {
                        win = true;
                    }
                } else if (button == B2) {
                    if ((button.getText().equals(B0.getText()) && button.getText().equals(B1.getText())) || (button.getText().equals(A2.getText()) && button.getText().equals(C2.getText()))) {
                        win = true;
                    }
                } else if (button == C2) {
                    if ((button.getText().equals(C0.getText()) && button.getText().equals(C1.getText())) || (button.getText().equals(A2.getText()) && button.getText().equals(B2.getText())) || (button.getText().equals(B1.getText()) && button.getText().equals(A0.getText()))) {
                        win = true;
                    }
                }
            }
            player1 = !player1;
            infoPanel.repaint();
            movesCounter++;
            button.removeActionListener(this);
        }
    }

    class InfoPanel extends JPanel {

        public InfoPanel() {
            this.setSize(400, 100);
            this.setBackground(Color.WHITE);


        }


        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setFont(new Font("Arial",Font.BOLD, 25));


            if (movesCounter == 9) {
                g2d.drawString("Game over :(", 70, 25);
            }
            else if (win) {
                if (!player1) {
                    g2d.drawString("Player 1 wins!", 70, 25);
                } else {
                    g2d.drawString("Player 2 wins!", 70, 25);
                }
            }
            else if (player1) {

                g2d.drawString("Player's 1 turn", 70, 25);
            } else if (!player1) {
                g2d.drawString("Player's 2 turn", 70, 25);
            }


        }
    }
}
