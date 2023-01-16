import java.awt.*;

public class TestGame {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Plato();
            }
        });
    }
}