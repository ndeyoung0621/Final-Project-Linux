package edu.gonzaga;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.Key;

public class KeyboardController extends Controller {
    private boolean ifPause=false;
    private JFrame frame;
    public KeyboardController(JFrame frame,TetrisGame game, GridPad gridPad) {
        super(gridPad);
        super.game=game;
        this.frame = frame;
    }

    public KeyboardController(JFrame frame, GridPad gridPad) {
        super(gridPad);
        this.frame = frame;
    }

    public void moveLeft() {
        controlBlock.moveLeft();
    }

    public void moveRight() {
        controlBlock.moveRight();
    }

    public void moveDown() {
        controlBlock.step();
        game.score++;
    }

    public void rotate(int direction) {
        controlBlock.rotate(direction);
    }
    public void pause() {
            ifPause=!ifPause;
            game.setPause(ifPause);
    }

    public void listenForKeyPressed() {
        frame.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {

            }

            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                if(keyCode==KeyEvent.VK_P){
                    pause();
                }
                if(!ifPause) {
                    // Check which key is pressed and call corresponding methods
                    if (keyCode == KeyEvent.VK_LEFT || keyCode == KeyEvent.VK_A) {
                        if (gridPad.movingCheck()[0]) {
                            moveLeft();
                        }
                    } else if (keyCode == KeyEvent.VK_RIGHT || keyCode == KeyEvent.VK_D) {
                        if (gridPad.movingCheck()[2]) {
                            moveRight();
                        }
                    } else if (keyCode == KeyEvent.VK_Z || keyCode == KeyEvent.VK_K || keyCode == KeyEvent.VK_UP) {
                        if (gridPad.rotateCheck(-1, controlBlock.getCenter())) {
                            rotate(-1);
                        }
                    } else if (keyCode == KeyEvent.VK_X || keyCode == KeyEvent.VK_L) {
                        if (gridPad.rotateCheck(-1, controlBlock.getCenter())) {
                            rotate(1);
                        }

                    } else if (keyCode == KeyEvent.VK_DOWN || keyCode == KeyEvent.VK_S) {
                        if (gridPad.movingCheck()[1]) {
                            moveDown();
                        }
                    }
                }

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }

        });
    }


    public void keyPressed(KeyEvent event) {
        int keyCode = event.getKeyCode();
        // Check which key is pressed and call corresponding methods
        if (keyCode == KeyEvent.VK_LEFT || keyCode == KeyEvent.VK_A) {
            if (gridPad.movingCheck()[0]) {
                moveLeft();
            }
        } else if (keyCode == KeyEvent.VK_RIGHT || keyCode == KeyEvent.VK_D) {
            if (gridPad.movingCheck()[2]) {
                moveRight();
            }
        } else if (keyCode == KeyEvent.VK_Z || keyCode == KeyEvent.VK_K || keyCode == KeyEvent.VK_UP) {
            if (gridPad.rotateCheck(-1, controlBlock.getCenter())) {
                rotate(-1);
            }
        } else if (keyCode == KeyEvent.VK_X || keyCode == KeyEvent.VK_L) {
            if (gridPad.rotateCheck(-1, controlBlock.getCenter())) {
                rotate(1);
            }

        } else if (keyCode == KeyEvent.VK_DOWN || keyCode == KeyEvent.VK_S) {
            if (gridPad.movingCheck()[1]) {
                moveDown();
            }
        }
    }
}
