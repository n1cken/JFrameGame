package ni.preliators.game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

public class InputHandler implements KeyListener {

    public InputHandler (Game game) {
        game.addKeyListener(this);
    }

    public class Key {
        private int numTimesPressed = 0;
        private boolean tryckt = false;

        public int getNumTimesPressed() {
            return numTimesPressed;
        }

        public boolean arTryckt () {
            return tryckt;
        }

        public void toggle (boolean arTryckt) {
            tryckt = arTryckt;
            if (arTryckt) numTimesPressed++;
        }
    }

   // public List<Key> keys = new ArrayList<Key>();

    public Key up = new Key();
    public Key left = new Key();
    public Key down = new Key();
    public Key right = new Key();

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {   //If button is released: atTryckt = true
        toggleKey(e.getKeyCode(), true);
    }

    @Override
    public void keyReleased(KeyEvent e) {  //If button is released: atTryckt = false
        toggleKey(e.getKeyCode(), false);
    }

    public void toggleKey (int keyCode, boolean arTryckt) {
        if(keyCode == KeyEvent.VK_W || keyCode == KeyEvent.VK_UP) {
           up.toggle(arTryckt);
        }
        if(keyCode == KeyEvent.VK_A|| keyCode == KeyEvent.VK_LEFT) {
            left.toggle(arTryckt);
        }
        if(keyCode == KeyEvent.VK_S|| keyCode == KeyEvent.VK_DOWN) {
            down.toggle(arTryckt);
        }
        if(keyCode == KeyEvent.VK_D|| keyCode == KeyEvent.VK_RIGHT) {
            right.toggle(arTryckt);
        }

    }
}
