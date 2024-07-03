package SnakeGame.Main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener {

    private final int Body_width = 300; // Board body-width
    private final int Body_height = 300; // Board
    private final int Dot_size = 10;
    private final int All_dots = 900; // Total dots
    private final int Randam_pos = 29;
    private final int Time_delay = 140; // time taken for next dot.

    private final int x[] = new int[All_dots]; // these 2 arrays represent the position in the board.
    private final int y[] = new int[All_dots];

    private int dots;
    private int apple_x; // used in doDrawing function.
    private int apple_y; // Used in doDrawing function.

    private boolean leftdirection = false;
    private boolean rightdirection = true; // Initially a snake can go only in the right side of the board.
    private boolean updirection = false;
    private boolean downdirection = false;
    private boolean inGame = true; // Snake in game

    private Timer timer;
    private Image dot;
    private Image apple;
    private Image head;

    public Board() {
        initBoard();
    }

    private void initBoard() { // This function is used to initialize the board
        addKeyListener(new TAdapter());
        setBackground(Color.black);
        setFocusable(true);

        setPreferredSize(new Dimension(Body_width, Body_height)); // Board size.
        loadImages(); // the images are loaded in the board.
        initGame(); // The game will be initialized after loading the image.
    }

    private void loadImages() {
        ImageIcon dot_icon = new ImageIcon("D:\\JAVA\\PROJECTS\\SnakeGame\\dot.png"); // gets dot icon from the src.
        dot = dot_icon.getImage();

        ImageIcon apple_icon = new ImageIcon("D:\\JAVA\\PROJECTS\\SnakeGame\\apple.png"); // gets the apple icon from the src.
        apple = apple_icon.getImage();

        ImageIcon head_icon = new ImageIcon("D:\\JAVA\\PROJECTS\\SnakeGame\\head.png"); // gets the head icon from the src.
        head = head_icon.getImage();
    }

    private void initGame() { // Game starts by this function
        dots = 3;

        for (int z = 0; z < dots; z++) {
            x[z] = 50 - z * 10;
            y[z] = 50;
        }

        locateApple();

        timer = new Timer(Time_delay, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) { // This function makes the graphics for board
        super.paintComponent(g);
        doDrawing(g);
    }

    private void doDrawing(Graphics g) { // Drawing function
        if (inGame) {
            g.drawImage(apple, apple_x, apple_y, this); // create an apple image on board

            for (int z = 0; z < dots; z++) {
                if (z == 0) {
                    g.drawImage(head, x[z], y[z], this); // create snake head
                } else {
                    g.drawImage(dot, x[z], y[z], this); //
                }
            }
            Toolkit.getDefaultToolkit().sync();
        } else {
            gameOver(g);
        }
    }

    private void gameOver(Graphics g) { // after gameOver this function should be called.
        String msg = "Game Over";
        Font small = new Font("Arial", Font.BOLD, 14);
        FontMetrics fm = getFontMetrics(small);

        g.setColor(Color.white);
        g.setFont(small);
        g.drawString(msg, (Body_width - fm.stringWidth(msg)) / 2, Body_height / 2);
    }

    private void checkApple() {
        if ((x[0] == apple_x) && (y[0] == apple_y)) {
            dots++;
            locateApple();
        }
    }

    private void move() {
        for (int z = dots; z > 0; z--) {
            x[z] = x[(z - 1)];
            y[z] = y[(z - 1)];
        }

        if (leftdirection) {
            x[0] -= Dot_size;
        }
        if (rightdirection) {
            x[0] += Dot_size;
        }
        if (updirection) {
            y[0] -= Dot_size;
        }
        if (downdirection) {
            y[0] += Dot_size;
        }
    }

    private void checkCollision() {
        for (int z = dots; z > 0; z--) {
            if ((z > 4) && (x[0] == x[z]) && (y[0] == y[z])) {
                inGame = false;
            }
        }
        if (y[0] >= Body_height) {
            inGame = false;
        }
        if (y[0] < 0) {
            inGame = false;
        }
        if (x[0] >= Body_height) {
            inGame = false;
        }
        if (x[0] < 0) {
            inGame = false;
        }
        if (!inGame) {
            timer.stop();
        }
    }

    private void locateApple() {
        int r = (int) (Math.random() * Randam_pos);
        apple_x = ((r * Dot_size));

        r = (int) (Math.random() * Randam_pos);
        apple_y = ((r * Dot_size));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (inGame) {
            checkApple();
            checkCollision();
            move();
        }
        repaint();
    }

    private class TAdapter extends java.awt.event.KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            if ((key == KeyEvent.VK_LEFT) && (!rightdirection)) {
                leftdirection = true;
                updirection = false;
                downdirection = false;
            }
            if ((key == KeyEvent.VK_RIGHT) && (!leftdirection)) {
                rightdirection = true;
                updirection = false;
                downdirection = false;
            }
            if ((key == KeyEvent.VK_UP) && (!downdirection)) {
                leftdirection = false;
                updirection = true;
                rightdirection = false;
            }
            if ((key == KeyEvent.VK_DOWN) && (!updirection)) {
                leftdirection = false;
                rightdirection = false;
                downdirection = true;
            }
        }
    }
}
